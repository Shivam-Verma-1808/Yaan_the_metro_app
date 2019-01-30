package com.example.root.myapplication;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class yaanViewModel extends AndroidViewModel {

    private  yaanRepository repository;
    private LiveData<List<String>> all_station_names;
    private  LiveData<station_entity> station_info;

    public yaanViewModel(@NonNull Application application) {
        super(application);

        repository = new yaanRepository(application);
        all_station_names = repository.getAll_station_names();

    }

    public void insert_new_station(station_entity station)
    {
        repository.insert_new_station(station);
    }
    public LiveData<List<String>> getAll_station_names(){
        return all_station_names;
    }
    public LiveData<station_entity> getStation_info(String station_name)
    {
        station_info = repository.getStation_info(station_name);
        return station_info;
    }
}
