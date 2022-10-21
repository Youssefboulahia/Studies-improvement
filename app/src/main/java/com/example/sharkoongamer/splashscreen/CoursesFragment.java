package com.example.sharkoongamer.splashscreen;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class CoursesFragment extends Fragment{


    private FragmentCoursesAdapter pageadapter ;
    private ViewPager viewpager ;
    private TabLayout tabLayout_courses ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.Fragment_Course);
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
        View view = localInflater.inflate(R.layout.fragment_courses, container, false);




        tabLayout_courses=(TabLayout)view.findViewById(R.id.tablayout_courses);
        viewpager=(ViewPager)view.findViewById(R.id.viewpager_courses);
        pageadapter = new FragmentCoursesAdapter(getChildFragmentManager());
        viewpager.setAdapter(pageadapter);


        tabLayout_courses.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewpager.setCurrentItem(tab.getPosition());

                if (tab.getPosition() == 0) {
                  tab.setIcon(R.drawable.courses_fragments_coursesprogress_main);
                    }
                else if (tab.getPosition() == 1) {
                    tab.setIcon(R.drawable.courses_fragments_courseslist_main);
                }



            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

                if (tab.getPosition() == 0) {
                    tab.setIcon(R.drawable.courses_fragments_coursesprogress_default);
                }
                else if (tab.getPosition() == 1) {
                    tab.setIcon(R.drawable.courses_fragments_courseslist_default);
                }

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout_courses));


        return view ;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menucourses, menu);
    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.notifications1) {
            Toast.makeText(getActivity(), "Clicked on notifications for courses", Toast.LENGTH_SHORT)
                    .show();
        }
        if (item.getItemId() == R.id.about1) {
            Toast.makeText(getActivity(), "Clicked on about for courses", Toast.LENGTH_SHORT)
                    .show();
        }
        return true;
    }



}
