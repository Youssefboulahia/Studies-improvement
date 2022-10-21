package com.example.sharkoongamer.splashscreen;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentCoursesAdapter extends FragmentPagerAdapter {




    public FragmentCoursesAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        switch (i) {
            case 0:
                return new Courses_Fragment_StartStudying();


            case 1:
                return new Courses_Fragment_CoursesList();



            default:
                return null;

        }


    }

    @Override
    public int getCount() {
        return 2;
    }



}
