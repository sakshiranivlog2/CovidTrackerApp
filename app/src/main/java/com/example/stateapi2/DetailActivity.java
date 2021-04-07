package com.example.stateapi2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stateapi2.fragment.IndiaFrag;

public class DetailActivity extends AppCompatActivity {

    private int positionCountry;
    TextView tvCountry,tvCases,tvRecovered,tvCritical,tvActive,tvTodayCases,tvTotalDeaths,tvTodayDeaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_detail );



        Intent intent = getIntent();
        positionCountry = intent.getIntExtra( "position",0 );



        getSupportActionBar().setTitle("Details of "+ IndiaFrag.countryModelsList.get(positionCountry).getCountry());
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
        getSupportActionBar().setDisplayShowHomeEnabled(true);



             tvCountry   = findViewById( R.id. tvCountryName);
              tvCases = findViewById( R.id.tvCases );
              tvRecovered   = findViewById( R.id.tvRecovered );
                tvCritical  = findViewById( R.id.tvCritical );
                  tvActive = findViewById( R.id. tvActive);
                  tvTodayCases = findViewById( R.id. tvTodayCases);
                tvTotalDeaths = findViewById( R.id. tvTotalDeaths);
                tvTodayDeaths  = findViewById( R.id.tvTodayDeaths );

                tvCountry.setText( IndiaFrag.countryModelsList.get(positionCountry).getCountry() );
               tvCases .setText( IndiaFrag.countryModelsList.get(positionCountry).getCases() );
                tvRecovered.setText( IndiaFrag.countryModelsList.get(positionCountry).getRecovered() );
                tvCritical.setText(IndiaFrag.countryModelsList.get(positionCountry).getCritical() );
                tvActive.setText(IndiaFrag.countryModelsList.get(positionCountry).getActive() );
                tvTodayCases.setText( IndiaFrag.countryModelsList.get(positionCountry).getTodayCases() );
                tvTotalDeaths.setText( IndiaFrag.countryModelsList.get(positionCountry).getDeaths());
                tvTodayDeaths.setText(IndiaFrag.countryModelsList.get(positionCountry).getTodayDeaths() );



    }






}
