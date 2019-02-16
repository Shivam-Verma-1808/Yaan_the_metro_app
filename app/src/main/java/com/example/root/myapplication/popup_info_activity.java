package com.example.root.myapplication;

import android.arch.lifecycle.Observer;

import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class popup_info_activity extends AppCompatActivity implements View.OnClickListener{

    TextView src_station_text_box,dest_station_text_box,error_message_box,cost_message_box,between_station_name,between_station_color;
    ImageView back_btn;
    String src_station_name = null,dest_station_name = null;
    //int src_station_id,dest_station_id;

    private yaanViewModel yaan_view_model;

    get_route_cost_query_result route_cost = null,route_cost_desc = null;
    //List<get_route_detail_query_result> between_stations_details=null;

    TableLayout route_detail_table;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_info_activity);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        final int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int)(width*.85),(int)(height*.90));

        src_station_text_box = findViewById(R.id.src_station_name_text_box);
        dest_station_text_box = findViewById(R.id.dest_station_name_text_box);

        back_btn = findViewById(R.id.back_btn_popup_info);
        back_btn.setOnClickListener(this);

        error_message_box = findViewById(R.id.error_box);
        cost_message_box = findViewById(R.id.cost_box);

        route_detail_table = findViewById(R.id.route_detail_table);

        src_station_name = getIntent().getStringExtra("src_station");
        dest_station_name = getIntent().getStringExtra("dest_station");



        if ((src_station_name!=null)&&(dest_station_name!=null)&&(!src_station_name.equals(dest_station_name)))
        {
            yaan_view_model = ViewModelProviders.of(this).get(yaanViewModel.class);
            src_station_text_box.setText(src_station_name);
            dest_station_text_box.setText(dest_station_name);

            /*
            yaan_view_model.getStation_info(src_station_name).observe(this, new Observer<station_entity>() {
                @Override
                public void onChanged(@Nullable station_entity station_info) {

                    src_station_id = station_info.getId();

                    yaan_view_model.getStation_info(dest_station_name).observe(popup_info_activity.this, new Observer<station_entity>() {
                        @Override
                        public void onChanged(@Nullable station_entity station_info) {

                            dest_station_id = station_info.getId();

                            Toast.makeText(popup_info_activity.this,String.valueOf(src_station_id),Toast.LENGTH_SHORT).show();
                            if(src_station_id < dest_station_id) {
                                yaan_view_model.getRoute_cost(new route_cost_filter_input(src_station_name, dest_station_name)).observe(popup_info_activity.this, new Observer<get_route_cost_query_result>() {
                                    @Override
                                    public void onChanged(@Nullable get_route_cost_query_result route_cost_result) {

                                        route_cost = route_cost_result;
                                        if (route_cost != null) {
                                            cost_message_box.setText(String.valueOf(route_cost.getCost()));
                                            yaan_view_model.getRoute_detail(new route_detail_filter_input(route_cost.getRoute_id())).observe(popup_info_activity.this, new Observer<List<get_route_detail_query_result>>() {
                                                @Override
                                                public void onChanged(@Nullable List<get_route_detail_query_result> get_route_detail_query_results) {

                                                    if (get_route_detail_query_results != null) {
                                                        for (get_route_detail_query_result between_station : get_route_detail_query_results) {
                                                            //cost_message_box.setText(between_station.getColor_name());                                //for debugging only
                                                            TableRow row = new TableRow(popup_info_activity.this);
                                                            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT);
                                                            row.setLayoutParams(layoutParams);
                                                            //row.addView(new TextView(popup_info_activity.this).setText(between_station.getStation_name()));

                                                            between_station_name = new TextView(popup_info_activity.this);
                                                            between_station_name.setText(between_station.getStation_name());

                                                            between_station_color = new TextView(popup_info_activity.this);
                                                            between_station_color.setText(between_station.getColor_name());
                                                            row.addView(between_station_name);
                                                            row.addView(between_station_color);
                                                            route_detail_table.addView(row);

                                                        }

                                                    } else {
                                                        error_message_box.setText(R.string.route_detail_error);
                                                    }

                                                }
                                            });
                                        }
                                        else
                                        {
                                            error_message_box.setText(R.string.route_cost_error);
                                        }
                                    }
                                });
                            }


                            else
                            {
                                yaan_view_model.getRoute_cost(new route_cost_filter_input(dest_station_name,src_station_name)).observe(popup_info_activity.this, new Observer<get_route_cost_query_result>() {
                                    @Override
                                    public void onChanged(@Nullable get_route_cost_query_result route_cost_result) {

                                        route_cost_desc = route_cost_result;

                                        if(route_cost_result != null)
                                        {
                                            cost_message_box.setText(String.valueOf(route_cost_desc.getCost()));
                                            yaan_view_model.getRoute_detail_desc(new route_detail_filter_input(route_cost_desc.getRoute_id())).observe(popup_info_activity.this, new Observer<List<get_route_detail_query_result>>() {
                                                @Override
                                                public void onChanged(@Nullable List<get_route_detail_query_result> get_route_detail_query_results) {

                                                    if(get_route_detail_query_results!=null)
                                                    {
                                                        for (get_route_detail_query_result between_station : get_route_detail_query_results) {
                                                            //cost_message_box.setText(between_station.getColor_name());                                //for debugging only
                                                            TableRow row = new TableRow(popup_info_activity.this);
                                                            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT);
                                                            row.setLayoutParams(layoutParams);
                                                            //row.addView(new TextView(popup_info_activity.this).setText(between_station.getStation_name()));

                                                            between_station_name = new TextView(popup_info_activity.this);
                                                            between_station_name.setText(between_station.getStation_name());

                                                            between_station_color = new TextView(popup_info_activity.this);
                                                            between_station_color.setText(between_station.getColor_name());
                                                            row.addView(between_station_name);
                                                            row.addView(between_station_color);
                                                            route_detail_table.addView(row);
                                                        }
                                                    }
                                                    else
                                                    {
                                                        error_message_box.setText(R.string.route_detail_error);
                                                    }

                                                }
                                            });
                                        }

                                        else
                                        {
                                            error_message_box.setText(R.string.route_cost_error);
                                        }

                                    }
                                });
                            }
                        }
                    });
                }
            });
            */

            /*
            yaan_view_model.getStation_info(dest_station_name).observe(this, new Observer<station_entity>() {
                @Override
                public void onChanged(@Nullable station_entity station_info) {

                    dest_station_id = station_info.getId();
                }
            });

            if(src_station_id < dest_station_id) {
                yaan_view_model.getRoute_cost(new route_cost_filter_input(src_station_name, dest_station_name)).observe(this, new Observer<get_route_cost_query_result>() {
                    @Override
                    public void onChanged(@Nullable get_route_cost_query_result route_cost_result) {

                        route_cost = route_cost_result;
                        if (route_cost != null) {
                            cost_message_box.setText(String.valueOf(route_cost.getCost()));
                            yaan_view_model.getRoute_detail(new route_detail_filter_input(route_cost.getRoute_id())).observe(popup_info_activity.this, new Observer<List<get_route_detail_query_result>>() {
                                @Override
                                public void onChanged(@Nullable List<get_route_detail_query_result> get_route_detail_query_results) {

                                    if (get_route_detail_query_results != null) {
                                        for (get_route_detail_query_result between_station : get_route_detail_query_results) {
                                            //cost_message_box.setText(between_station.getColor_name());                                //for debugging only
                                            TableRow row = new TableRow(popup_info_activity.this);
                                            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT);
                                            row.setLayoutParams(layoutParams);
                                            //row.addView(new TextView(popup_info_activity.this).setText(between_station.getStation_name()));

                                            between_station_name = new TextView(popup_info_activity.this);
                                            between_station_name.setText(between_station.getStation_name());

                                            between_station_color = new TextView(popup_info_activity.this);
                                            between_station_color.setText(between_station.getColor_name());
                                            row.addView(between_station_name);
                                            row.addView(between_station_color);
                                            route_detail_table.addView(row);

                                        }

                                    } else {
                                        error_message_box.setText(R.string.route_detail_error);
                                    }

                                }
                            });
                        }
                        else
                        {
                            error_message_box.setText(R.string.route_cost_error);
                        }
                    }
                });
            }


            else
            {
                yaan_view_model.getRoute_cost(new route_cost_filter_input(dest_station_name,src_station_name)).observe(popup_info_activity.this, new Observer<get_route_cost_query_result>() {
                    @Override
                    public void onChanged(@Nullable get_route_cost_query_result route_cost_result) {

                        route_cost_desc = route_cost_result;

                        if(route_cost_result != null)
                        {
                            cost_message_box.setText(String.valueOf(route_cost_desc.getCost()));
                            yaan_view_model.getRoute_detail_desc(new route_detail_filter_input(route_cost_desc.getRoute_id())).observe(popup_info_activity.this, new Observer<List<get_route_detail_query_result>>() {
                                @Override
                                public void onChanged(@Nullable List<get_route_detail_query_result> get_route_detail_query_results) {

                                    if(get_route_detail_query_results!=null)
                                    {
                                        for (get_route_detail_query_result between_station : get_route_detail_query_results) {
                                            //cost_message_box.setText(between_station.getColor_name());                                //for debugging only
                                            TableRow row = new TableRow(popup_info_activity.this);
                                            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT);
                                            row.setLayoutParams(layoutParams);
                                            //row.addView(new TextView(popup_info_activity.this).setText(between_station.getStation_name()));

                                            between_station_name = new TextView(popup_info_activity.this);
                                            between_station_name.setText(between_station.getStation_name());

                                            between_station_color = new TextView(popup_info_activity.this);
                                            between_station_color.setText(between_station.getColor_name());
                                            row.addView(between_station_name);
                                            row.addView(between_station_color);
                                            route_detail_table.addView(row);
                                        }
                                    }
                                    else
                                    {
                                        error_message_box.setText(R.string.route_detail_error);
                                    }

                                }
                            });
                        }

                        else
                        {
                            error_message_box.setText(R.string.route_cost_error);
                        }

                    }
                });
            }
            */



            yaan_view_model.getRoute_cost(new route_cost_filter_input(src_station_name,dest_station_name)).observe(this, new Observer<get_route_cost_query_result>() {
                @Override
                public void onChanged(@Nullable get_route_cost_query_result route_cost_result) {

                    route_cost = route_cost_result;
                    if(route_cost != null)
                    {
                        cost_message_box.setText(String.valueOf(route_cost.getCost()));
                        yaan_view_model.getRoute_detail(new route_detail_filter_input(route_cost.getRoute_id())).observe(popup_info_activity.this, new Observer<List<get_route_detail_query_result>>() {
                            @Override
                            public void onChanged(@Nullable List<get_route_detail_query_result> get_route_detail_query_results) {

                                if(get_route_detail_query_results!=null)
                                {
                                    for (get_route_detail_query_result between_station : get_route_detail_query_results) {
                                        //cost_message_box.setText(between_station.getColor_name());                                //for debugging only
                                        TableRow row = new TableRow(popup_info_activity.this);
                                        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT);
                                        row.setLayoutParams(layoutParams);
                                        //row.addView(new TextView(popup_info_activity.this).setText(between_station.getStation_name()));

                                        between_station_name = new TextView(popup_info_activity.this);
                                        between_station_name.setText(between_station.getStation_name());

                                        between_station_color = new TextView(popup_info_activity.this);
                                        between_station_color.setText(between_station.getColor_name());
                                        row.addView(between_station_name);
                                        row.addView(between_station_color);
                                        route_detail_table.addView(row);

                                    }

                                }
                                else
                                {
                                    error_message_box.setText(R.string.route_detail_error);
                                }

                            }
                        });
                    }

                    else
                    {
                        //error_message_box.setText("route_cost is null");
                        yaan_view_model.getRoute_cost(new route_cost_filter_input(dest_station_name,src_station_name)).observe(popup_info_activity.this, new Observer<get_route_cost_query_result>() {
                            @Override
                            public void onChanged(@Nullable get_route_cost_query_result route_cost_result) {

                                route_cost_desc = route_cost_result;

                                if(route_cost_result != null)
                                {
                                    cost_message_box.setText(String.valueOf(route_cost_desc.getCost()));
                                    yaan_view_model.getRoute_detail_desc(new route_detail_filter_input(route_cost_desc.getRoute_id())).observe(popup_info_activity.this, new Observer<List<get_route_detail_query_result>>() {
                                        @Override
                                        public void onChanged(@Nullable List<get_route_detail_query_result> get_route_detail_query_results) {

                                            if(get_route_detail_query_results!=null)
                                            {
                                                for (get_route_detail_query_result between_station : get_route_detail_query_results) {
                                                    //cost_message_box.setText(between_station.getColor_name());                                //for debugging only
                                                    TableRow row = new TableRow(popup_info_activity.this);
                                                    TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT);
                                                    row.setLayoutParams(layoutParams);
                                                    //row.addView(new TextView(popup_info_activity.this).setText(between_station.getStation_name()));

                                                    between_station_name = new TextView(popup_info_activity.this);
                                                    between_station_name.setText(between_station.getStation_name());

                                                    between_station_color = new TextView(popup_info_activity.this);
                                                    between_station_color.setText(between_station.getColor_name());
                                                    row.addView(between_station_name);
                                                    row.addView(between_station_color);
                                                    route_detail_table.addView(row);
                                                }
                                            }
                                            else
                                            {
                                                error_message_box.setText(R.string.route_detail_error);
                                            }

                                        }
                                    });
                                }

                                else
                                {
                                    //error_message_box.setText(R.string.route_cost_error);
                                }

                            }
                        });
                    }

                }
            });


            /*
            if(flag == 0)
            {
                yaan_view_model.getRoute_cost(new route_cost_filter_input(dest_station_name,src_station_name)).observe(this, new Observer<get_route_cost_query_result>() {
                    @Override
                    public void onChanged(@Nullable get_route_cost_query_result route_cost_result) {

                        route_cost = route_cost_result;
                        if(route_cost != null) {
                            cost_message_box.setText(String.valueOf(route_cost.getCost()));
                            yaan_view_model.getRoute_detail_desc(new route_detail_filter_input(route_cost.getRoute_id())).observe(popup_info_activity.this, new Observer<List<get_route_detail_query_result>>() {
                                @Override
                                public void onChanged(@Nullable List<get_route_detail_query_result> get_route_detail_query_results) {

                                    if(get_route_detail_query_results!=null)
                                    {
                                        for (get_route_detail_query_result between_station : get_route_detail_query_results) {
                                            //cost_message_box.setText(between_station.getColor_name());                                //for debugging only
                                            TableRow row = new TableRow(popup_info_activity.this);
                                            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT);
                                            row.setLayoutParams(layoutParams);
                                            //row.addView(new TextView(popup_info_activity.this).setText(between_station.getStation_name()));

                                            between_station_name = new TextView(popup_info_activity.this);
                                            between_station_name.setText(between_station.getStation_name());

                                            between_station_color = new TextView(popup_info_activity.this);
                                            between_station_color.setText(between_station.getColor_name());
                                            row.addView(between_station_name);
                                            row.addView(between_station_color);
                                            route_detail_table.addView(row);
                                        }
                                    }
                                    else
                                    {
                                        error_message_box.setText("route_detail_query_results are null");
                                    }

                                }
                            });
                            flag =1;
                        }
                        else
                        {
                            error_message_box.setText("route_cost is null");
                            flag = 0;
                        }

                    }
                });
            }
            */

        }
        else if ((src_station_name == null)&&(dest_station_name != null))
        {
            error_message_box.setText(R.string.source_Station_not_selected);
        }
        else if((dest_station_name == null)&&(src_station_name != null))
        {

            error_message_box.setText(R.string.destination_Station_not_selected);
        }
        else if((src_station_name!=null)&&(dest_station_name!=null))
        {
            if(src_station_name.equals(dest_station_name)) {
                error_message_box.setText(R.string.same_scr_dest);
                src_station_text_box.setText(src_station_name);
                dest_station_text_box.setText(dest_station_name);
            }
        }
        else
        {
            error_message_box.setText(R.string.both_unselected);
        }
    }

    @Override
    public void onClick(View v) {

        super.onBackPressed();

    }


    /*
    int station_id;
    int get_staton_id(String station_name)
    {

        yaan_view_model.getStation_info(station_name).observe(this, new Observer<station_entity>() {
            @Override
            public void onChanged(@Nullable station_entity station_info) {
                station_id = station_info.getId();
            }
        });

        Toast.makeText(popup_info_activity.this,String.valueOf(station_id),Toast.LENGTH_SHORT).show();
        return station_id;
    }
    */
}
