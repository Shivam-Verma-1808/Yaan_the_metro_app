package com.example.root.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
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


public class tab_2_middle_fragment extends Fragment implements View.OnClickListener{

    View rootView;
    TextView search_bar_tab_2_textbox;
    LinearLayout search_bar_tab_2;
    Button get_station_info;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_tab_2_middle_fragment, container, false);
        search_bar_tab_2 = rootView.findViewById(R.id.search_bar_tab_2);
        search_bar_tab_2.setOnClickListener(this);
        search_bar_tab_2_textbox = rootView.findViewById(R.id.search_bar_tab_2_text_view);
        get_station_info = rootView.findViewById(R.id.get_station_info_btn);
        get_station_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do things here on button click;
            }
        });
        return rootView;
    }

    @Override
    public void onClick(final View view) {

        PopupMenu popupMenu ;
        popupMenu = new PopupMenu(getActivity(),search_bar_tab_2);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());

        if (view.getId()==R.id.search_bar_tab_2)
        {
            Toast.makeText(rootView.getContext(), "Search_bar_clicked", Toast.LENGTH_LONG).show();
        }

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                search_bar_tab_2_textbox.setText(item.getTitle());
                return true;
            }
        });
        popupMenu.show();
    }
}
