package com.example.root.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class view_route_on_map_activity extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    ImageView back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_route_on_map_activity);

        toolbar = findViewById(R.id.view_route_on_map_toolbar);
        setSupportActionBar(toolbar);

        back_btn = findViewById(R.id.back_btn_view_route_on_map);
        back_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        super.onBackPressed();

    }
}
