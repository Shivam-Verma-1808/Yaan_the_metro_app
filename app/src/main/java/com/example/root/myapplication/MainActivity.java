package com.example.root.myapplication;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout welcome_layout;
    AnimationDrawable welcome_animation ;
    ImageView logo_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        long fadein_duration = 5000;

        welcome_layout = (ConstraintLayout) findViewById(R.id.welcome_screen);

        welcome_animation = (AnimationDrawable) welcome_layout.getBackground();
        welcome_animation.setEnterFadeDuration(4500);
        welcome_animation.setExitFadeDuration(4500);
        welcome_animation.start();

        logo_img = (ImageView)  findViewById(R.id.logo);
        ObjectAnimator fadein = ObjectAnimator.ofFloat(logo_img,View.ALPHA,0.0f,1.0f);
        fadein.setDuration(fadein_duration);

        AnimatorSet logo_animation = new AnimatorSet();
        logo_animation.playTogether(fadein);
        logo_animation.start();
        /*
        logo_animation = (AnimationDrawable) findViewById(R.id.logo);//
        logo_animation.setEnterFadeDuration(4500);
        logo_animation.setExitFadeDuration(4500);
        logo_animation.start();
        */
    }
}
