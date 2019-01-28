package com.example.root.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class know_your_metro extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    ImageView back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_know_your_metro);

        toolbar = findViewById(R.id.know_your_metro_toolbar);
        setSupportActionBar(toolbar);

        back_btn = findViewById(R.id.back_btn_know_your_metro);
        back_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        super.onBackPressed();

    }
}
