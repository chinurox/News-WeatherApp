package in.pradumn.newsweather_1.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceActivity;


import android.support.v7.app.AppCompatActivity;

import java.util.List;

import in.pradumn.newsweather_1.R;
import in.pradumn.newsweather_1.mainactivity_fragments.SettingsFragment;

/**
 * Created by Pradumn on 05-Jan-17.
 */
public class MySettingsActivity extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        FragmentManager fragmentManager= getFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        Fragment fragment= new SettingsFragment();
        fragmentTransaction.add(R.id.settings_activity_container,fragment);
        fragmentTransaction.commit();
    }
}
