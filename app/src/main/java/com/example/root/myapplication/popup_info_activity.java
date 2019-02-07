package com.example.root.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class popup_info_activity extends AppCompatActivity implements View.OnClickListener{

    TextView src_station_text_box,dest_station_text_box;
    ImageView back_btn;
    String src_station_name = null,dest_station_name = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_info_activity);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.8));

        src_station_text_box = findViewById(R.id.src_station_name_text_box);
        dest_station_text_box = findViewById(R.id.dest_station_name_text_box);

        back_btn = findViewById(R.id.back_btn_popup_info);
        back_btn.setOnClickListener(this);

        src_station_name = getIntent().getStringExtra("src_station");
        dest_station_name = getIntent().getStringExtra("dest_station");

        if ((src_station_name!=null)&&(dest_station_name!=null))
        {
            src_station_text_box.setText(src_station_name);
            dest_station_text_box.setText(dest_station_name);
        }
        else if (src_station_name == null)
        {
            src_station_text_box.setText("source Station not selected");
            dest_station_text_box.setText("source Station not selected");
        }
        else if(dest_station_name == null)
        {
            src_station_text_box.setText("destination Station not selected");
            dest_station_text_box.setText("destination Station not selected");
        }
        else
        {
            src_station_text_box.setText("source Station not selected");
            dest_station_text_box.setText("destination Station not selected");
        }
    }

    @Override
    public void onClick(View v) {

        super.onBackPressed();

    }
}
