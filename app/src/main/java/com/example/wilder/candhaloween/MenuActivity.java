package com.example.wilder.candhaloween;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
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
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Crocodile), getResources().getDrawable(R.drawable.crocodilebonbno),43.606489, 1.444153));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Tagada), getResources().getDrawable(R.drawable.tagadabonbon),43.592190, 1.441698));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Marshmallow), getResources().getDrawable(R.drawable.marshmallow),43.594278, 1.444409));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Dragibus), getResources().getDrawable(R.drawable.dragibus),43.594278, 1.444409));
        //mBonbon.add(new BonbonModel(getResources().getString(R.string.Ourson), getResources().getDrawable(R.drawable.ourson),43.59923812, 1.43892695));
        //mBonbon.add(new BonbonModel(getResources().getString(R.string.Arlequin), getResources().getDrawable(R.drawable.arlequin),43.60201328, 1.44465463));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Oeuf_au_plat), getResources().getDrawable(R.drawable.oeuf),43.59388259, 1.4508802));
        //mBonbon.add(new BonbonModel(getResources().getString(R.string.Schtroumpfs), getResources().getDrawable(R.drawable.schtrounf),43.60152454, 1.43924955));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Carambar), getResources().getDrawable(R.drawable.carambar),43.60400284, 1.432515));
        //mBonbon.add(new BonbonModel(getResources().getString(R.string.Cola), getResources().getDrawable(R.drawable.cola),43.59839905, 1.44201096));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Roudoudou), getResources().getDrawable(R.drawable.roudoudou),43.60572688, 1.45061624));
        //mBonbon.add(new BonbonModel(getResources().getString(R.string.Langue_pik), getResources().getDrawable(R.drawable.languedechat),43.6035295, 1.44562683));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Banane), getResources().getDrawable(R.drawable.bananebonbon),43.59147733, 1.440788));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Boule_de_mammouth), getResources().getDrawable(R.drawable.mamouthbonbon),43.60083768, 1.44874592));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Skittles), getResources().getDrawable(R.drawable.skittlesbonbon),43.60090453, 1.43445538));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.M_Ms), getResources().getDrawable(R.drawable.mnmbonbon),43.60363231, 1.43805026));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Kinder_surprise), getResources().getDrawable(R.drawable.kindersurprisebonbon),43.59882815, 1.4413074));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Car_en_Sac), getResources().getDrawable(R.drawable.pilsbonbon),43.59431834, 1.43704105));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Car_en_Sac), getResources().getDrawable(R.drawable.pilsbonbon),43.6062955, 1.43540997));


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

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        MapFragment mapFragment = new MapFragment();
        ft.replace(R.id.ftMain, mapFragment);
        ft.commit();

        final ImageView imageUser = headerview.findViewById(R.id.imageView);

        new Handler().postDelayed(new Runnable(){
            public void run() {
                imageUser.setImageResource(R.drawable.vempire);
            }
        }, 30000);
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
            //MediaPlayer mediaPlayer = MediaPlayer.create(MenuActivity.this,R.raw.clown);
            //mediaPlayer.start();
            ft.commit();
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ListFragment listFragment = new ListFragment();
            ft.replace(R.id.ftMain, listFragment);
            //MediaPlayer mediaPlayer = MediaPlayer.create(MenuActivity.this,R.raw.clown);
            //mediaPlayer.start();
            ft.commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
}
