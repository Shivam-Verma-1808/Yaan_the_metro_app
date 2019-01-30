package com.example.root.myapplication;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class tab_1_middle_fragment extends Fragment implements View.OnClickListener{

    View rootView;
    TextView search_bar_1_textbox,search_bar_2_textbox;
    LinearLayout search_bar_1,search_bar_2;
    Button get_info_btn,view_route_btn;

    Fragment fragment = null ;
    //public FragmentCommunicator fragmentCommunicator;

    private yaanViewModel yaan_view_model;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_tab_1_middle_fragment, container, false);
        get_info_btn = rootView.findViewById(R.id.get_info_btn);
        view_route_btn = rootView.findViewById(R.id.view_route_btn);

        get_info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragment = new get_info_fragment();
                //replaceViewbyFragment(R.id.button_area_fragment,fragment);
                ////FragmentTransaction transaction = getFragmentManager().beginTransaction();   //these steps can be done in better way /optimised/redundancy can be reduced
                //if(getActivity().getClass().equals(play_area.class))
                //{
                ////transaction.replace(R.id.play_area_bottom_fragment, fragment);
                //}
                //else
                //{
                // transaction.replace(R.id.button_area_fragment_of_multipurpose_activity, fragment);
                // }
                ////transaction.addToBackStack(null);
                ////transaction.commit();
                replaceViewbyFragment(fragment);

            }
        });

        view_route_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragment = new view_route_fragment();
                //replaceViewbyFragment(R.id.button_area_fragment,fragment);
                ////FragmentTransaction transaction = getFragmentManager().beginTransaction();   //these steps can be done in better way /optimised/redundancy can be reduced
                //if(getActivity().getClass().equals(play_area.class))
                //{
                ////transaction.replace(R.id.button_area_fragment, fragment);
                //}
                //else
                //{
                // transaction.replace(R.id.button_area_fragment_of_multipurpose_activity, fragment);
                // }
                ////transaction.addToBackStack(null);
                ////transaction.commit();
                replaceViewbyFragment(fragment);

            }
        });


        yaan_view_model = ViewModelProviders.of(getActivity()).get(yaanViewModel.class);

        yaan_view_model.getAll_station_names().observe(getActivity(), new Observer<List<String>>() {
            @Override
            public void onChanged(@Nullable List<String> strings) {
                //
                Toast.makeText(getActivity(),"OnChanged",Toast.LENGTH_LONG).show();
            }
        });

        return rootView;
    }

    /*
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            fragmentCommunicator = (FragmentCommunicator) activity;

        }catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString() + "must implement FragmentCommunicator" );
        }
    }
    */

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        search_bar_1_textbox = rootView.findViewById(R.id.search_bar_1_text_view);                  //all this findViewById() work can also be done in onCreateView() instead of OnActivityCreated()
        search_bar_2_textbox = rootView.findViewById(R.id.search_bar_2_text_view);

        search_bar_1 = rootView.findViewById(R.id.search_bar_1);
        search_bar_1.setOnClickListener(this);
        search_bar_2 = rootView.findViewById(R.id.search_bar_2);
        search_bar_2.setOnClickListener(this);
    }

    /*
    public void my_popup_menu_function(View view)
    {
        PopupMenu popupMenu ;
        if (view.getId()==R.id.search_bar_1)
        {
            //popupMenu = new PopupMenu(rootView.getContext(),search_bar_1);
            popupMenu = new PopupMenu(getActivity(),search_bar_1);
            Toast.makeText(rootView.getContext(), "Search_bar_1_clicked", Toast.LENGTH_LONG).show();
        }
        else if(view.getId()==R.id.search_bar_2)
        {
            //popupMenu = new PopupMenu(rootView.getContext(),search_bar_2);
            popupMenu = new PopupMenu(getActivity(),search_bar_2);
            Toast.makeText(rootView.getContext(), "Search_bar_2_clicked", Toast.LENGTH_LONG).show();
        }
        else
        {
            //popupMenu = new PopupMenu(rootView.getContext(),search_bar_2_textbox);
            popupMenu = new PopupMenu(getActivity(),search_bar_2);
        }

        //Toast.makeText(rootView.getContext(), "For Debuging purpose only", Toast.LENGTH_LONG).show();

        popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if (item.getItemId()==R.id.search_bar_1)
                {

                    search_bar_1_textbox.setText(item.getTitle());
                }
                else if(item.getItemId()==R.id.search_bar_2)
                {
                    search_bar_2_textbox.setText(item.getTitle());
                }
                return true;
            }
        });
        popupMenu.show();
    }
    */

    @Override
    public void onClick(final View view) {

        PopupMenu popupMenu ;
        if (view.getId()==R.id.search_bar_1)
        {
            popupMenu = new PopupMenu(getActivity(),search_bar_1);
            Toast.makeText(rootView.getContext(), "Search_bar_1_clicked", Toast.LENGTH_LONG).show();
        }
        else if(view.getId()==R.id.search_bar_2)
        {
            popupMenu = new PopupMenu(getActivity(),search_bar_2);
            Toast.makeText(rootView.getContext(), "Search_bar_2_clicked", Toast.LENGTH_LONG).show();
        }
        else
        {
            popupMenu = new PopupMenu(getActivity(),search_bar_2);
        }

        popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if (view.getId()==R.id.search_bar_1)
                {

                    search_bar_1_textbox.setText(item.getTitle());
                }
                else if(view.getId()==R.id.search_bar_2)
                {
                    search_bar_2_textbox.setText(item.getTitle());
                }

                //Toast.makeText(rootView.getContext(),item.getTitle(),Toast.LENGTH_LONG).show();

                return true;
            }
        });
        popupMenu.show();

    }

    /*
    public void replaceViewbyFragment(android.view.View view_to_be_replaced,android.support.v4.app.Fragment someFragment)
    {

        android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        //transaction.replace(R.id.buttons, someFragment);
        transaction.replace((int)view_to_be_replaced, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
    */

    public void replaceViewbyFragment(Fragment someFragment)
    {
        /*
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        //transaction.replace(R.id.buttons, someFragment);
        transaction.replace(R.id.play_area_bottom_fragment, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        */
        //play_area_middle_fragment.fragmentManager.beginTransaction().replace(R.id.play_area_bottom_fragment,someFragment).addToBackStack(null).commit();
    }
}


