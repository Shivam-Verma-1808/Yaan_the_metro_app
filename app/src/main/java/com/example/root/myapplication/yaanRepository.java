package com.example.root.myapplication;

import android.app.Application;
import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.os.AsyncTask;

import java.util.List;


public class yaanRepository {                                                                       //A Repository is a class that abstracts access to multiple data sources.

    private station_Dao station_dao;
    private LiveData<List<String>> all_station_names;
    private LiveData<station_entity> station_info;
    MutableLiveData<String> filter = new MutableLiveData<String>();                                 //

    public yaanRepository(Application application)
    {
        yaan_database database = yaan_database.getInstance(application);
        station_dao = database.station_dao();
        all_station_names = station_dao.select_all_station_names();
        //station_info = station_dao.show_station(station_name);

        station_info = Transformations.switchMap(filter, new Function<String,LiveData<station_entity>>(){       //
            @Override
            public LiveData<station_entity> apply(String input) {
                return station_dao.show_station(input);
            }
        });

    }

    public void set_filter(String string)
    {
        filter.setValue(string);
    }

    public void insert_new_station(station_entity station)
    {
        new insert_station_AsyncTask(station_dao).execute(station);
    }

    public LiveData<List<String>> getAll_station_names() {
        return all_station_names;
    }

    public LiveData<station_entity> getStation_info(String station_name) {
        //station_info = station_dao.show_station(station_name);
        this.set_filter(station_name);
        return station_info;
    }

    private static class insert_station_AsyncTask extends AsyncTask<station_entity,Void,Void>
    {
        private station_Dao station_dao;

        private insert_station_AsyncTask(station_Dao station_dao) {
            this.station_dao = station_dao;
        }

        @Override
        protected Void doInBackground(station_entity... station_entities) {
            station_dao.insert_new_station(station_entities[0]);
            return null;
        }
    }




}
