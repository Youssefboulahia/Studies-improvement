package com.example.sharkoongamer.splashscreen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentAnalyticsAdapter extends FragmentPagerAdapter {




    public FragmentAnalyticsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        switch (i) {
            case 0:
                return new Analytics_Fragments_Overview();


            case 1:
                return new Analytics_Fragments_CoursesStats();

            default:
                return null;
        }


    }

    @Override
    public int getCount() {
        return 2;
    }



}
