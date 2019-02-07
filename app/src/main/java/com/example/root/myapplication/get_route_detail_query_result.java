package com.example.root.myapplication;

public class get_route_detail_query_result {

    String station_name;
    String color_name;

    public get_route_detail_query_result(String station_name, String color_name) {
        this.station_name = station_name;
        this.color_name = color_name;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public String getColor_name() {
        return color_name;
    }

    public void setColor_name(String color_name) {
        this.color_name = color_name;
    }
}
