package com.example.root.myapplication;

import java.sql.Date;
import java.sql.Time;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "station")
public class station_entity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    //@Unique
    private String name;

    private int platforms;

    private String address;

    private int pincode;

    private boolean jnc;

    private int type;

    private int wait;

    private String email;

   // private Time timein;
   // private Time timeout;
   // private Date datein;

    private int parking;
    private String parking_alt;

    private boolean lift;
    private int rating;

    private int contact_1;
    private int contact_2;

    public station_entity(String name, int platforms, String address, int pincode, boolean jnc, int type, int wait, String email, /*Time timein, Time timeout, Date datein,*/ int parking, String parking_alt, boolean lift, int rating, int contact_1, int contact_2) {
        this.name = name;
        this.platforms = platforms;
        this.address = address;
        this.pincode = pincode;
        this.jnc = jnc;
        this.type = type;
        this.wait = wait;
        this.email = email;
        //this.timein = timein;
        //this.timeout = timeout;
        //this.datein = datein;
        this.parking = parking;
        this.parking_alt = parking_alt;
        this.lift = lift;
        this.rating = rating;
        this.contact_1 = contact_1;
        this.contact_2 = contact_2;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPlatforms() {
        return platforms;
    }

    public String getAddress() {
        return address;
    }

    public int getPincode() {
        return pincode;
    }

    public boolean isJnc() {
        return jnc;
    }

    public int getType() {
        return type;
    }

    public int getWait() {
        return wait;
    }

    public String getEmail() {
        return email;
    }
/*
    public Time getTimein() {
        return timein;
    }

    public Time getTimeout() {
        return timeout;
    }

    public Date getDatein() {
        return datein;
    }
*/
    public int getParking() {
        return parking;
    }

    public String getParking_alt() {
        return parking_alt;
    }

    public boolean isLift() {
        return lift;
    }

    public int getRating() {
        return rating;
    }

    public int getContact_1() {
        return contact_1;
    }

    public int getContact_2() {
        return contact_2;
    }
}
