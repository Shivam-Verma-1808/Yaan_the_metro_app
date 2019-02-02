package com.example.root.myapplication;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

public interface color_Dao {

    @Insert
    void insert_new_color(color_entity color);

    @Query("SELECT color_name FROM color WHERE color.id =:input_id")
    LiveData<String> select_color_by_id(int input_id);

    @Query("SELECT color_name FROM color")
    LiveData<List<String>> show_all_color_names();
}
