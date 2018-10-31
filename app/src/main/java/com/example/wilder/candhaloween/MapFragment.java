package com.example.wilder.candhaloween;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListPopupWindow;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListPopupWindow;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Collections;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.maps.model.MapStyleOptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class MapFragment extends android.support.v4.app.Fragment implements OnMapReadyCallback {

    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;
    private static final float DEFAULT_ZOOM = 17f;

    // private static final String TAG = MapsFragment.class.getSimpleName();

    private LatLng esquirol = new LatLng(43.600346, 1.443844);


    //vars
    private Boolean mLocationPermissionsGranted = false;
    private GoogleMap mMap;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private Marker markerb;

    final static int POPUP_POSITION_X = 0;
    final static int POPUP_POSITION_Y = 0;
    private PopupWindow popUp;



    @Override
    public void onMapReady(GoogleMap googleMap) {
        ArrayList<BonbonModel> mBonbon = new ArrayList<>();

        mBonbon.add(new BonbonModel(getResources().getString(R.string.Crocodile), null,43.606489, 1.444153));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Tagada), null,43.592190, 1.441698));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Marshmallow), null,43.594278, 1.444409));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Dragibus), null,43.59923812, 1.43892695));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Ourson), null,43.60201328, 1.44465463));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Arlequin), null,43.59388259, 1.4508802));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Oeuf_au_plat), null,43.60152454, 1.43924955));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Schtroumpfs), null,43.60400284, 1.432515));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Carambar), null,43.59839905, 1.44201096));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Cola), null,43.60572688, 1.45061624));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Roudoudou), null,43.6035295, 1.44562683));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Langue_pik), null,43.59147733, 1.440788));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Banane), null,43.60083768, 1.44874592));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Boule_de_mammouth), null,43.60090453, 1.43445538));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Skittles), null,43.60363231, 1.43805026));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.M_Ms), null,43.59882815, 1.4413074));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Papillote), null,43.59431834, 1.43704105));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Kinder_surprise), null,43.6062955,  1.43540997));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Car_en_Sac), null,43.5974498, 1.44651802));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Reglisse), null,43.59647033, 1.44742451));
        mMap = googleMap;
        mMap.setMapStyle((MapStyleOptions.loadRawResourceStyle(getContext(), R.raw.tyle_json)));
        moveCamera(esquirol, DEFAULT_ZOOM);
        getLocationPermission();
        if (mLocationPermissionsGranted) {
            getDeviceLocation();
            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                mMap.setMyLocationEnabled(true);
            }
            BonbonModel bonbonModel = new BonbonModel();
            //Marker marker = mMap.addMarker(new MarkerOptions().position(esquirol));
            mMap.addMarker(new MarkerOptions().position(new LatLng(bonbonModel.getLatitude(), bonbonModel.getLongitude())));
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_map, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);

        }


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }


    private void getDeviceLocation() {
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getActivity());
        try {
            if (mLocationPermissionsGranted) {
                final Task location = mFusedLocationProviderClient.getLastLocation();
                location.addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if (task.isSuccessful()) {
                            Location currentLocation = (Location) task.getResult();
                            if (currentLocation != null) {
                                moveCamera(esquirol, DEFAULT_ZOOM);

                            }
                        } else {
                            Toast.makeText(getActivity(), R.string.unableCurrentLocation, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        } catch (SecurityException e) {
        }
    }

    private void moveCamera(LatLng latLng, float zoom) {
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));
    }

    private void getLocationPermission() {
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION};
        if (ContextCompat.checkSelfPermission(getActivity().getApplicationContext(),
                FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(getActivity().getApplicationContext(),
                    COURSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                mLocationPermissionsGranted = true;
                mMap.setMyLocationEnabled(true);
                getDeviceLocation();
            } else {
                requestPermissions(permissions,
                        LOCATION_PERMISSION_REQUEST_CODE);
            }
        } else {
            requestPermissions(permissions,
                    LOCATION_PERMISSION_REQUEST_CODE);
        }
    }


    @Override
    @SuppressLint("MissingPermission")
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case LOCATION_PERMISSION_REQUEST_CODE: {
                if (grantResults.length > 0) {
                    for (int i = 0; i < grantResults.length; i++) {
                        if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                            mMap.setMyLocationEnabled(true);
                            getDeviceLocation();
                            return;
                        }
                    }
                }
            }
        }
    }
}


