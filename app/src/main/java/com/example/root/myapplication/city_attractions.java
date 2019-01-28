package com.example.root.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class city_attractions extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    ImageView back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_attractions);

        toolbar = findViewById(R.id.city_attractions_toolbar);
        setSupportActionBar(toolbar);

        back_btn = findViewById(R.id.back_btn_city_attractions);
        back_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onBackPressed();
    }
}
