package com.example.root.myapplication;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.sql.Date;
import java.sql.Time;

@Database(entities = {station_entity.class},version = 1)                                            //this class is for Database ,entities are the tables(entity classes) in the database
public abstract class yaan_database extends RoomDatabase {

    private static yaan_database yaan ;                                                             //to make this class to singleton

    public abstract station_Dao station_dao();

    public static synchronized yaan_database getInstance(Context context)                           //synchronized : only one thread can access it at a time
    {
        if(yaan == null)                                                                            //if the database instance is null
        {
            yaan = Room.databaseBuilder(context.getApplicationContext(),yaan_database.class,"yaan_database").fallbackToDestructiveMigration().addCallback(roomCallback).build();
        }
        return yaan;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback()                 //to populate SQLite DB initially
    {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new populateDBAsyncTask(yaan).execute();

        }
    };

    private static class populateDBAsyncTask extends AsyncTask<Void,Void,Void>
    {
        private station_Dao stationdao;

        private populateDBAsyncTask(yaan_database db)
        {
            stationdao = db.station_dao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            stationdao.insert_new_station(new station_entity("Asia",3,"Asia on Earth",10,true,1,3,"asia@earth_mail.com",new Time(06,00,00),new Time(23,00,00),new Date(2019,01,07),1, "parking_alt:INDIAN OCEAN", true, 5, 1234567890, 987654321));

            stationdao.insert_new_station(new station_entity("Africa",2,"Africa on Earth",20,false,2,5,"africa@earth_mail.com",new Time(06,30,00),new Time(23,30,00),new Date(2019,01,07),1, "parking_alt:Atlantic Ocean", true, 4, 234567890, 876543210));

            stationdao.insert_new_station(new station_entity("Antarctica",1,"South pole ,Earth",30,false,1,6,"antarctica_south_pole@earth_mail.com",new Time(06,30,00),new Time(23,30,00),new Date(2019,01,07),1, "parking_alt:Southern OCEAN", true, 5, 345678902, 765432108));

            stationdao.insert_new_station(new station_entity("Australia",1,"Kangaroo Park,Australia ,Earth",40,false,2,5,"australia@earth_mail.com",new Time(06,00,00),new Time(23,00,00),new Date(2019,01,07),1, "parking_alt:Pacific Ocean", true, 5, 456789012, 654321543));

            stationdao.insert_new_station(new station_entity("Europe",3,"Europe ,Earth",50,true,3,3,"eu@earth_mail.com",new Time(06,00,00),new Time(23,00,00),new Date(2019,01,07),1, "parking_alt:Arctic Ocean", true, 5, 567890432, 54321032));

            stationdao.insert_new_station(new station_entity("North America",1,"UN Garden ,North America ,Earth",60,false,1,5,"n_america@earth_mail.com",new Time(06,30,00),new Time(23,30,00),new Date(2019,01,07),1, "parking_alt:Gulf of Mexico", true, 5, 678901234, 432109876));

            stationdao.insert_new_station(new station_entity("South America",1,"Aconcagua,Andes mountain range,South America ,Earth",70,false,1,5,"s_america@earth_mail.com",new Time(06,30,00),new Time(23,30,00),new Date(2019,01,07),1, "parking_alt:Caribbean Sea", true, 5, 789012345, 321987654));

            return null;
        }



    }

}
