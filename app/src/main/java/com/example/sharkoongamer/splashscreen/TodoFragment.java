package com.example.sharkoongamer.splashscreen;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
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



public class TodoFragment extends Fragment {

    private FragmentTodoAdapter pageadapter ;
    private ViewPager viewpager ;
    private TabLayout tabLayout_analytics ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        final Context contextThemeWrapper2 = new ContextThemeWrapper(getActivity(), R.style.Fragment_Todo);
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper2);
        View view = localInflater.inflate(R.layout.fragment_todo, container, false);


        tabLayout_analytics = (TabLayout) view.findViewById(R.id.tablayout_todo);
        viewpager = (ViewPager) view.findViewById(R.id.viewpager_todo);
        pageadapter = new FragmentTodoAdapter(getChildFragmentManager());
        viewpager.setAdapter(pageadapter);


        tabLayout_analytics.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0) {
                    tab.setIcon(R.drawable.todo_frqgments_managetodo_main);
                } else if (tab.getPosition() == 1) {
                    tab.setIcon(R.drawable.todo_fragments_makenotes_main);
                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

                if (tab.getPosition() == 0) {
                    tab.setIcon(R.drawable.todo_fragments_managetodo_default);
                } else if (tab.getPosition() == 1) {
                    tab.setIcon(R.drawable.todo_fragments_makenotes_default);
                }

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout_analytics));


        return view;

    }
    @Override


    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menutodo, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.notifications3) {
            Toast.makeText(getActivity(), "Clicked on notifications for ToDo", Toast.LENGTH_SHORT)
                    .show();
        }
        if (item.getItemId() == R.id.about3) {
            Toast.makeText(getActivity(), "Clicked on about for ToDo", Toast.LENGTH_SHORT)
                    .show();
        }
        return true;
    }

}
