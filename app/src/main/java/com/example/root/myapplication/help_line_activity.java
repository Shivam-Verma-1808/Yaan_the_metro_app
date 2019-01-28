package com.example.root.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class help_line_activity extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    ImageView back_btn;
    ImageButton help_line_contact_1_call_btn,help_line_contact_2_call_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_line_activity);

        toolbar = findViewById(R.id.help_line_toolbar);
        setSupportActionBar(toolbar);

        back_btn = findViewById(R.id.back_btn_help_line);
        back_btn.setOnClickListener(this);

        help_line_contact_1_call_btn = findViewById(R.id.help_line_contact_1_call_btn);
        help_line_contact_1_call_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //....
                Toast.makeText(help_line_activity.this,"help_line_contact_1_call_btn Clicked",Toast.LENGTH_LONG).show();    //for debuging only
            }
        });

        help_line_contact_2_call_btn = findViewById(R.id.help_line_contact_2_call_btn);
        help_line_contact_2_call_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //....
                Toast.makeText(help_line_activity.this,"help_line_contact_2_call_btn Clicked",Toast.LENGTH_LONG).show();    //for debuging only
            }
        });

    }

    @Override
    public void onClick(View v) {
        super.onBackPressed();
    }
}
