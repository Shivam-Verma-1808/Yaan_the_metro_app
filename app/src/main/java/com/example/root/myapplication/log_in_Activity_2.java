package com.example.root.myapplication;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.content.Intent;

public class log_in_Activity_2 extends Activity {

    ConstraintLayout log_in_layout;
    AnimationDrawable log_in_animation;
    ImageView logo_img;
    long move_up_duration = 3000 ;
    //RelativeLayout button_area ;
    //public Button log_in_btn ,sign_up_btn,skip_btn;

    //Fragment fragments = null ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in__2);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.buttons, new log_in_btn_area_fragment());
        //transaction.addToBackStack(null);
        transaction.commit();


        log_in_layout = (ConstraintLayout) findViewById(R.id.log_in_2);                             //for background animation

        log_in_animation = (AnimationDrawable) log_in_layout.getBackground();
        log_in_animation.setEnterFadeDuration(4500);
        log_in_animation.setExitFadeDuration(4500);
        log_in_animation.start();

        logo_img = (ImageView)  findViewById(R.id.logo_log_in_2);                                   //image motion animation
        ObjectAnimator move_up = ObjectAnimator.ofFloat(logo_img,"y", 200.0f);
        move_up.setDuration(move_up_duration);

        //button_area = (RelativeLayout)findViewById(R.id.button_area_fragment);                    //for buttons fade in animation

        //ObjectAnimator buttons_fade_in = ObjectAnimator.ofFloat(button_area,View.ALPHA,0.0f,1.0f);
        //buttons_fade_in.setDuration(move_up_duration);

        AnimatorSet log_in_animation = new AnimatorSet();
        log_in_animation.playTogether(move_up);
        log_in_animation.start();

       /*
        log_in_btn = (Button) findViewById(R.id.log_in);
        sign_up_btn = (Button) findViewById(R.id.sign_up);
        skip_btn = (Button) findViewById(R.id.skip);

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
                startActivity(new Intent(log_in_Activity_2.this,play_area.class));

            }
        });
        */
    }

    /*
    public void replaceViewbyFragment(Fragment someFragment)
    {

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.buttons, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
    */
}
