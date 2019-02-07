package com.example.root.myapplication;

import android.app.Application;
import android.arch.core.util.Function;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.support.annotation.NonNull;

import java.util.List;

public class yaanViewModel extends AndroidViewModel {

    private  yaanRepository repository;
    private LiveData<List<String>> all_station_names;
    private  LiveData<station_entity> station_info;

    MutableLiveData<String> filter = new MutableLiveData<String>();
    //String station = null;

    private LiveData<get_route_cost_query_result> route_cost;
    MutableLiveData<route_cost_filter_input> route_cost_filter = new MutableLiveData<route_cost_filter_input>();

    private LiveData<List<get_route_detail_query_result>> route_detail;
    MutableLiveData<route_detail_filter_input> route_detail_filter = new MutableLiveData<route_detail_filter_input>();

    public yaanViewModel(@NonNull Application application) {
        super(application);

        repository = new yaanRepository(application);
        all_station_names = repository.getAll_station_names();
        station_info = Transformations.switchMap(filter, /*station->repository.getStation_info(station)*/new Function<String,LiveData<station_entity>>(){       //
            @Override
            public LiveData<station_entity> apply(String input) {
                return repository.getStation_info(input);
            }
        });

        route_cost = Transformations.switchMap(route_cost_filter, new Function<route_cost_filter_input, LiveData<get_route_cost_query_result>>() {
            @Override
            public LiveData<get_route_cost_query_result> apply(route_cost_filter_input input) {
                return repository.getRoute_cost(input);
            }
        });

        route_detail = Transformations.switchMap(route_detail_filter, new Function<route_detail_filter_input, LiveData<List<get_route_detail_query_result>>>() {
            @Override
            public LiveData<List<get_route_detail_query_result>> apply(route_detail_filter_input input) {
                return repository.getRoute_detail(input);
            }
        });

    }

    /*
    public yaanViewModel(@NonNull Application application,String station_name) {                    //not sure about this
        super(application);

        repository = new yaanRepository(application);
        all_station_names = repository.getAll_station_names();
        station_info = repository.getStation_info(station_name);
    }
    */


    public void insert_new_station(station_entity station)
    {
        repository.insert_new_station(station);
    }
    public LiveData<List<String>> getAll_station_names(){
        return all_station_names;
    }
    public LiveData<station_entity> getStation_info(String station_name)
    {
        //station_info = repository.getStation_info(station_name);
        //final MutableLiveData<station_entity> data = new MutableLiveData<>();
        //getStation_info(station_name);
        ////station = station_name;
        this.set_filter(station_name);
        return station_info;
    }
    public LiveData<get_route_cost_query_result> getRoute_cost(route_cost_filter_input inputs)
    {
        this.set_route_cost_filter(inputs);
        return route_cost;
    }
    public LiveData<List<get_route_detail_query_result>> getRoute_detail(route_detail_filter_input inputs)
    {
        this.set_route_detail_filter(inputs);
        return route_detail;
    }

    public void set_filter(String string)
    {
        filter.setValue(string);
    }

    public void set_route_cost_filter(route_cost_filter_input filter_input){ route_cost_filter.setValue(filter_input); }

    public void set_route_detail_filter(route_detail_filter_input filter_input){ route_detail_filter.setValue(filter_input); }

}
