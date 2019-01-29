package com.example.root.myapplication;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao                                                                                                //its beter to create a separate DAO interface for each Entity class
public interface station_Dao {

    @Insert
    void insert_new_station(station_entity new_station);

    @Query("SELECT name FROM station")
    List<String> select_all_station_names();

    @Query("SELECT * FROM station WHERE name = :station_name ")
    station_entity show_station(String station_name);
}