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

@Database(entities = {station_entity.class,route_cost_relation.class,route_detail_entity.class,color_entity.class},version = 1)                                            //this class is for Database ,entities are the tables(entity classes) in the database
public abstract class yaan_database extends RoomDatabase {

    private static yaan_database yaan ;                                                             //to make this class to singleton

    public abstract station_Dao station_dao();
    public abstract route_info_Dao route_info_dao();
    public abstract color_Dao color_dao();

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
        private route_info_Dao routeinfodao;
        private color_Dao colordao;

        private populateDBAsyncTask(yaan_database db)
        {
            stationdao = db.station_dao();
            routeinfodao = db.route_info_dao();
            colordao = db.color_dao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            stationdao.insert_new_station(new station_entity("Asia",3,"Asia on Earth",10,true,1,3,"asia@earth_mail.com",/*new Time(06,00,00),new Time(23,00,00),new Date(2019,01,07),*/1, "parking_alt:INDIAN OCEAN", true, 5, 1234567890, 987654321));

            stationdao.insert_new_station(new station_entity("Africa",2,"Africa on Earth",20,false,2,5,"africa@earth_mail.com",/*new Time(06,30,00),new Time(23,30,00),new Date(2019,01,07),*/1, "parking_alt:Atlantic Ocean", true, 4, 234567890, 876543210));

            stationdao.insert_new_station(new station_entity("Antarctica",1,"South pole ,Earth",30,false,1,6,"antarctica_south_pole@earth_mail.com",/*new Time(06,30,00),new Time(23,30,00),new Date(2019,01,07),*/1, "parking_alt:Southern OCEAN", true, 5, 345678902, 765432108));

            stationdao.insert_new_station(new station_entity("Australia",1,"Kangaroo Park,Australia ,Earth",40,false,2,5,"australia@earth_mail.com",/*new Time(06,00,00),new Time(23,00,00),new Date(2019,01,07),*/1, "parking_alt:Pacific Ocean", true, 5, 456789012, 654321543));

            stationdao.insert_new_station(new station_entity("Europe",3,"Europe ,Earth",50,true,3,3,"eu@earth_mail.com",/*new Time(06,00,00),new Time(23,00,00),new Date(2019,01,07),*/1, "parking_alt:Arctic Ocean", true, 5, 567890432, 54321032));

            stationdao.insert_new_station(new station_entity("North America",1,"UN Garden ,North America ,Earth",60,false,1,5,"n_america@earth_mail.com",/*new Time(06,30,00),new Time(23,30,00),new Date(2019,01,07),*/1, "parking_alt:Gulf of Mexico", true, 5, 678901234, 432109876));

            stationdao.insert_new_station(new station_entity("South America",1,"Aconcagua,Andes mountain range,South America ,Earth",70,false,1,5,"s_america@earth_mail.com",/*new Time(06,30,00),new Time(23,30,00),new Date(2019,01,07),*/1, "parking_alt:Caribbean Sea", true, 5, 789012345, 321987654));



            colordao.insert_new_color(new color_entity("Yellow"));                              //1
            colordao.insert_new_color(new color_entity("Red"));                                //2
            colordao.insert_new_color(new color_entity("Blue"));                                 //3




            routeinfodao.insert_route_cost(new route_cost_relation(1,2,10));                        //1

            routeinfodao.insert_route_cost(new route_cost_relation(1,3,20));                        //2

            routeinfodao.insert_route_cost(new route_cost_relation(1,4,30));                        //3

            routeinfodao.insert_route_cost(new route_cost_relation(1,5,40));                        //4

            routeinfodao.insert_route_cost(new route_cost_relation(1,6,50));                        //5

            routeinfodao.insert_route_cost(new route_cost_relation(1,7,60));                        //6


            routeinfodao.insert_route_cost(new route_cost_relation(2,3,20));                        //7

            routeinfodao.insert_route_cost(new route_cost_relation(2,4,30));                        //8

            routeinfodao.insert_route_cost(new route_cost_relation(2,5,40));                        //9

            routeinfodao.insert_route_cost(new route_cost_relation(2,6,50));                        //10

            routeinfodao.insert_route_cost(new route_cost_relation(2,7,60));                        //11


            routeinfodao.insert_route_cost(new route_cost_relation(3,4,30));                        //12

            routeinfodao.insert_route_cost(new route_cost_relation(3,5,40));                        //13

            routeinfodao.insert_route_cost(new route_cost_relation(3,6,50));                        //14

            routeinfodao.insert_route_cost(new route_cost_relation(3,7,60));                        //15


            routeinfodao.insert_route_cost(new route_cost_relation(4,5,40));                        //16

            routeinfodao.insert_route_cost(new route_cost_relation(4,6,50));                        //17

            routeinfodao.insert_route_cost(new route_cost_relation(4,7,60));                        //18


            routeinfodao.insert_route_cost(new route_cost_relation(5,6,50));                        //19

            routeinfodao.insert_route_cost(new route_cost_relation(5,7,60));                        //20


            routeinfodao.insert_route_cost(new route_cost_relation(6,7,60));                        //21


            routeinfodao.insert_route_detail(new route_detail_entity(1,1,1,1));
            routeinfodao.insert_route_detail(new route_detail_entity(1,2,2,1));
            routeinfodao.insert_route_detail(new route_detail_entity(2,1,1,1));
            routeinfodao.insert_route_detail(new route_detail_entity(2,2,2,1));
            routeinfodao.insert_route_detail(new route_detail_entity(2,3,3,1));
            routeinfodao.insert_route_detail(new route_detail_entity(3,1,1,2));
            routeinfodao.insert_route_detail(new route_detail_entity(3,4,2,2));
            routeinfodao.insert_route_detail(new route_detail_entity(4,1,1,2));
            routeinfodao.insert_route_detail(new route_detail_entity(4,5,2,2));
            routeinfodao.insert_route_detail(new route_detail_entity(5,1,1,2));
            routeinfodao.insert_route_detail(new route_detail_entity(5,5,2,2));
            routeinfodao.insert_route_detail(new route_detail_entity(5,6,3,3));
            routeinfodao.insert_route_detail(new route_detail_entity(6,1,1,2));
            routeinfodao.insert_route_detail(new route_detail_entity(6,5,2,2));
            routeinfodao.insert_route_detail(new route_detail_entity(6,7,3,3));

            routeinfodao.insert_route_detail(new route_detail_entity(7,2,1,1));
            routeinfodao.insert_route_detail(new route_detail_entity(7,3,2,1));
            routeinfodao.insert_route_detail(new route_detail_entity(8,2,1,1));
            routeinfodao.insert_route_detail(new route_detail_entity(8,1,2,1));
            routeinfodao.insert_route_detail(new route_detail_entity(8,4,3,2));
            routeinfodao.insert_route_detail(new route_detail_entity(9,2,1,1));
            routeinfodao.insert_route_detail(new route_detail_entity(9,1,2,1));
            routeinfodao.insert_route_detail(new route_detail_entity(9,5,2,2));
            routeinfodao.insert_route_detail(new route_detail_entity(10,2,1,1));
            routeinfodao.insert_route_detail(new route_detail_entity(10,1,2,1));
            routeinfodao.insert_route_detail(new route_detail_entity(10,5,3,2));
            routeinfodao.insert_route_detail(new route_detail_entity(10,6,4,3));
            routeinfodao.insert_route_detail(new route_detail_entity(11,2,1,1));
            routeinfodao.insert_route_detail(new route_detail_entity(11,1,2,1));
            routeinfodao.insert_route_detail(new route_detail_entity(11,5,3,2));
            routeinfodao.insert_route_detail(new route_detail_entity(11,7,4,3));


            routeinfodao.insert_route_detail(new route_detail_entity(12,3,1,1));
            routeinfodao.insert_route_detail(new route_detail_entity(12,2,2,1));
            routeinfodao.insert_route_detail(new route_detail_entity(12,1,3,1));
            routeinfodao.insert_route_detail(new route_detail_entity(12,4,4,2));
            routeinfodao.insert_route_detail(new route_detail_entity(13,3,1,1));
            routeinfodao.insert_route_detail(new route_detail_entity(13,2,2,1));
            routeinfodao.insert_route_detail(new route_detail_entity(13,1,3,1));
            routeinfodao.insert_route_detail(new route_detail_entity(13,5,4,2));
            routeinfodao.insert_route_detail(new route_detail_entity(14,3,1,1));
            routeinfodao.insert_route_detail(new route_detail_entity(14,2,2,1));
            routeinfodao.insert_route_detail(new route_detail_entity(14,1,3,1));
            routeinfodao.insert_route_detail(new route_detail_entity(14,5,4,2));
            routeinfodao.insert_route_detail(new route_detail_entity(14,6,5,3));
            routeinfodao.insert_route_detail(new route_detail_entity(15,3,1,1));
            routeinfodao.insert_route_detail(new route_detail_entity(15,2,2,1));
            routeinfodao.insert_route_detail(new route_detail_entity(15,1,3,1));
            routeinfodao.insert_route_detail(new route_detail_entity(15,5,4,2));
            routeinfodao.insert_route_detail(new route_detail_entity(15,7,5,3));

            routeinfodao.insert_route_detail(new route_detail_entity(16,4,1,2));
            routeinfodao.insert_route_detail(new route_detail_entity(16,1,2,2));
            routeinfodao.insert_route_detail(new route_detail_entity(16,5,3,2));
            routeinfodao.insert_route_detail(new route_detail_entity(17,4,1,2));
            routeinfodao.insert_route_detail(new route_detail_entity(17,1,2,2));
            routeinfodao.insert_route_detail(new route_detail_entity(17,5,3,2));
            routeinfodao.insert_route_detail(new route_detail_entity(17,6,4,3));
            routeinfodao.insert_route_detail(new route_detail_entity(18,4,1,2));
            routeinfodao.insert_route_detail(new route_detail_entity(18,1,2,2));
            routeinfodao.insert_route_detail(new route_detail_entity(18,5,3,2));
            routeinfodao.insert_route_detail(new route_detail_entity(18,7,4,3));

            routeinfodao.insert_route_detail(new route_detail_entity(19,5,1,3));
            routeinfodao.insert_route_detail(new route_detail_entity(19,6,2,3));
            routeinfodao.insert_route_detail(new route_detail_entity(20,5,1,3));
            routeinfodao.insert_route_detail(new route_detail_entity(20,7,2,3));

            routeinfodao.insert_route_detail(new route_detail_entity(21,6,1,3));
            routeinfodao.insert_route_detail(new route_detail_entity(21,5,2,3));
            routeinfodao.insert_route_detail(new route_detail_entity(21,7,3,3));



            return null;
        }



    }

}
