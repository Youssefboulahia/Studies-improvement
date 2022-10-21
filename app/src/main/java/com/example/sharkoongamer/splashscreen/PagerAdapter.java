package com.example.sharkoongamer.splashscreen;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {



    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        switch (i) {
            case 0:
                return new CoursesFragment();

            case 1:
                return new AnalyticsFragment();
            case 2:
                return new TodoFragment();
            case 3:
                return new QuoteFragment();
            default:
                return null;
        }


    }

    @Override
    public int getCount() {
        return 4;
    }


}
