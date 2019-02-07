package com.example.root.myapplication;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "route_detail",foreignKeys = {@ForeignKey(entity = station_entity.class,parentColumns = "id",childColumns = "between_station",onDelete = CASCADE ,onUpdate = CASCADE),@ForeignKey(entity = route_cost_relation.class,parentColumns = "route_id",childColumns = "route_id",onDelete = CASCADE ,onUpdate = CASCADE),@ForeignKey(entity = color_entity.class,parentColumns = "id",childColumns = "line_color",onDelete = CASCADE ,onUpdate = CASCADE)},indices = {@Index("between_station"),@Index("route_id"),@Index("line_color")})
public class route_detail_entity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    //@ForeignKey(syntax)                                                                           //foreign key references route_cost_relation route_cost_relation.route_id =route_detail.route_id;
    private int route_id;

    //@ForeignKey(syntax)                                                                           //foreign key references station_entity id =route_detail.between_station;
    private int between_station;

    private int order;                                                                                      //order means this station appears first then other in between the src and dest stations;

    //@ForeignKey(syntax)                                                                           //foreign key references color_entity color.id =route_detail.color;
    private int line_color;


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
