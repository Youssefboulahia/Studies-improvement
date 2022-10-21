package com.example.sharkoongamer.splashscreen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentQuotesAdapter extends FragmentPagerAdapter {




    public FragmentQuotesAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        switch (i) {
            case 0:
                return new Quotes_Fragment_GetInspired();


            case 1:
                return new Quotes_Fragments_Favorites();

            default:
                return null;
        }


    }

    @Override
    public int getCount() {
        return 2;
    }



}
