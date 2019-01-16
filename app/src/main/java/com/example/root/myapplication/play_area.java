package com.example.root.myapplication;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class play_area extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_area);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.play_area_top_fragment, new play_area_top_fragment());
        transaction.commit();
    }
}
