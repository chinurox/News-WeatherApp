package in.pradumn.newsweather_1.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import in.pradumn.newsweather_1.R;
import in.pradumn.newsweather_1.adapters.ViewPagerAdapter;
import in.pradumn.newsweather_1.interfaces.CollapsingToolbarInterface;
import in.pradumn.newsweather_1.mainactivity_fragments.BusinessNewsFragment;
import in.pradumn.newsweather_1.mainactivity_fragments.EntertainmentNewsFragment;
import in.pradumn.newsweather_1.mainactivity_fragments.EventsFragment;
import in.pradumn.newsweather_1.mainactivity_fragments.IndiaNewsFragment;
import in.pradumn.newsweather_1.mainactivity_fragments.LifeandstyleFragment;
import in.pradumn.newsweather_1.mainactivity_fragments.SportsNewsFragment;
import in.pradumn.newsweather_1.mainactivity_fragments.TopStoriesFragment;
import in.pradumn.newsweather_1.mainactivity_fragments.TvFragment;

public class EntertainmentAndEventsActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    ArrayList<Fragment> fragments;
    ArrayList<String> fragmentNames;
    ImageView collapsingToolbarImageView;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Bitmap bitmap;
    NestedScrollView nestedScrollView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer_layout);

        toolbar= (Toolbar) findViewById(R.id.app_bar);
        collapsingToolbarLayout= (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        drawerLayout= (DrawerLayout) findViewById(R.id.drawerLayout);
        View headerView= View.inflate(EntertainmentAndEventsActivity.this,R.layout.header_navigation_drawer_layout,null);
        TextView headerTextView= (TextView) headerView.findViewById(R.id.headerTextView);
        Typeface headerFont= Typeface.createFromAsset(getAssets(),"Roboto-Bold.ttf");
        headerTextView.setTypeface(headerFont);
        navigationView= (NavigationView)findViewById(R.id.navigationView);
        navigationView.setCheckedItem(R.id.EntertainmentAndEvents);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()== R.id.Home) {
                    drawerLayout.closeDrawers();
                    startActivity(new Intent(EntertainmentAndEventsActivity.this,MainActivity.class));
                }
                else if(item.getItemId()== R.id.ScienceAndTechnology) {
                    drawerLayout.closeDrawers();
                    startActivity(new Intent(EntertainmentAndEventsActivity.this,ScienceAndTechnologyActivity.class));
                }
                else if(item.getItemId()== R.id.WorldAndNation) {
                    drawerLayout.closeDrawers();
                    startActivity(new Intent(EntertainmentAndEventsActivity.this,WorldAndNationActivity.class));
                }
                else if(item.getItemId()== R.id.EntertainmentAndEvents) {
                    drawerLayout.closeDrawers();
                }
                else if(item.getItemId()== R.id.Bookmarks) {
                    drawerLayout.closeDrawers();
                    startActivity(new Intent(EntertainmentAndEventsActivity.this,BookmarksActivity.class));
                }
                else if(item.getItemId()== R.id.Weather) {
                    drawerLayout.closeDrawers();
                    startActivity(new Intent(EntertainmentAndEventsActivity.this,WeatherActivity.class));
                }
                else if(item.getItemId()== R.id.Settings) {

                }
                return true;
            }
        });

        tabLayout= (TabLayout) findViewById(R.id.tabLayout);
        viewPager= (ViewPager) findViewById(R.id.viewPager);
        fragments= new ArrayList<>();
        fragmentNames= new ArrayList<>();
        fragments.add(new EntertainmentNewsFragment());
        fragments.add(new TvFragment());
        fragments.add(new EventsFragment());
        fragments.add(new LifeandstyleFragment());
        fragmentNames.add("Entertainment");
        fragmentNames.add("TV");
        fragmentNames.add("Events");
        fragmentNames.add("Life And Style");
        viewPagerAdapter= new ViewPagerAdapter(getSupportFragmentManager(),fragments,fragmentNames);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);



        nestedScrollView= (NestedScrollView) findViewById(R.id.nestedScrollView);
        nestedScrollView.setFillViewport(true);

        collapsingToolbarImageView= (ImageView) findViewById(R.id.collapsingToolbarImageView);
        if(fragments.get(0) instanceof CollapsingToolbarInterface) {
            collapsingToolbarImageView.setImageResource(R.drawable.world_news);
            bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.world_news);
            Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                @Override
                public void onGenerated(Palette palette) {
                    collapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(0));
                    collapsingToolbarLayout.setStatusBarScrimColor(palette.getMutedColor(0));
                    tabLayout.setBackgroundColor(palette.getVibrantColor(0));
                }
            });//palete.generate
        }//if


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }//onpagescrolled

            @Override
            public void onPageSelected(int position) {
                collapsingToolbarImageView= (ImageView) findViewById(R.id.collapsingToolbarImageView);
                if(fragments.get(position) instanceof CollapsingToolbarInterface) {
                    CollapsingToolbarInterface currentFragment= (CollapsingToolbarInterface) fragments.get(position);
                    collapsingToolbarImageView.setImageResource(currentFragment.getCollapsingToolbarId());
                    bitmap= BitmapFactory.decodeResource(getResources(),currentFragment.getCollapsingToolbarId());
                    Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                        @Override
                        public void onGenerated(Palette palette) {
                            collapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(0));
                            collapsingToolbarLayout.setStatusBarScrimColor(palette.getMutedColor(0));
                            tabLayout.setBackgroundColor(palette.getVibrantColor(0));
                        }
                    });
                }
            }//onpageselected

            @Override
            public void onPageScrollStateChanged(int state) {

            }//onpagescrollstatechanged
        });//viewpagerlistener
    }//onCreate

    @Override
    protected void onStart() {
        super.onStart();
        navigationView.setCheckedItem(R.id.EntertainmentAndEvents);
    }//onStart

    @Override
    protected void onResume() {
        super.onResume();
        navigationView.setCheckedItem(R.id.EntertainmentAndEvents);
    }//onResume
}
