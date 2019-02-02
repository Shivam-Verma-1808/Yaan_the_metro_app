package com.example.root.myapplication;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "color")
public class color_entity {
    @PrimaryKey(autoGenerate = true)
    int id;

    String color_name;

    public color_entity(String name) {
        this.color_name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return color_name;
    }
}
