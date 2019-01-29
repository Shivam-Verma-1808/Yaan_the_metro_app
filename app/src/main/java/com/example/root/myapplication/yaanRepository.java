package com.example.root.myapplication;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

public class yaanRepository {                                                                       //A Repository is a class that abstracts access to multiple data sources.

    private station_Dao station_dao;                                                                //Excluding the live data part

    public yaanRepository(Application application)
    {
        yaan_database database = yaan_database.getInstance(application);
        station_dao = database.station_dao();
    }

    public void insert_new_station(station_entity station)
    {
        new insert_station_AsyncTask(station_dao).execute(station);
    }

    public List<String> show_all_station_names()
    {
        List<String> all_station_names = new show_station_names_AsyncTask(station_dao).execute().doInBackground();
        return all_station_names;
    }

    public station_entity show_station_info(String station_name)
    {
        return ;
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

    private static class show_station_names_AsyncTask extends AsyncTask<Void,Void,List<String>>
    {
        private station_Dao station_dao;
        List<String> station_names;

        private show_station_names_AsyncTask(station_Dao station_dao) {
            this.station_dao = station_dao;
        }

        @Override
        protected List<String> doInBackground(Void... voids) {
            station_names = station_dao.select_all_station_names();
            return station_names;
        }


    }

    private static class show_station_info_AsyncTask extends AsyncTask<String,Void,station_entity>
    {
        private station_Dao station_dao;

        private show_station_info_AsyncTask(station_Dao station_dao) {
            this.station_dao = station_dao;
        }

        @Override
        protected station_entity doInBackground(String... strings) {
            return station_dao.show_station(strings[0]);
        }

    }


}
