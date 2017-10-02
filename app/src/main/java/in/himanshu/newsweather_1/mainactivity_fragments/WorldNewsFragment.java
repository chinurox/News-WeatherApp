package in.pradumn.newsweather_1.mainactivity_fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.ArrayList;

import in.pradumn.newsweather_1.R;
import in.pradumn.newsweather_1.datastructures.News;
import in.pradumn.newsweather_1.interfaces.ApiService;
import in.pradumn.newsweather_1.interfaces.CollapsingToolbarInterface;
import in.pradumn.newsweather_1.recyclerviewadapters.TopNewsRecyclerViewAdapter;
import in.pradumn.newsweather_1.responses.MashapeResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class WorldNewsFragment extends Fragment implements CollapsingToolbarInterface {
    RecyclerView recyclerView;
    TopNewsRecyclerViewAdapter worldNewsRecyclerViewAdapter;
    ArrayList<News> news;
    View fragmentView;
    LayoutInflater mInflater;
    ViewGroup mContainer;
    ProgressBar progressBar;
    ImageView retryImage;
    int collapsingToolbarId= R.drawable.world_news;
    final int STATE_CONNECTED= 1;
    final int STATE_CONNECTING= 0;
    final int STATE_FAILED= 2;

    public WorldNewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mInflater= inflater;
        mContainer= container;
        fragmentView= inflater.inflate(R.layout.fragment_world_news,container,false);

        recyclerView= (RecyclerView) fragmentView.findViewById(R.id.worldNewsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        news= new ArrayList<>();
        worldNewsRecyclerViewAdapter= new TopNewsRecyclerViewAdapter(getActivity(),news,getActivity().getAssets(),"World News");
        recyclerView.setAdapter(worldNewsRecyclerViewAdapter);
        progressBar= (ProgressBar) fragmentView.findViewById(R.id.progressBar1);
        retryImage= (ImageView) fragmentView.findViewById(R.id.retry);

        retryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNews();
            }
        });

        getNews();
        return fragmentView;
    }

    private void getNews() {
        connectionDrawableVisibility(STATE_CONNECTING);

        Retrofit retrofit= new Retrofit.Builder().baseUrl("https://dev132-toi-times-of-india-v1.p.mashape.com/").addConverterFactory(GsonConverterFactory.create()).build();
        ApiService service= retrofit.create(ApiService.class);
        Call<MashapeResponse> call= service.getWorldNews("J7AdboyBubmshpah8ihTxZZl4aKQp1teQBOjsnCbfz3CcwcEEQ","application/json");
        call.enqueue(new Callback<MashapeResponse>() {
            @Override
            public void onResponse(Call<MashapeResponse> call, Response<MashapeResponse> response) {
                Log.i("network","success");
                ArrayList<MashapeResponse.MashapeNews> newWithoutParses= response.body().getNewsItem();

                for(MashapeResponse.MashapeNews i: newWithoutParses) {
                    News newNews= new News();
                    newNews.headline= i.HeadLine;
                    newNews.story=i.Story;
                    MashapeResponse.MashapeNews.MashapePhoto photo= i.Image;
                    newNews.newsPosterPath= photo.getPhoto();

                    news.add(newNews);
                }
                worldNewsRecyclerViewAdapter.notifyDataSetChanged();
                connectionDrawableVisibility(STATE_CONNECTED);
            }

            @Override
            public void onFailure(Call<MashapeResponse> call, Throwable t) {
                connectionDrawableVisibility(STATE_FAILED);
            }
        });
    }
    @Override
    public int getCollapsingToolbarId() {
        return collapsingToolbarId;
    }

    public void connectionDrawableVisibility(int state) {
        if(state== STATE_CONNECTING) {
            progressBar.setVisibility(View.VISIBLE);
            retryImage.setVisibility(View.GONE);
        }
        else if(state== STATE_CONNECTED) {
            progressBar.setVisibility(View.GONE);
            retryImage.setVisibility(View.GONE);
        }
        else if(state== STATE_FAILED) {
            progressBar.setVisibility(View.GONE);
            retryImage.setVisibility(View.VISIBLE);
        }
    }
}

