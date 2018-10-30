package com.example.wilder.candhaloween;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
import android.widget.TextView;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        ArrayList<BonbonModel> mBonbon = new ArrayList<>();

        mBonbon.add(new BonbonModel(getResources().getString(R.string.Crocodile), null,43.600346, 1.443844));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Tagada), null,43.700998, 1.489429));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Marshmallow), null,42.986370, 1.086368));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Dragibus), null,42.600346, 1.657899));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Ourson), null,42.600346, 1.453197));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Arlequin), null,41.600346, 1.325797));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Oeuf_au_plat), null,41.600346, 1.247864));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Schtroumpfs), null,41.600346, 1.468988));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Carambar), null,41.874795, 1.543278));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Cola), null,41.600346, 1.986432));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Roudoudou), null,41.366438, 1.652399));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Langue_pik), null,42.600346, 1.474789));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Banane), null,41.368976, 1.226799));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Boule_de_mammouth), null,41.576659, 1.653468));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Skittles), null,43.878687, 1.765346));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.M_Ms), null,43.135799, 1.65446));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Papillote), null,42.687674, 1.653457));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Kinder_surprise), null,43.134689, 1.453467));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Car_en_Sac), null,43.457689, 1.453457));

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        MapFragment mapFragment = new MapFragment();
        ft.replace(R.id.ftMain, mapFragment);
        ft.commit();
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
        getMenuInflater().inflate(R.menu.menu, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            MapFragment mapFragment = new MapFragment();
            ft.replace(R.id.ftMain, mapFragment);
            ft.commit();
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
