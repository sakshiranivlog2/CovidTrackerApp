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
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.stateapi2.fragment.callfragment;
import com.example.stateapi2.fragment.homefragment;
import com.example.stateapi2.fragment.settingfragment;
import com.google.android.material.navigation.NavigationView;

public class NavigationActivity4 extends AppCompatActivity {

    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_navigation4 );


        drawerLayout = findViewById( R.id.drawer_layout );
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

        redirectActivity(this,ShareActivity.class);
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
}
