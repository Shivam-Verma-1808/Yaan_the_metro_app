package com.example.root.myapplication;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.support.v4.util.Pair;

import java.util.List;

@Dao
public interface route_info_Dao {

    @Insert
    void insert_route_cost(route_cost_relation route_cost);

    @Insert
    void insert_route_detail(route_detail_entity route_detail);

    //@Query("SELECT station.name src,  station.name dest,route_id,cost FROM route INNER JOIN station ON src_station_id=station.id AND dest_station_id=station.id WHERE src=:start_station AND dest=:end_station")    //Alias name not working
    //LiveData<Pair<Pair<String,String>,Pair<int,float>>> get_route_cost(String start_station,String end_station);

    //@Query("SELECT station.name ,color_name FROM route_detail INNER JOIN color ON line_color=color.id INNER JOIN station WHERE route_id = :route_number ORDER BY route_detail.`order` ASC")
    //LiveData<List<Pair<String,String>>> get_route_detail_asc(int route_number);

   // @Query("SELECT station.name ,color_name FROM route_detail INNER JOIN color ON line_color=color.id INNER JOIN station WHERE route_id = :route_number ORDER BY route_detail.`order` DESC")
   // LiveData<List<Pair<String,String>>> get_route_detail_asc(int route_number,boolean desc);

}
