package in.pradumn.newsweather_1.activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.lid.lib.LabelImageView;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import in.pradumn.newsweather_1.datastructures.News;
import in.pradumn.newsweather_1.others.IntentConstants;
import in.pradumn.newsweather_1.R;

public class NewsActivity extends AppCompatActivity {
    ImageView imageView;
    Toolbar toolbar;
    TextView headlineTextView;
    TextView descriptionTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        toolbar= (Toolbar) findViewById(R.id.news_activity_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getIntent().getStringExtra(IntentConstants.TITLE_TO_NEWS_ACTIVITY));
        toolbar.setTitleTextColor(Color.WHITE);

        imageView= (ImageView) findViewById(R.id.newsPosterImageView);
        //labelImageView= (LabelImageView) findViewById(R.id.newsPosterLabelImageView);
        Picasso.with(NewsActivity.this).load(getIntent().getStringExtra(IntentConstants.PHOTOPATH_TO_NEWS_ACTIVITY)).into(imageView);

        headlineTextView= (TextView) findViewById(R.id.headlineTextView);
        descriptionTextView= (TextView) findViewById(R.id.descriptionTextView);
        Typeface myFont= Typeface.createFromAsset(getAssets(),"RobotoSlab-Regular.ttf");
        headlineTextView.setText(getIntent().getStringExtra(IntentConstants.HEADLINE_TO_NEWS_ACTIVITY));
        headlineTextView.setTypeface(myFont);
        descriptionTextView.setText(getIntent().getStringExtra(IntentConstants.DESCRIPTION_TO_NEWS_ACTIVITY));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.newsactivity_optionsmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()== R.id.MenuBookmark) {
            if(!isBookmarked()) {
                bookmarkNews();
            }
        }
        return true;
    }

    public boolean isBookmarked() {
        List<News> bookmarkedNewses= SQLite.select().from(News.class).queryList();
        for(News i:bookmarkedNewses) {
            if(getIntent().getStringExtra(IntentConstants.HEADLINE_TO_NEWS_ACTIVITY).equals(i.headline))
                return true;
        }
        return false;
    }

    public void bookmarkNews() {
        News newBookmarkedNews= new News();
        newBookmarkedNews.headline= getIntent().getStringExtra(IntentConstants.HEADLINE_TO_NEWS_ACTIVITY);
        newBookmarkedNews.story= getIntent().getStringExtra(IntentConstants.DESCRIPTION_TO_NEWS_ACTIVITY);

        String memoryPath="";
        File sdCard= Environment.getExternalStorageDirectory();
        File folder= new File(sdCard.getAbsoluteFile(),".PhotoDirectory");
        folder.mkdir();
        File file= new File(folder.getAbsoluteFile(),getIntent().getStringExtra(IntentConstants.HEADLINE_TO_NEWS_ACTIVITY)+ ".jpg");
        Bitmap bitmap= ((BitmapDrawable) imageView.getDrawable()).getBitmap();

        try {
            FileOutputStream out= new FileOutputStream(file);
            if(bitmap== null) {
                Log.i("bitmap","null");
            }
            else {
                bitmap.compress(Bitmap.CompressFormat.JPEG,90,out);
            }
            out.flush();
            out.close();
            memoryPath= file.getPath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        newBookmarkedNews.photoMemoryPath= memoryPath;
        newBookmarkedNews.save();
    }
}
