package com.example.wilder.candhaloween;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    int compteur=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        singleton singletonn = singleton.getInstance();
        ArrayList<BonbonModel> mBonbon = new ArrayList<>();
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Crocodile), getResources().getDrawable(R.drawable.crocodilebonbno),43.600346, 1.443844));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Tagada), getResources().getDrawable(R.drawable.tagadabonbon),43.700998, 1.489429));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Marshmallow), getResources().getDrawable(R.drawable.marshmallow),42.986370, 1.086368));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Dragibus), getResources().getDrawable(R.drawable.dragibus),42.600346, 1.657899));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Ourson), getResources().getDrawable(R.drawable.ourson),42.600346, 1.453197));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Arlequin), getResources().getDrawable(R.drawable.arlequin),41.600346, 1.325797));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Oeuf_au_plat), getResources().getDrawable(R.drawable.oeuf),41.600346, 1.247864));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Schtroumpfs), getResources().getDrawable(R.drawable.schtrounf),41.600346, 1.468988));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Carambar), getResources().getDrawable(R.drawable.carambar),41.874795, 1.543278));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Cola), getResources().getDrawable(R.drawable.cola),41.600346, 1.986432));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Roudoudou), getResources().getDrawable(R.drawable.roudoudou),41.366438, 1.652399));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Langue_pik), getResources().getDrawable(R.drawable.languedechat),42.600346, 1.474789));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Banane), getResources().getDrawable(R.drawable.bananebonbon),41.368976, 1.226799));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Boule_de_mammouth), getResources().getDrawable(R.drawable.mamouthbonbon),41.576659, 1.653468));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Skittles), getResources().getDrawable(R.drawable.skittlesbonbon),43.878687, 1.765346));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.M_Ms), getResources().getDrawable(R.drawable.mnmbonbon),43.135799, 1.65446));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Kinder_surprise), getResources().getDrawable(R.drawable.kindersurprisebonbon),43.134689, 1.453467));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Car_en_Sac), getResources().getDrawable(R.drawable.pilsbonbon),43.457689, 1.453457));


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //NavigationView navigationView = findViewById(R.id.nav_view);
        View headerview = navigationView.getHeaderView(0);
        if(singletonn.getCompteur()<10){
        ImageView imageUser = headerview.findViewById(R.id.imageView);

        }
        if (singletonn.getCompteur()>10 && singletonn.getCompteur()<15){
            ImageView imageUser2 = headerview.findViewById(R.id.imageView2);
            ImageView imageUser = headerview.findViewById(R.id.imageView);
            imageUser.setVisibility(View.INVISIBLE);
            imageUser2.setVisibility(View.VISIBLE);


        }
        if (singletonn.getCompteur()>15){
            ImageView imageUser3 = headerview.findViewById(R.id.imageView);
            ImageView imageUser2 = headerview.findViewById(R.id.imageView2);
            imageUser2.setVisibility(View.INVISIBLE);
            imageUser3.setVisibility(View.VISIBLE);

        }


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
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ListFragment listFragment = new ListFragment();
            ft.replace(R.id.ftMain, listFragment);
            ft.commit();

        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
