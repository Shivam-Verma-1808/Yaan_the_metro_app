package com.example.root.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class app_wallet extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    ImageView back_btn;
    Button generate_ticket,review_recent,share_balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_wallet);

        toolbar = findViewById(R.id.app_wallet_toolbar);
        setSupportActionBar(toolbar);

        back_btn = findViewById(R.id.back_btn_app_wallet);
        back_btn.setOnClickListener(this);

        generate_ticket = findViewById(R.id.generate_ticket);
        generate_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //....
                Toast.makeText(app_wallet.this,"This feature (Generate Ticket) to be rolled in next update",Toast.LENGTH_LONG).show(); //for debuging and as a note
            }
        });

        review_recent = findViewById(R.id.review_recent);
        review_recent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //....
                Toast.makeText(app_wallet.this,"This feature (Review Recent) to be rolled in next update",Toast.LENGTH_LONG).show(); //for debuging and as a note
            }
        });

        share_balance = findViewById(R.id.share_balance);
        share_balance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //....
                Toast.makeText(app_wallet.this,"This feature (Share Balance) to be rolled in next update",Toast.LENGTH_LONG).show(); //for debuging and as a note
            }
        });
    }

    @Override
    public void onClick(View v) {
        super.onBackPressed();
    }
}
