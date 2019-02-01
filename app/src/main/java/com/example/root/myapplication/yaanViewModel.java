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

    public void set_filter(String string)
    {
        filter.setValue(string);
    }

}
