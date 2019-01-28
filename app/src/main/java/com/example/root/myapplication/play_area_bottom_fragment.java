package com.example.root.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

public class play_area_bottom_fragment extends Fragment implements View.OnClickListener{

    View rootView;
    LinearLayout btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_play_area_bottom_fragment, container, false);

        btn_1 = rootView.findViewById(R.id.bottom_fragment_btn_1);
        btn_1.setOnClickListener(this);

        btn_2 = rootView.findViewById(R.id.bottom_fragment_btn_2);
        btn_2.setOnClickListener(this);

        btn_3 = rootView.findViewById(R.id.bottom_fragment_btn_3);
        btn_3.setOnClickListener(this);




        btn_4 = rootView.findViewById(R.id.bottom_fragment_btn_4);
        btn_4.setOnClickListener(this);

        btn_5 = rootView.findViewById(R.id.bottom_fragment_btn_5);
        btn_5.setOnClickListener(this);

        btn_6 = rootView.findViewById(R.id.bottom_fragment_btn_6);
        btn_6.setOnClickListener(this);




        btn_7 = rootView.findViewById(R.id.bottom_fragment_btn_7);
        btn_7.setOnClickListener(this);

        btn_8 = rootView.findViewById(R.id.bottom_fragment_btn_8);
        btn_8.setOnClickListener(this);

        btn_9 = rootView.findViewById(R.id.bottom_fragment_btn_9);
        btn_9.setOnClickListener(this);



        return rootView;
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.bottom_fragment_btn_1)
        {
            startActivity(new Intent(getActivity(),know_your_metro.class));
            Toast.makeText(getContext(),getResources().getString(R.string.bottom_fragment_btn1),Toast.LENGTH_LONG).show();

        }
        else if(view.getId()==R.id.bottom_fragment_btn_2)
        {
            startActivity(new Intent(getActivity(),metro_map.class));
            Toast.makeText(getContext(),getResources().getString(R.string.bottom_fragment_btn2),Toast.LENGTH_LONG).show();
        }
        else if(view.getId()==R.id.bottom_fragment_btn_3)
        {
            startActivity(new Intent(getActivity(),city_attractions.class));
            Toast.makeText(getContext(),getResources().getString(R.string.bottom_fragment_btn3),Toast.LENGTH_LONG).show();
        }
        else if(view.getId()==R.id.bottom_fragment_btn_4)
        {
            startActivity(new Intent(getActivity(),quick_recharge.class));
            Toast.makeText(getContext(),getResources().getString(R.string.bottom_fragment_btn4),Toast.LENGTH_LONG).show();
        }
        else if(view.getId()==R.id.bottom_fragment_btn_5)
        {
            startActivity(new Intent(getActivity(),app_wallet.class));
            Toast.makeText(getContext(),getResources().getString(R.string.bottom_fragment_btn5),Toast.LENGTH_LONG).show();
        }
        else if(view.getId()==R.id.bottom_fragment_btn_6)
        {
            startActivity(new Intent(getActivity(),go_smart_card.class));
            Toast.makeText(getContext(),getResources().getString(R.string.bottom_fragment_btn6),Toast.LENGTH_LONG).show();
        }
        else if(view.getId()==R.id.bottom_fragment_btn_7)
        {
            startActivity(new Intent(getActivity(),FAQ_activity.class));
            Toast.makeText(getContext(),getResources().getString(R.string.bottom_fragment_btn7),Toast.LENGTH_LONG).show();
        }
        else if(view.getId()==R.id.bottom_fragment_btn_8)
        {
            startActivity(new Intent(getActivity(),help_line_activity.class));
            Toast.makeText(getContext(),getResources().getString(R.string.bottom_fragment_btn8),Toast.LENGTH_LONG).show();
        }
        else
        {
            startActivity(new Intent(getActivity(),feed_back_activity.class));
            Toast.makeText(getContext(),getResources().getString(R.string.bottom_fragment_btn9),Toast.LENGTH_LONG).show();
        }

    }
}
