package in.pradumn.newsweather_1.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Pradumn on 28-Sep-16.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> mFragments;
    ArrayList<String> mFragmentNames;


    public ViewPagerAdapter(FragmentManager fm,ArrayList<Fragment> fragments,ArrayList<String> fragmentNames) {
        super(fm);
        mFragments= fragments;
        mFragmentNames= fragmentNames;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    public String getPageTitle(int position) {
        return mFragmentNames.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
