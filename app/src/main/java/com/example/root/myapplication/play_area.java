package com.example.root.myapplication;

import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class play_area extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_area);

        if(savedInstanceState == null)
        {
            setPlayAreaAsNew();
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        final NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close); //for rotating navigation option animation
        drawer.addDrawerListener(toogle);
        toogle.syncState();

        if(savedInstanceState == null)
        {
            navigationView.setCheckedItem(R.id.navigation_drawer_option_0);
        }


        Button App_Home = findViewById(R.id.home_btn);
        App_Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPlayAreaAsNew();
                navigationView.setCheckedItem(R.id.navigation_drawer_option_0);
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.navigation_drawer_option_0:
                setPlayAreaAsNew();
            break;

            case R.id.navigation_drawer_option_1:
                Toast.makeText(this,"Route Between Stations",Toast.LENGTH_LONG).show();

            break;

            case R.id.navigation_drawer_option_2:
                Toast.makeText(this,"Station Info",Toast.LENGTH_LONG).show();

            break;

            case R.id.navigation_drawer_option_3:
                Toast.makeText(this,"Metro Map",Toast.LENGTH_LONG).show();
            break;

            case R.id.navigation_drawer_option_4:
                Toast.makeText(this,"City Attractions",Toast.LENGTH_LONG).show();
                break;





            case R.id.other_options_1:
                Toast.makeText(this,"My Account Activity need to be completed",Toast.LENGTH_LONG).show();

            break;

            case R.id.other_options_2:
                Toast.makeText(this,"log_out Need to be completed ,i.e,shared prefereece file to be deleted",Toast.LENGTH_LONG).show();

            break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override

    public void onBackPressed()                                                                     //important :for closing navigation drawer when back button on device is pressed
    {
        if(drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    public void setPlayAreaAsNew()
    {
        android.support.v4.app.FragmentTransaction transaction;
        //android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //transaction.replace(R.id.play_area_top_fragment, new play_area_top_fragment());
        //transaction.commit();


        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.play_area_middle_fragment, new play_area_middle_fragment());
        transaction.commit();

        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.play_area_bottom_fragment, new play_area_bottom_fragment());
        transaction.commit();
    }
}
