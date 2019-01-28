package com.example.root.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class feed_back_activity extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    ImageView back_btn;
    Button feed_back_submit_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back_activity);

        toolbar = findViewById(R.id.feed_back_toolbar);
        setSupportActionBar(toolbar);

        back_btn = findViewById(R.id.back_btn_feed_back);
        back_btn.setOnClickListener(this);

        feed_back_submit_btn = findViewById(R.id.feed_back_submit_btn);
        feed_back_submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //....
                Toast.makeText(feed_back_activity.this,"This feature will be rolled out in new update",Toast.LENGTH_LONG).show();    //for debuging only
            }
        });

    }

    @Override
    public void onClick(View v) {
        super.onBackPressed();
    }
}
