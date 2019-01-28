package com.example.root.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class go_smart_card extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    ImageView back_btn;
    Button register_newsmart_card_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_smart_card);

        toolbar = findViewById(R.id.go_smart_card_toolbar);
        setSupportActionBar(toolbar);

        back_btn = findViewById(R.id.back_btn_go_smart_card);
        back_btn.setOnClickListener(this);

        register_newsmart_card_btn = findViewById(R.id.register_newsmart_card_btn);
        register_newsmart_card_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //....
                Toast.makeText(go_smart_card.this,"Register New Smart Card Button Clicked",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        super.onBackPressed();
    }
}
