package com.example.root.myapplication;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class station_info_activity extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    ImageView back_btn;

    String selected_station = null;
    TextView message_box;

    private yaanViewModel yaan_view_model;
    station_entity station;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_info_activity);

        toolbar = findViewById(R.id.station_info_activity_toolbar);
        setSupportActionBar(toolbar);

        back_btn = findViewById(R.id.back_btn_station_info_activity);
        back_btn.setOnClickListener(this);

        message_box = findViewById(R.id.messageTextBox);

        selected_station = getIntent().getStringExtra("station_name");

        if (selected_station!=null)
        {
            message_box.setText(selected_station);
            /*
            yaan_view_model = ViewModelProviders.of(this).get(yaanViewModel.class);
            yaanViewModel.getStation_info(selected_station).observe(this, new Observer<station_entity>() {
                @Override
                public void onChanged(@Nullable station_entity station_info) {
                    station = station_info;

                }
            });
            */
        }
        else
        {
            message_box.setText("Please Select A Staion");
        }
    }

    @Override
    public void onClick(View v) {

        super.onBackPressed();
    }
}
