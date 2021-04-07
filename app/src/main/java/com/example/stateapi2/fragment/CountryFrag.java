package com.example.stateapi2.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.stateapi2.Adapter.StateAdapter;
import com.example.stateapi2.Model.StateModel;
import com.example.stateapi2.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CountryFrag extends Fragment {


    private ArrayList<StateModel> arrayList;
    RecyclerView recyclerView;
    View view;
    private TextView totalCaseInd,totalCaseFor,TotalConfCaseInd,totalRecInd,totalDeathInd,lastUpdate;


    public CountryFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate( R.layout.fragment_country, container, false );
        viewInit();
        getDataAPI();
        adapterSetup();
        getStateDataAPI();


        return view;
    }

    private void adapterSetup() {

        recyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        StateAdapter stateAdapter = new StateAdapter( arrayList );

        recyclerView.setAdapter( stateAdapter );


    }

    private void getStateDataAPI() {

        String url = "https://api.rootnet.in/covid19-in/stats/latest";


        arrayList = new ArrayList<>();

        StringRequest stringRequest = new StringRequest( Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONObject jsonObject = new JSONObject( response );
                    JSONArray jsonArray = jsonObject.getJSONObject( "data").getJSONArray("regional");


                    for (int i = 0; i<jsonArray.length(); i++){

                        JSONObject data = jsonArray.getJSONObject( i );
                        arrayList.add(new StateModel( data.getString( "loc"),data.getString( "totalConfirmed")));

                    }adapterSetup();





                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(),""+e,Toast.LENGTH_LONG).show();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.i("tag",String.valueOf( error ));
                Toast.makeText(getActivity(),""+error,Toast.LENGTH_LONG).show();


            }
        });

        Volley.newRequestQueue( getActivity()).add( stringRequest );



    }

    private void getDataAPI() {


        RequestQueue requestQueue = Volley.newRequestQueue( getActivity() );
        String url = "https://api.rootnet.in/covid19-in/stats/latest";
        StringRequest stringRequest = new StringRequest( Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONObject jsonObject = new JSONObject( response ).getJSONObject( "data").getJSONObject("summary");
                    totalCaseInd.setText( jsonObject.getString( "total" ) );
                    totalDeathInd.setText( jsonObject.getString( "deaths" ) );
                    totalRecInd.setText( jsonObject.getString( "discharged" ) );
                    totalCaseFor.setText( jsonObject.getString( "confirmedCasesForeign" ) );
                    TotalConfCaseInd.setText( jsonObject.getString( "confirmedCasesIndian" ) );


                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(),""+e,Toast.LENGTH_LONG).show();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.i("tag",String.valueOf( error ));
                Toast.makeText(getActivity(),""+error,Toast.LENGTH_LONG).show();


            }
        });

        requestQueue.add( stringRequest );




    }

    private void viewInit() {

        totalCaseInd = view.findViewById( R.id.totalCaseInd );
        totalCaseFor= view.findViewById( R.id.totalConfCaseFor );
        TotalConfCaseInd = view.findViewById( R.id. totalConfCaseInd);
        totalRecInd= view.findViewById( R.id.totalCaseRec );
        totalDeathInd= view.findViewById( R.id.totalDeathInd );
        recyclerView = view.findViewById( R.id.recyclerView );




    }
}
