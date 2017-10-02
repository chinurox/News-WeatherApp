package in.pradumn.newsweather_1.mainactivity_fragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.pradumn.newsweather_1.R;

/**
 * Created by Pradumn on 11-Jan-17.
 */
public class SettingsFragment extends PreferenceFragment{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.my_prefs);
    }
}
