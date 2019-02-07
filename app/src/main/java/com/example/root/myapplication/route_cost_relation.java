package com.example.root.myapplication;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "route",foreignKeys = {@ForeignKey(entity = station_entity.class ,parentColumns = "id",childColumns = "src_station_id" ,onDelete = CASCADE ,onUpdate = CASCADE),@ForeignKey(entity = station_entity.class,parentColumns = "id",childColumns = "dest_station_id",onDelete = CASCADE ,onUpdate = CASCADE)},indices = {@Index("src_station_id"),@Index("dest_station_id")})
public class route_cost_relation {

    @PrimaryKey(autoGenerate = true)
    private int route_id ;

    //@ForeignKey(syntax here)                                                                                 //foreign key references station_entity src_station_id = station_entity.id;
    private int src_station_id;

    //@ForeignKey(syntax here)                                                                                 //foreign key references station_entity src_station_id = station_entity.id;
    private int dest_station_id;

    private float cost;

    public route_cost_relation(int src_station_id, int dest_station_id,float cost) {
        this.src_station_id = src_station_id;
        this.dest_station_id = dest_station_id;
        this.cost = cost;
    }

    public void setRoute_id(int route_id) {
        this.route_id = route_id;
    }

    public int getRoute_id() {
        return route_id;
    }

    public int getSrc_station_id() {
        return src_station_id;
    }

    public int getDest_station_id() {
        return dest_station_id;
    }

    public float getCost() {
        return cost;
    }
}
