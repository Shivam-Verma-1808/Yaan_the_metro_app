package com.example.root.myapplication;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class play_area_middle_fragment extends Fragment {

    View rootView;
    ViewPager viewPager;
    PagerAdapter adapter;
    TabLayout tabLayout;
    TabItem tab1,tab2,tab3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_play_area_middle_fragment, container, false);

        viewPager = rootView.findViewById(R.id.view_pager);
        tabLayout = rootView.findViewById(R.id.tablayout);

        tab1 = rootView.findViewById(R.id.tab1);
        tab2 = rootView.findViewById(R.id.tab2);
        tab3 = rootView.findViewById(R.id.tab3);

        adapter = new pager_adapter_middle_fragment(getFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                switch (tab.getPosition())
                {
                    case 0:

                        tabLayout.setBackgroundColor(ContextCompat.getColor(rootView.getContext(),R.color.tab1_middle_fragment_color)); //for coloring TabLayout of this fragment
                        //getActivity().getActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.tab1_middle_fragment_color))); //for coloring the toolbar //this makes the app crash
                        //if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {                                                     //for coloring statusBar of the device ,this feature is available only for Lollipop or higher
                          //   getActivity().getWindow().setStatusBarColor(ContextCompat.getColor(rootView.getContext(), R.color.tab1_middle_fragment_color));
                        //}

                    break;
                    case 1:
                        tabLayout.setBackgroundColor(ContextCompat.getColor(rootView.getContext(),R.color.tab2_middle_fragment_color));
                        //getActivity().getActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.tab2_middle_fragment_color)));
                        //if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                          //  getActivity().getWindow().setStatusBarColor(ContextCompat.getColor(rootView.getContext(), R.color.tab2_middle_fragment_color));
                        //}

                    break;
                    case 2:
                        tabLayout.setBackgroundColor(ContextCompat.getColor(rootView.getContext(),R.color.tab3_middle_fragment_color));
                        //getActivity().getActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.tab3_middle_fragment_color)));
                        //if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                          //  getActivity().getWindow().setStatusBarColor(ContextCompat.getColor(rootView.getContext(), R.color.tab3_middle_fragment_color));
                        //}
                    break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        /*
        if(savedInstanceState == null)
        {
            viewPager.setCurrentItem(0);
            tabLayout.setBackgroundColor(ContextCompat.getColor(rootView.getContext(),R.color.tab1_middle_fragment_color));
            tabLayout.setSelectedTabIndicator(0);
        }
        */

        return rootView;
    }
}
