package com.example.root.myapplication;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "route_detail")
public class route_detail_entity {

    @PrimaryKey(autoGenerate = true)
    int id;

    //@ForeignKey(syntax)                                                                           //foreign key references route_cost_relation route_cost_relation.route_id =route_detail.route_id;
    int route_id;

    //@ForeignKey(syntax)                                                                           //foreign key references station_entity id =route_detail.between_station;
    int between_station;

    int order;                                                                                      //order means this station appears first then other in between the src and dest stations;

    //@ForeignKey(syntax)                                                                           //foreign key references color_entity color.id =route_detail.color;
    int line_color;


    public route_detail_entity(int route_id, int between_station, int order, int line_color) {
        this.route_id = route_id;
        this.between_station = between_station;
        this.order = order;
        this.line_color = line_color;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getRoute_id() {
        return route_id;
    }

    public int getBetween_station() {
        return between_station;
    }

    public int getOrder() {
        return order;
    }

    public int getLine_color() {
        return line_color;
    }
}
