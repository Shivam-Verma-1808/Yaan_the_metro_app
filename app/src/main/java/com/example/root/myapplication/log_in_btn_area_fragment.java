package com.example.root.myapplication;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;



public class log_in_btn_area_fragment extends Fragment {


    Fragment fragments = null ;
    public Button log_in_btn ,sign_up_btn,skip_btn;
    RelativeLayout button_area ;
    long fade_in_duration = 1700 ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment first
        View rootView = inflater.inflate(R.layout.fragment_log_in_btn_area_fragment, container, false);

        //then in this inflated root view ,the buttons appear
        button_area = (RelativeLayout) rootView.findViewById(R.id.button_area_fragment);                    //for buttons fade in animation

        ObjectAnimator buttons_fade_in = ObjectAnimator.ofFloat(button_area,View.ALPHA,0.0f,1.0f);
        buttons_fade_in.setDuration(fade_in_duration);

        AnimatorSet log_in_animation = new AnimatorSet();
        log_in_animation.playTogether(buttons_fade_in);
        log_in_animation.start();

        log_in_btn = (Button)  rootView.findViewById(R.id.log_in);
        sign_up_btn = (Button) rootView.findViewById(R.id.sign_up);
        skip_btn = (Button) rootView.findViewById(R.id.skip);


        //log_in_btn.setOnClickListener(this.OnClick());
        //sign_up_btn.setOnClickListener(this);
        //skip_btn.setOnClickListener(this);

        log_in_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragments = new log_in_fragment();
                replaceViewbyFragment(fragments);

            }
        });
        sign_up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragments = new sign_up_fragment();
                replaceViewbyFragment(fragments);

            }
        });
        skip_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //change activity
                //startActivity(new Intent(log_in_Activity_2.this,play_area.class));
                //startActivity(new Intent(log_in_btn_area_fragment.this,play_area.class));
                startActivity(new Intent(getActivity(),play_area.class));
            }
        });




        return rootView ;

    }

    /*
    @Override
    public void OnClick(View view)
    {
        fragments = null ;
        switch (view.getId())
        {
            case R.id.log_in :

                fragments = new log_in_fragment();
                replaceViewbyFragment(fragments);

            break;

            case R.id.sign_up :

                fragments = new sign_up_fragment();
                replaceViewbyFragment(fragments);

            break;

            case R.id.skip :

                //change activity

            break;

        }

    }
    */

    public void replaceViewbyFragment(Fragment someFragment)
    {

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        //transaction.replace(R.id.buttons, someFragment);
        transaction.replace(R.id.buttons, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}
