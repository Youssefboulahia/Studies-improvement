package com.example.sharkoongamer.splashscreen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentTodoAdapter extends FragmentPagerAdapter {




    public FragmentTodoAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        switch (i) {
            case 0:
                return new Todo_Fragment_ManageToDo();


            case 1:
                return new Todo_Fragment_MakeNotes();

            default:
                return null;
        }


    }

    @Override
    public int getCount() {
        return 2;
    }



}
