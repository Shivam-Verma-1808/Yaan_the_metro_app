package com.example.root.myapplication;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "color")
public class color_entity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String color_name;

    public color_entity(String color_name) {
        this.color_name = color_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor_name() {
        return color_name;
    }
}
