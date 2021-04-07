package com.example.stateapi2.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.example.stateapi2.Adapter.HelplineAdapter;
import com.example.stateapi2.Model.HelpModel;
import com.example.stateapi2.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class settingfragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<HelpModel> arrayList;
    View view;




    public settingfragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate( R.layout.fragment_settingfragment, container, false );

        viewInit();
        getDataApi();
        return view;
    }

    private void viewInit() {
        recyclerView = view.findViewById( R.id.recyclerViewHelp );
        recyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        HelplineAdapter helplineAdapter = new HelplineAdapter( arrayList );
        recyclerView.setAdapter( helplineAdapter );


    }

    private void getDataApi() {
        String url = "https://api.rootnet.in/covid19-in/contacts";


        arrayList = new ArrayList<>();

        final StringRequest stringRequest = new StringRequest( Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONObject jsonObject = new JSONObject( response );
                    JSONArray jsonArray = jsonObject.getJSONObject( "data" ).getJSONObject( "contacts" ).getJSONArray( "regional" );


                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject data = jsonArray.getJSONObject( i );
                        arrayList.add( new HelpModel( data.getString( "loc" ), data.getString( "number" ) ) );

                    }
                    viewInit();


                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText( getActivity(), "" + e, Toast.LENGTH_LONG ).show();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.i( "tag", String.valueOf( error ) );
                Toast.makeText( getActivity(), "" + error, Toast.LENGTH_LONG ).show();


            }
        } );

        Volley.newRequestQueue( getActivity() ).add( stringRequest );








}
}
