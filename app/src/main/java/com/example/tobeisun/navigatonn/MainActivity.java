package com.example.tobeisun.navigatonn;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

//ADDED FRAGMENTS BY GOING TO NEW THEN FRAGMNETS , UNTICK THE TICKED THINGS THEN CLICK FINISH

// made changes to activity main  xml

// altered navigationselecteditem because i am not using some things there like camera, comm. blabh blah

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // to display the fragments ;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

/// remove the if else part

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        // initializing the transaction so when clicked, it comes up first
        transaction = getSupportFragmentManager().beginTransaction();
        // adding it to the containermain_container
        transaction.add(R.id.main_container, new Homefragment()) ;    // this is the id of the frame layout
        transaction.commit() ;
        getSupportActionBar().setTitle ("Home Fragment");


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()

        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {


                    // checked the ID from activity_main_drawer.xml  , i also edited it
                    case R.id.nav_home:
                        transaction= getSupportFragmentManager().beginTransaction() ;
                        //replace it with the fragment gangan..


                        transaction.replace(R.id.main_container, new Homefragment()) ;
                        transaction.commit() ;
                        // To change the title of the tool bar
                        getSupportActionBar().setTitle("Home Fragment");

                        // we have to check the item
                        item.setChecked(true) ;



                        break ;



                         case R.id.nav_message:
                        transaction= getSupportFragmentManager().beginTransaction() ;
                        //replace it with the fragment gangan..
                        transaction.replace(R.id.main_container, new Fragment_Message()) ;
                        transaction.commit() ;
                        // To change the title of the tool bar
                        getSupportActionBar().setTitle("Message Fragment");

                        // we have to check the item
                        item.setChecked(true) ;
                        break ;

                    // checked the ID from activity_main_drawer.xml  , i also edited it
                    case R.id.nav_settings:
                        transaction= getSupportFragmentManager().beginTransaction() ;
                        //replace it with the fragment gangan..
                        transaction.replace(R.id.main_container, new Fragment_Settings()) ;
                        transaction.commit() ;
                        // To change the title of the tool bar
                        getSupportActionBar().setTitle("Settings Fragment");

                        // we have to check the item
                        item.setChecked(true) ;
                        break ;



                }
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    // NOT USING
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
      return true;



    }
}
