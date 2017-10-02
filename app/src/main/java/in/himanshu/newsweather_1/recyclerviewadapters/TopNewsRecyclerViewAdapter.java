package in.pradumn.newsweather_1.recyclerviewadapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import in.pradumn.newsweather_1.others.IntentConstants;
import in.pradumn.newsweather_1.R;
import in.pradumn.newsweather_1.activities.NewsActivity;
import in.pradumn.newsweather_1.datastructures.News;

/**
 * Created by Pradumn on 28-Sep-16.
 */
public class TopNewsRecyclerViewAdapter extends RecyclerView.Adapter<TopNewsRecyclerViewAdapter.ViewHolder> {

    Context mContext;
    ArrayList<News> mNews;
    String mFragmentName;
    LayoutInflater layoutInflater;
    AssetManager mAssetManager;

    public TopNewsRecyclerViewAdapter(Context context,ArrayList<News> newses, AssetManager assetManager,String fragmentName) {
        this.mNews= newses;
        this.mAssetManager= assetManager;
        this.mContext= context;
        this.layoutInflater= LayoutInflater.from(context);
        this.mFragmentName= fragmentName;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= layoutInflater.inflate(R.layout.recyclerview_item_layout,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position) {
        final int tempPosition= position;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent.putExtra(IntentConstants.TITLE_TO_NEWS_ACTIVITY,mFragmentName);
                intent.putExtra(IntentConstants.HEADLINE_TO_NEWS_ACTIVITY,mNews.get(tempPosition).headline);
                intent.putExtra(IntentConstants.PHOTOPATH_TO_NEWS_ACTIVITY,mNews.get(tempPosition).newsPosterPath);
                intent.putExtra(IntentConstants.DESCRIPTION_TO_NEWS_ACTIVITY,mNews.get(tempPosition).story);
                intent.setClass(mContext,NewsActivity.class);
                mContext.startActivity(intent);
            }
        });
        Typeface myFont= Typeface.createFromAsset(mAssetManager,"headlinenews_font.ttf");
        holder.headlineTextView.setTypeface(myFont);
        holder.headlineTextView.setText(mNews.get(position).headline);
        Picasso.with(mContext).load(mNews.get(position).newsPosterPath).into(holder.newsPosterImageView);
    }

    @Override
    public int getItemCount() {
        return mNews.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView newsPosterImageView;
        TextView headlineTextView;
        View itemView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView= itemView;
            newsPosterImageView= (ImageView) itemView.findViewById(R.id.newsPosterImageView);
            headlineTextView= (TextView) itemView.findViewById(R.id.headlineTextView);
        }
    }
}
