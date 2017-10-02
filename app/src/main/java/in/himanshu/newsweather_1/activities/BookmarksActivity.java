package in.pradumn.newsweather_1.activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;

import in.pradumn.newsweather_1.R;
import in.pradumn.newsweather_1.datastructures.News;
import in.pradumn.newsweather_1.recyclerviewadapters.TopNewsRecyclerViewAdapter;

public class BookmarksActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    TopNewsRecyclerViewAdapter bookmarksNewsRecyclerViewAdapter;
    ArrayList<News> news;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmarks);

        toolbar= (Toolbar) findViewById(R.id.bookmarks_activity_toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Bookmarks");

        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(BookmarksActivity.this));
        news= (ArrayList<News>) SQLite.select().from(News.class).queryList();
        bookmarksNewsRecyclerViewAdapter= new TopNewsRecyclerViewAdapter(BookmarksActivity.this,news,getAssets(),"Bookmarks");
        recyclerView.setAdapter(bookmarksNewsRecyclerViewAdapter);
    }
}
