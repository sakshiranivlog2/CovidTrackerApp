package com.example.stateapi2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.stateapi2.Adapter.AdapterRecycler;

import java.util.ArrayList;

public class HelplineActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    AdapterRecycler adapterRecycler;
    ArrayList<PojoLinear> pojoLinears;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_helpline );

        getSupportActionBar().hide();


        drawerLayout = findViewById( R.id.drawer_layout );

        linearList();

        recyclerView = findViewById(R.id.recyclerview_linear);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapterRecycler =  new AdapterRecycler(this, pojoLinears);
        recyclerView.setAdapter( adapterRecycler );
    }


    private void linearList() {
        pojoLinears = new ArrayList<PojoLinear>();
        pojoLinears.add(new PojoLinear("Andhra Pradesh",R.drawable.ic_call, "+91-866-2410978"));
        pojoLinears.add(new PojoLinear("Arunachal Pradesh",R.drawable.ic_call, "+91-9436055743"));
        pojoLinears.add(new PojoLinear("Assam",R.drawable.ic_call, "+91-6913347770"));
        pojoLinears.add(new PojoLinear("Bihar",R.drawable.ic_call, "104"));
        pojoLinears.add(new PojoLinear("Chhattisgarh",R.drawable.ic_call, "104"));
        pojoLinears.add(new PojoLinear("Goa",R.drawable.ic_call, "104"));
        pojoLinears.add(new PojoLinear("Gujarat",R.drawable.ic_call, "104"));
        pojoLinears.add(new PojoLinear("Harayana",R.drawable.ic_call, "+91-8558893911"));
        pojoLinears.add(new PojoLinear("Himachal Pradesh",R.drawable.ic_call, "104"));
        pojoLinears.add(new PojoLinear("Jharkhand",R.drawable.ic_call, "104"));
        pojoLinears.add(new PojoLinear("Karnataka",R.drawable.ic_call, "104"));
        pojoLinears.add(new PojoLinear("Kerala",R.drawable.ic_call, "+91-471-2552056"));
        pojoLinears.add(new PojoLinear("Madhya Pradesh",R.drawable.ic_call, "+91-755-2527177"));
        pojoLinears.add(new PojoLinear("Maharashtra",R.drawable.ic_call, "+91-20-26127394"));
        pojoLinears.add(new PojoLinear("Manipur",R.drawable.ic_call, "+91-3852411668"));
        pojoLinears.add(new PojoLinear("Meghalaya",R.drawable.ic_call, "108"));
        pojoLinears.add(new PojoLinear("Mizoram",R.drawable.ic_call, "102"));
        pojoLinears.add(new PojoLinear("Nagaland",R.drawable.ic_call, "+91-7005539653"));
        pojoLinears.add(new PojoLinear("Odisha",R.drawable.ic_call, "+91-9439994859"));
        pojoLinears.add(new PojoLinear("Punjab",R.drawable.ic_call, "104"));
        pojoLinears.add(new PojoLinear("Rajasthan",R.drawable.ic_call, "+91-141-2225624"));
        pojoLinears.add(new PojoLinear("Sikkim",R.drawable.ic_call, "104"));
        pojoLinears.add(new PojoLinear("Tamil Nadu",R.drawable.ic_call, "+91-44-29510500"));
        pojoLinears.add(new PojoLinear("Telengana",R.drawable.ic_call, "104"));
        pojoLinears.add(new PojoLinear("Tripura",R.drawable.ic_call, "+91-381-2315879"));
        pojoLinears.add(new PojoLinear("Uttarakhand",R.drawable.ic_call, "104"));
        pojoLinears.add(new PojoLinear("Uttar Pradesh",R.drawable.ic_call, "18001805145"));
        pojoLinears.add(new PojoLinear("West Bengal",R.drawable.ic_call, "1800313444222,+91-3323412600"));
        pojoLinears.add(new PojoLinear("Andaman and Nicobar Islands",R.drawable.ic_call, "+91-3192-232102"));
        pojoLinears.add(new PojoLinear("Chandigarh",R.drawable.ic_call, "+91-9779558282"));
        pojoLinears.add(new PojoLinear("Dadra and Nagar Haveli",R.drawable.ic_call, "104"));
        pojoLinears.add(new PojoLinear("Daman and Diu",R.drawable.ic_call, "104"));
        pojoLinears.add(new PojoLinear("Delhi",R.drawable.ic_call, "+91-11-22307145"));
        pojoLinears.add(new PojoLinear("Jammu and Kashmir",R.drawable.ic_call, "+91-191-2520982,+91-194-2440283"));
        pojoLinears.add(new PojoLinear("Ladakh",R.drawable.ic_call, "+91-1982-256462"));
        pojoLinears.add(new PojoLinear("Lakshadweep",R.drawable.ic_call, "104"));
        pojoLinears.add(new PojoLinear("Puducherry",R.drawable.ic_call, "104"));





    }

    public void ClickMenu(View view){

        MainActivity.openDrawer(drawerLayout);

    }

    public void ClickLogo(View view){

        MainActivity.closeDrawer(drawerLayout);

    }

    public void ClickHome(View view){

        MainActivity.redirectActivity(this,MainActivity.class);

    }

    public void ClickHelpline(View view){

        recreate();

    }
    public void ClickAware(View view){

        MainActivity.redirectActivity(this,CovidawareActivity.class);

    }

    public void ClickShare(View view){

        MainActivity.redirectActivity(this,ShareActivity.class);

    }

    static void openDrawer(DrawerLayout drawerLayout) {

        drawerLayout.openDrawer( GravityCompat.START );

    }

    public static void closeDrawer(DrawerLayout drawerLayout) {

        if (drawerLayout.isDrawerOpen( GravityCompat.START )){
            drawerLayout.closeDrawer( GravityCompat.START );

        }

    }

    public void ClickLogout(View view){

        MainActivity.logout( this );

    }

    @Override
    public void onBackPressed() {

        if (this.drawerLayout.isDrawerOpen( GravityCompat.START )) {
            this.drawerLayout.closeDrawer( GravityCompat.START );
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.closeDrawer( drawerLayout );
    }


}
