package com.example.root.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class quick_recharge extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    ImageView back_btn;

    Button recharge_app_wallet_btn,recharge_smart_card_btn;
    Button transfer_smart_card_to_app_wallet_btn,transfer_app_wallet_to_smart_card_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_recharge);

        toolbar = findViewById(R.id.quick_recharge_toolbar);
        setSupportActionBar(toolbar);

        back_btn = findViewById(R.id.back_btn_quick_recharge);
        back_btn.setOnClickListener(this);

        recharge_app_wallet_btn = findViewById(R.id.recharge_app_wallet_btn);
        recharge_app_wallet_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //....
                Toast.makeText(quick_recharge.this,"Recharge App Wallet",Toast.LENGTH_LONG).show();  //just for debugging purpose
            }
        });

        recharge_smart_card_btn = findViewById(R.id.recharge_smart_card_btn);
        recharge_smart_card_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //....
                Toast.makeText(quick_recharge.this,"Recharge Smart Card",Toast.LENGTH_LONG).show();  //just for debugging purpose
            }
        });

        transfer_smart_card_to_app_wallet_btn = findViewById(R.id.transfer_smart_card_to_app_wallet_btn);
        transfer_smart_card_to_app_wallet_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //....
                Toast.makeText(quick_recharge.this,"Smart Card -> App Wallet",Toast.LENGTH_LONG).show();  //just for debugging purpose
            }
        });

        transfer_app_wallet_to_smart_card_btn = findViewById(R.id.transfer_app_wallet_to_smart_card_btn);
        transfer_app_wallet_to_smart_card_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //....
                Toast.makeText(quick_recharge.this,"App Wallet -> Smart Card",Toast.LENGTH_LONG).show();  //just for debugging purpose
            }
        });
    }

    @Override
    public void onClick(View v) {

        super.onBackPressed();

    }
}
