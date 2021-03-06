package com.example.stateapi2.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.stateapi2.MainActivity;
import com.example.stateapi2.R;
import com.leo.simplearcloader.SimpleArcLoader;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;
import org.json.JSONException;
import org.json.JSONObject;


public class HomeFrag extends Fragment {


    TextView tvCases,tvRecovered,tvCritical,tvActive,tvTodayCases,tvTotalDeaths,tvTodayDeaths,tvAffectedCountries;
    SimpleArcLoader simpleArcLoader;
    ScrollView scrollView;
    PieChart pieChart;

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate( R.layout.fragment_home, container, false );

        tvCases = view.findViewById( R.id.tvCases );
        tvRecovered = view.findViewById( R.id.tvRecovered );
        tvCritical = view.findViewById( R.id.tvCritical );
        tvActive = view.findViewById( R.id.tvActive);
        tvTodayCases = view.findViewById( R.id.tvTodayCases );
        tvTotalDeaths = view.findViewById( R.id.tvTotalDeaths);
        tvTodayDeaths = view.findViewById( R.id.tvTodayDeaths);
        tvAffectedCountries = view.findViewById( R.id.tvAffectedCountries);
        simpleArcLoader = view.findViewById( R.id.loader );
        scrollView = view.findViewById( R.id.scrollStats );
        pieChart = view.findViewById( R.id.piechart );

       // viewInit();
        fetchData();
      //  getDataAPI();
        return view;}

        private void fetchData() {

            String url = "https://corona.lmao.ninja/v2/all";
            simpleArcLoader.start();
            StringRequest request = new StringRequest( Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            try {
                                JSONObject jsonObject = new JSONObject( response.toString());

                                tvCases.setText(jsonObject.getString( "cases" ));
                                tvRecovered.setText(jsonObject.getString( "recovered" ));
                                tvCritical.setText(jsonObject.getString( "critical" ));
                                tvActive.setText(jsonObject.getString( "active" ));
                                tvTodayCases.setText(jsonObject.getString( "todayCases" ));
                                tvTotalDeaths.setText(jsonObject.getString( "deaths" ));
                                tvTodayDeaths.setText(jsonObject.getString( "todayDeaths" ));
                                tvAffectedCountries.setText(jsonObject.getString( "affectedCountries" ));


                                pieChart.addPieSlice( new PieModel( "Cases",Integer.parseInt(tvCases.getText().toString()), Color.parseColor("#FFA726")));
                                pieChart.addPieSlice( new PieModel( "Recovered",Integer.parseInt(tvRecovered.getText().toString()), Color.parseColor("#66BB6A")));
                                pieChart.addPieSlice( new PieModel( "Deaths",Integer.parseInt(tvTotalDeaths.getText().toString()), Color.parseColor("#EF5350")));
                                pieChart.addPieSlice( new PieModel( "Active",Integer.parseInt(tvActive.getText().toString()), Color.parseColor("#29B6F6")));
                                pieChart.startAnimation();

                                simpleArcLoader.stop();
                                simpleArcLoader.setVisibility( View.GONE );
                                scrollView.setVisibility( View.VISIBLE );




                            } catch (JSONException e) {
                                e.printStackTrace();
                                simpleArcLoader.stop();
                                simpleArcLoader.setVisibility( View.GONE );
                                scrollView.setVisibility( View.VISIBLE );
                            }


                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    simpleArcLoader.stop();
                    simpleArcLoader.setVisibility( View.GONE );
                    scrollView.setVisibility( View.VISIBLE );
                    Toast.makeText( getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();

                }
            } );

            RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
            requestQueue.add( request );

        }
    }



