package in.pradumn.newsweather_1.recyclerviewadapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

import in.pradumn.newsweather_1.R;
import in.pradumn.newsweather_1.activities.NewsActivity;
import in.pradumn.newsweather_1.datastructures.News;
import in.pradumn.newsweather_1.others.IntentConstants;

/**
 * Created by Pradumn on 05-Jan-17.
 */
public class BookmarksActivityRecyclerViewAdapter extends RecyclerView.Adapter<BookmarksActivityRecyclerViewAdapter.ViewHolder>{
    Context mContext;
    ArrayList<News> mNewses;
    String mActivityName;
    LayoutInflater mLayoutInflater;

    public BookmarksActivityRecyclerViewAdapter(Context context, ArrayList<News> newses,String activityName) {
        this.mContext= context;
        this.mNewses= newses;
        this.mActivityName= activityName;
        this.mLayoutInflater= LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= mLayoutInflater.inflate(R.layout.bookmarks_recyclerview_item,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final int tempPosition= position;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent.putExtra(IntentConstants.TITLE_TO_NEWS_ACTIVITY,mActivityName);
                intent.putExtra(IntentConstants.HEADLINE_TO_NEWS_ACTIVITY,mNewses.get(tempPosition).headline);
                intent.putExtra(IntentConstants.PHOTOPATH_TO_NEWS_ACTIVITY,mNewses.get(tempPosition).newsPosterPath);
                intent.putExtra(IntentConstants.DESCRIPTION_TO_NEWS_ACTIVITY,mNewses.get(tempPosition).story);
                intent.setClass(mContext,NewsActivity.class);
                mContext.startActivity(intent);
            }
        });
        holder.headlineTextView.setText(mNewses.get(position).headline);
        Bitmap bitmap= BitmapFactory.decodeFile(mNewses.get(position).photoMemoryPath);
        holder.newsPosterImageView.setImageBitmap(bitmap);
        holder.overflowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final PopupMenu popupMenu= new PopupMenu(mContext,view);
                popupMenu.getMenuInflater().inflate(R.menu.bookmarks_popmenu,popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if(menuItem.getItemId()== R.id.removeFromList) {
                            News current= mNewses.get(position);
                            mNewses.remove(position);
                            current.delete();
                        }
                        return true;
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNewses.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView newsPosterImageView;
        TextView headlineTextView;
        TextView overflowButton;
        View itemView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView= itemView;
            newsPosterImageView= (ImageView) itemView.findViewById(R.id.newsPosterImageView);
            headlineTextView= (TextView) itemView.findViewById(R.id.headlineTextView);
            overflowButton= (TextView) itemView.findViewById(R.id.overflowButton);
        }
    }
}
