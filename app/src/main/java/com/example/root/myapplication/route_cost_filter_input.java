package com.example.root.myapplication;

public class route_cost_filter_input {
    String src_station_name;
    String dest_station_name;

    public route_cost_filter_input(String src_station_name, String dest_station_name) {
        this.src_station_name = src_station_name;
        this.dest_station_name = dest_station_name;
    }

    public String getSrc_station_name() {
        return src_station_name;
    }

    public void setSrc_station_name(String src_station_name) {
        this.src_station_name = src_station_name;
    }

    public String getDest_station_name() {
        return dest_station_name;
    }

    public void setDest_station_name(String dest_station_name) {
        this.dest_station_name = dest_station_name;
    }
}
