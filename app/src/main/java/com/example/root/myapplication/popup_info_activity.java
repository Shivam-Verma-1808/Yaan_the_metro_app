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

import java.util.List;

public class popup_info_activity extends AppCompatActivity implements View.OnClickListener{

    TextView src_station_text_box,dest_station_text_box,error_message_box,cost_message_box,between_station_name,between_station_color;
    ImageView back_btn;
    String src_station_name = null,dest_station_name = null;

    private yaanViewModel yaan_view_model;
    get_route_cost_query_result route_cost = null;
    List<get_route_detail_query_result> between_stations_details=null;

    TableLayout route_detail_table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_info_activity);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        final int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.8));

        src_station_text_box = findViewById(R.id.src_station_name_text_box);
        dest_station_text_box = findViewById(R.id.dest_station_name_text_box);

        back_btn = findViewById(R.id.back_btn_popup_info);
        back_btn.setOnClickListener(this);

        error_message_box = findViewById(R.id.error_box);
        cost_message_box = findViewById(R.id.cost_box);

        route_detail_table = findViewById(R.id.route_detail_table);

        src_station_name = getIntent().getStringExtra("src_station");
        dest_station_name = getIntent().getStringExtra("dest_station");

        if ((src_station_name!=null)&&(dest_station_name!=null))
        {
            yaan_view_model = ViewModelProviders.of(this).get(yaanViewModel.class);
            src_station_text_box.setText(src_station_name);
            dest_station_text_box.setText(dest_station_name);

            yaan_view_model.getRoute_cost(new route_cost_filter_input(src_station_name,dest_station_name)).observe(this, new Observer<get_route_cost_query_result>() {
                @Override
                public void onChanged(@Nullable get_route_cost_query_result route_cost_result) {

                    route_cost = route_cost_result;
                    if(route_cost != null) {
                        cost_message_box.setText(String.valueOf(route_cost.getCost()));
                    }
                    else
                    {
                        error_message_box.setText("route_cost is null");
                    }

                }
            });

            yaan_view_model.getRoute_detail(new route_detail_filter_input(5)).observe(this, new Observer<List<get_route_detail_query_result>>() {
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
        }
        else if (src_station_name == null)
        {
            error_message_box.setText("source Station not selected");
        }
        else if(dest_station_name == null)
        {

            error_message_box.setText("destination Station not selected");
        }
        else
        {
            error_message_box.setText("source and destination Station not selected");
        }
    }

    @Override
    public void onClick(View v) {

        super.onBackPressed();

    }
}
