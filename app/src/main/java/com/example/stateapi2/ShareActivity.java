package com.example.stateapi2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class ShareActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_share );


        drawerLayout = findViewById( R.id.drawer_layout );
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


        MainActivity.redirectActivity(this,HelplineActivity.class);


    }
    public void ClickAware(View view){

        MainActivity.redirectActivity(this,CovidawareActivity.class);

    }

    public void ClickShare(View view){

        recreate();

    }

    public void ClickLogout(View view){

        MainActivity.logout( this );

    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.closeDrawer( drawerLayout );
    }
}
