package com.example.stateapi2.fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.leo.simplearcloader.SimpleArcLoader;

import org.eazegraph.lib.models.PieModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.stateapi2.Adapter.MyCustomAdapter;
import com.example.stateapi2.DetailActivity;
import com.example.stateapi2.Model.CountryModel;
import com.example.stateapi2.R;
import com.leo.simplearcloader.SimpleArcLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class IndiaFrag extends Fragment {

    View view;
    EditText edtSearch;
    ListView listView;
    SimpleArcLoader simpleArcLoader;

    public static List<CountryModel> countryModelsList = new ArrayList<>();
    CountryModel countryModel;
    MyCustomAdapter myCustomAdapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

           setHasOptionsMenu(true);
        view = inflater.inflate( R.layout.fragment_india, container, false );



         edtSearch = view.findViewById( R.id.edtSearch );
        listView = view.findViewById( R.id.listView );
        simpleArcLoader = view.findViewById( R.id.loader );

        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
      //  ((AppCompatActivity)getActivity()).getSupportActionBar().setSubtitle(R.string.subtitle);
      //  ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled( true );
       // ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);



        fetchData();


        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity( new Intent(getActivity(),DetailActivity.class).putExtra("position",position) );
            }
        } );

        edtSearch.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                myCustomAdapter.getFilter().filter(s);
                myCustomAdapter.notifyDataSetChanged();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        } );

        return view;
    }


    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        inflater.inflate( R.menu.menu, menu );
        super.onCreateOptionsMenu( menu, inflater );

    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.India) {
            Toast.makeText( getActivity(),"hometown",Toast.LENGTH_SHORT ).show();
        }
          //  getActivity().finish();

           return super.onOptionsItemSelected( item );
        }


        private void fetchData() {

        String url = "https://corona.lmao.ninja/v2/countries/";
        simpleArcLoader.start();

        StringRequest request = new StringRequest( Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        try{

                            JSONArray jsonArray = new JSONArray( response );
                            for(int i=0; i<jsonArray.length(); i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String countryName = jsonObject.getString( "country" );
                                String cases = jsonObject.getString( "cases" );
                                String todayCases = jsonObject.getString( "todayCases" );
                                String deaths = jsonObject.getString( "deaths" );
                                String todayDeaths = jsonObject.getString( "todayDeaths" );
                                String recovered = jsonObject.getString( "recovered" );
                                String active = jsonObject.getString( "active" );
                                String critical = jsonObject.getString( "critical" );


                                JSONObject object = jsonObject.getJSONObject( "countryInfo" );
                                String flagUrl = object.getString( "flag" );

                                countryModel = new CountryModel( flagUrl,countryName,cases,todayCases,deaths,todayDeaths,recovered,active,critical);

                                countryModelsList.add(countryModel);

                            }

                            myCustomAdapter = new MyCustomAdapter( getActivity(),countryModelsList );
                            listView.setAdapter( myCustomAdapter );
                            simpleArcLoader.stop();
                            simpleArcLoader.setVisibility( View.GONE );



                        } catch (JSONException e) {
                            e.printStackTrace();
                            simpleArcLoader.stop();
                            simpleArcLoader.setVisibility( View.GONE );

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        } );

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add( request );

    }


}

