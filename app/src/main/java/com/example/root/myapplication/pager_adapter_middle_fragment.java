package com.example.root.myapplication;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class pager_adapter_middle_fragment extends FragmentStatePagerAdapter {

    int number_of_tabs;

    public pager_adapter_middle_fragment(FragmentManager fm,int no_of_tabs)
    {
        super(fm);
        this.number_of_tabs = no_of_tabs;
    }

    @Override
    public int getCount()
    {
        return number_of_tabs;
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
                return new tab_1_middle_fragment();
            //break;

            case 1:
                return new tab_2_middle_fragment();
            //break;

            case 2:
                return new tab_3_middle_fragment();
            //break;

            default:
                return null;
            //break;
        }
    }

}
