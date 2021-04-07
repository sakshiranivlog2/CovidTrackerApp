package com.example.stateapi2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.stateapi2.fragment.CountryFrag;
import com.example.stateapi2.fragment.HomeFrag;
import com.example.stateapi2.fragment.IndiaFrag;
import com.example.stateapi2.fragment.SymptomsFrag;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.io.File;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    DrawerLayout drawerLayout;
   // DrawerLayout drawerLayout;
   // Toolbar toolbar;
   // NavigationView navigationView;
  //  ActionBarDrawerToggle toggleBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_navigation4);


       getSupportActionBar().hide();


        loadFragments( new HomeFrag() );
      //  drawerLayout = findViewById( R.id.drawerLayout );
       // navigationView=findViewById( R.id.navBar );
        bottomNavigationView = findViewById( R.id.bottom_Menu );
        drawerLayout = findViewById( R.id.drawer_layout );
        bottomNavigationView.setOnNavigationItemSelectedListener( this );


        // viewIninit();

        // bottomSetup();
    }


    public void ClickMenu(View view){

        openDrawer(drawerLayout);

    }

    static void openDrawer(DrawerLayout drawerLayout) {

        drawerLayout.openDrawer( GravityCompat.START );

    }

    public void ClickLogo(View view){

        closeDrawer(drawerLayout);

    }

    public static void closeDrawer(DrawerLayout drawerLayout) {

        if (drawerLayout.isDrawerOpen( GravityCompat.START )){
            drawerLayout.closeDrawer( GravityCompat.START );

        }

    }

    public void ClickHome(View view){

        recreate();
    }
    public void ClickHelpline(View view){

        redirectActivity(this,HelplineActivity.class);
    }

    public void ClickAware(View view){

        redirectActivity(this,CovidawareActivity.class);
    }
    public void ClickShare(View view){

        ApplicationInfo api = getApplicationContext().getApplicationInfo();
        String apkpath = api.sourceDir;
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType( "application/vnd.android.package-archive");
        intent.putExtra( Intent.EXTRA_STREAM,Uri.fromFile(new File(apkpath)) );
        startActivity( Intent.createChooser( intent,"ShareVia" ) );
    }

    public void ClickLogout(View view){

        logout(this);
    }

    public static void logout(final Activity activity) {

        AlertDialog.Builder builder = new AlertDialog.Builder( activity );
        builder.setTitle( "Logout" );
        builder.setMessage( "Are you sure you want to logout ?" );
        builder.setPositiveButton( "YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.finishAffinity();
                System.exit( 0 );
            }
        } );

        builder.setNegativeButton( "No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        } );
        builder.show();



    }


    public static void redirectActivity(Activity activity, Class aClass) {

        Intent intent = new Intent(activity,aClass);
        intent.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK );
        activity.startActivity( intent );

    }


    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer( drawerLayout );
    }





/*
    public void ClickMenu(View view){

        openDrawer(drawerLayout);

    }

    public static void openDrawer(DrawerLayout drawerLayout) {

        drawerLayout.openDrawer( GravityCompat.START );

    }

    public void ClickLogo(View view){

        closeDrawer(drawerLayout);

    }

    public static void closeDrawer(DrawerLayout drawerLayout) {

        if (drawerLayout.isDrawerOpen( GravityCompat.START )){
            drawerLayout.closeDrawer( GravityCompat.START );

        }

    }

    public void ClickHome(View view){

        recreate();
    }
    public void ClickHelpline(View view){

        redirectActivity(this, Helpline.class);
    }

    public void ClickAware(View view){

        redirectActivity(this,Covid19aware.class);
    }
    public void ClickShare(View view){

        redirectActivity(this,Shareapp.class);
    }

    public void ClickLogout(View view){

        logout(this);
    }

    public static void logout(final Activity activity) {

        AlertDialog.Builder builder = new AlertDialog.Builder( activity );
        builder.setTitle( "Logout" );
        builder.setMessage( "Are you sure you want to logout ?" );
        builder.setPositiveButton( "YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.finishAffinity();
                System.exit( 0 );
            }
        } );

        builder.setNegativeButton( "No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        } );
        builder.show();



    }


    public static void redirectActivity(Activity activity, Class aClass) {

        Intent intent = new Intent(activity,aClass);
        intent.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK );
        activity.startActivity( intent );

    }


    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer( drawerLayout );
    }



*/

          //////////////////////////////////////////////////////////////////////////////////////////////







    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public boolean loadFragments(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace( R.id.container, fragment )
                    .commit();
        }
        return true;
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;
        bottomNavigationView.setItemIconTintList( null );

        switch (item.getItemId()) {
            case R.id.Home:
                fragment = new HomeFrag();
                break;

            case R.id.India:
                fragment = new IndiaFrag();
                break;

            case R.id.allCountry:
                fragment = new CountryFrag();
                break;

            case R.id.symptoms:
                fragment = new SymptomsFrag();
                break;


        }
                return loadFragments( fragment );
    }






    @Override
    public void onBackPressed() {
        if(bottomNavigationView.getSelectedItemId()==R.id.Home)
        {
            super.onBackPressed();
            finish();
        }
        else
        {
            bottomNavigationView.setSelectedItemId( R.id.Home );

        }

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////



}

   /* private void bottomSetup() {

        bottomNavigationView.setItemIconTintList( null );

        bottomNavigationView.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.Home:

                        Toast.makeText(getApplicationContext(),"World Data",Toast.LENGTH_SHORT ).show();
                        Fragment homeFrag = new HomeFrag();
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.setTransition( FragmentTransaction.TRANSIT_FRAGMENT_FADE );
                        fragmentTransaction.replace(R.id.container,homeFrag);
                         break;
                    case R.id.India:

                        Toast.makeText(getApplicationContext(),"India Data",Toast.LENGTH_SHORT ).show();
                        Fragment indiaFrag = new IndiaFrag();
                        FragmentManager fragmentManager1 = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                        fragmentTransaction1.setTransition( FragmentTransaction.TRANSIT_FRAGMENT_FADE );
                        fragmentTransaction1.replace(R.id.container,indiaFrag);
                        break;
                    case R.id.allCountry:

                        Toast.makeText(getApplicationContext(),"Symptoms and Prevention",Toast.LENGTH_SHORT ).show();
                        Fragment countryFrag = new CountryFrag();
                        FragmentManager fragmentManager2 = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                        fragmentTransaction2.setTransition( FragmentTransaction.TRANSIT_FRAGMENT_FADE );
                        fragmentTransaction2.replace(R.id.container,countryFrag);
                        break;
                    case R.id.symptoms:

                        Toast.makeText(getApplicationContext(),"Helpline",Toast.LENGTH_SHORT ).show();
                        Fragment symptomsFrag = new SymptomsFrag();
                        FragmentManager fragmentManager3 = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction3 = fragmentManager3.beginTransaction();
                        fragmentTransaction3.setTransition( FragmentTransaction.TRANSIT_FRAGMENT_FADE );
                        fragmentTransaction3.replace(R.id.container,symptomsFrag);
                        break;
                }

                return false;
            }
        } );

    }

    private void viewIninit() {

        bottomNavigationView = findViewById( R.id.bottom_Menu );

    }


    @Override
    protected void onStart() {
        super.onStart();

        Fragment homeFrag = new HomeFrag();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setTransition( FragmentTransaction.TRANSIT_FRAGMENT_FADE );
        fragmentTransaction.replace(R.id.container,homeFrag);
    }

    */
