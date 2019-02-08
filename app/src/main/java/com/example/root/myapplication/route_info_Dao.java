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

    //@Query("SELECT src_station_name,dest_station_name,route_id,cost from (SELECT station.name as src_station_name,  station.name as dest_station_name,route_id,cost FROM route INNER JOIN station ON route.src_station_id = station.id AND route.dest_station_id = station.id)as innerTable WHERE src_station_name=:start_station AND dest_station_name=:end_station")    //Alias name not working //Query 1
    @Query("SELECT station_1.name as src_station_name, station_2.name as dest_station_name, route.route_id as route_id,cost FROM station AS station_1 , station AS station_2 INNER JOIN route ON route.src_station_id = station_1.id AND route.dest_station_id = station_2.id AND station_1.name <> station_2.name WHERE station_1.name =:start_station AND station_2.name =:end_station")
    LiveData<get_route_cost_query_result> get_route_cost(String start_station,String end_station);

    @Query("SELECT station.name as station_name,color_name FROM route_detail INNER JOIN color ON route_detail.line_color = color.id INNER JOIN station ON route_detail.between_station=station.id WHERE route_id = :route_number ORDER BY route_detail.`order` ASC")
    LiveData<List<get_route_detail_query_result>> get_route_detail_asc(int route_number);

    //@Query("SELECT station.name ,color_name FROM route_detail INNER JOIN color ON line_color=color.id INNER JOIN station WHERE route_id = :route_number ORDER BY route_detail.`order` DESC")
    //LiveData<List<get_route_detail_query_result>> get_route_detail_desc(int route_number,boolean desc);

}
