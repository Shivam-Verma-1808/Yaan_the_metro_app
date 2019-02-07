package com.example.root.myapplication;

public class get_route_cost_query_result {
    String src_station_name;
    String dest_station_name;
    int route_id;
    float cost;

    public get_route_cost_query_result(String src_station_name, String dest_station_name, int route_id, float cost) {
        this.src_station_name = src_station_name;
        this.dest_station_name = dest_station_name;
        this.route_id = route_id;
        this.cost = cost;
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

    public int getRoute_id() {
        return route_id;
    }

    public void setRoute_id(int route_id) {
        this.route_id = route_id;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
