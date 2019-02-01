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
import android.widget.Toast;

public class station_info_activity extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    ImageView back_btn;

    String selected_station = null;
    TextView message_box,wait,lift,parking,parking_alt,address,pincode,contact_1,contact_2,jnc,type,rating,no_of_platforms,email;

    private yaanViewModel yaan_view_model;
    station_entity station = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_info_activity);

        toolbar = findViewById(R.id.station_info_activity_toolbar);
        setSupportActionBar(toolbar);

        back_btn = findViewById(R.id.back_btn_station_info_activity);
        back_btn.setOnClickListener(this);

        message_box = findViewById(R.id.station_name);
        wait = findViewById(R.id.wait);
        lift = findViewById(R.id.lift);
        parking = findViewById(R.id.parking);
        parking_alt = findViewById(R.id.parking_alt);
        address = findViewById(R.id.address);
        pincode = findViewById(R.id.pincode);
        contact_1 = findViewById(R.id.contact_1);
        contact_2 = findViewById(R.id.contact_2);
        jnc = findViewById(R.id.jnc);
        type = findViewById(R.id.station_type);
        rating = findViewById(R.id.rating);
        no_of_platforms = findViewById(R.id.no_of_platforms);
        email = findViewById(R.id.email);

        selected_station = getIntent().getStringExtra("station_name");

        if (selected_station!=null)
        {
            //message_box.setText(selected_station);
            yaan_view_model = ViewModelProviders.of(this).get(yaanViewModel.class);
            yaan_view_model.getStation_info(selected_station).observe(this, new Observer<station_entity>() {
                @Override
                public void onChanged(@Nullable station_entity station_info) {
                    station = station_info;
                    message_box.setText(station_info.getName());                                    //
                    email.setText(station_info.getEmail());                                         //
                    wait.setText(String.valueOf(station_info.getWait()));

                    if (!station_info.isLift())
                    {
                        lift.setText((String)"N");
                    }
                    if (station_info.isJnc())
                    {
                        jnc.setText((String)"Y");
                    }

                    pincode.setText(String.valueOf(station.getPincode()));
                    contact_1.setText(String.valueOf(station.getContact_1()));
                    contact_2.setText(String.valueOf(station.getContact_2()));
                    switch (station.getType())
                    {
                        case 1:
                            type.setText("Level");
                            break;
                        case 2:
                            type.setText("OverHead");
                            break;
                            default:
                                type.setText("Under Ground");
                    }
                    rating.setText(String.valueOf(station.getRating()));
                    no_of_platforms.setText(String.valueOf(station.getPlatforms()));
                    address.setText(station.getAddress());                                          //
                    parking_alt.setText(station.getParking_alt());                                  //
                    parking.setText(String.valueOf(station.getParking()));


                }
            });

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
