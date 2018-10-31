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
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
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

    final static int POPUP_POSITION_X = 0;
    final static int POPUP_POSITION_Y = 0;
    private PopupWindow popUp;

    @Override
    public void onMapReady(GoogleMap googleMap) {
        ArrayList<BonbonModel> mBonbon = new ArrayList<>();

        mBonbon.add(new BonbonModel(getResources().getString(R.string.Crocodile), "@drawable/crocodilebonbno",43.600346, 1.443844));
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

        ArrayList<Gagemodel>mGage= new ArrayList<>();
        mGage.add(new Gagemodel(getString(R.string.gage1),43.606838,	1.465845));
        mGage.add(new Gagemodel(getString(R.string.gage2),43.604268,	1.441019));
        mGage.add(new Gagemodel(getString(R.string.gage3),43.614954,1.499982));
        mGage.add(new Gagemodel(getString(R.string.gage4),43.604268,	1.441019));
        mGage.add(new Gagemodel(getString(R.string.gage5),43.567716,	1.487043));

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
            BonbonModel bonbonModel=mBonbon.get(0);
            Gagemodel gagemodel =mGage.get(0);
            Gagemodel gagemodel2 =mGage.get(1);
            Gagemodel gagemodel3 =mGage.get(2);
            Gagemodel gagemodel4 =mGage.get(3);
            Gagemodel gagemodel5 =mGage.get(4);
            BonbonModel bonbonModel2=mBonbon.get(1);
            BonbonModel bonbonModel3=mBonbon.get(2);
            BonbonModel bonbonModel4=mBonbon.get(3);
            BonbonModel bonbonModel5=mBonbon.get(4);
            BonbonModel bonbonModel6=mBonbon.get(5);
            BonbonModel bonbonModel7=mBonbon.get(6);
            BonbonModel bonbonModel8=mBonbon.get(7);
            BonbonModel bonbonModel9=mBonbon.get(8);
            BonbonModel bonbonModel10=mBonbon.get(9);
            BonbonModel bonbonModel11=mBonbon.get(10);
            BonbonModel bonbonModel12=mBonbon.get(11);
            BonbonModel bonbonModel13=mBonbon.get(12);
            BonbonModel bonbonModel14=mBonbon.get(13);


            Marker marker = mMap.addMarker(new MarkerOptions().position(esquirol).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
            Marker markerB = mMap.addMarker(new MarkerOptions().position(new LatLng(bonbonModel.getLatitude(), bonbonModel.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
            Marker markerB2 = mMap.addMarker(new MarkerOptions().position(new LatLng(bonbonModel2.getLatitude(), bonbonModel2.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
            Marker markerB3 = mMap.addMarker(new MarkerOptions().position(new LatLng(bonbonModel3.getLatitude(), bonbonModel3.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
            Marker markerB4 = mMap.addMarker(new MarkerOptions().position(new LatLng(bonbonModel4.getLatitude(), bonbonModel4.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
            Marker markerB5 = mMap.addMarker(new MarkerOptions().position(new LatLng(bonbonModel5.getLatitude(), bonbonModel5.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
            Marker markerB6 = mMap.addMarker(new MarkerOptions().position(new LatLng(bonbonModel6.getLatitude(), bonbonModel6.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
            Marker markerB7 = mMap.addMarker(new MarkerOptions().position(new LatLng(bonbonModel7.getLatitude(), bonbonModel7.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
            Marker markerB8 = mMap.addMarker(new MarkerOptions().position(new LatLng(bonbonModel8.getLatitude(), bonbonModel8.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
            Marker markerB9 = mMap.addMarker(new MarkerOptions().position(new LatLng(bonbonModel9.getLatitude(), bonbonModel9.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
            Marker markerB10 = mMap.addMarker(new MarkerOptions().position(new LatLng(bonbonModel10.getLatitude(), bonbonModel10.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
            Marker markerB11 = mMap.addMarker(new MarkerOptions().position(new LatLng(bonbonModel11.getLatitude(), bonbonModel11.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
            Marker markerB12 = mMap.addMarker(new MarkerOptions().position(new LatLng(bonbonModel12.getLatitude(), bonbonModel12.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
            Marker markerB13 = mMap.addMarker(new MarkerOptions().position(new LatLng(bonbonModel13.getLatitude(), bonbonModel13.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
            Marker markerB14 = mMap.addMarker(new MarkerOptions().position(new LatLng(bonbonModel14.getLatitude(), bonbonModel14.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
           // Marker markerB = mMap.addMarker(new MarkerOptions().position(new LatLng(bonbonModel.getLatitude(), bonbonModel.getLongitude())));

            Marker markerG= mMap.addMarker(new MarkerOptions().position(new LatLng(gagemodel.getLatitude(),gagemodel.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
            Marker markerG2= mMap.addMarker(new MarkerOptions().position(new LatLng(gagemodel2.getLatitude(),gagemodel2.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
            Marker markerG3= mMap.addMarker(new MarkerOptions().position(new LatLng(gagemodel3.getLatitude(),gagemodel3.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
            Marker markerG4= mMap.addMarker(new MarkerOptions().position(new LatLng(gagemodel4.getLatitude(),gagemodel4.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));

            //Marker markerG= mMap.addMarker(new MarkerOptions().position(new LatLng(gagemodel.getLatitude(),gagemodel.getLongitude())));
        }

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                ArrayList<Gagemodel> mGage = new ArrayList<>();
                mGage.add(new Gagemodel(getString(R.string.gage1), 43.606838, 1.465845));
                mGage.add(new Gagemodel(getString(R.string.gage2), 43.604268, 1.441019));
                mGage.add(new Gagemodel(getString(R.string.gage3), 43.614954, 1.499982));
                mGage.add(new Gagemodel(getString(R.string.gage4), 43.604268, 1.441019));
                mGage.add(new Gagemodel(getString(R.string.gage5), 43.567716, 1.487043));
                Gagemodel gagemodel = mGage.get(0);
                Gagemodel gagemodel2 = mGage.get(1);
                Gagemodel gagemodel3 = mGage.get(2);
                Gagemodel gagemodel4 = mGage.get(3);
                Gagemodel gagemodel5 = mGage.get(4);

                Marker markerG = mMap.addMarker(new MarkerOptions().position(new LatLng(gagemodel.getLatitude(), gagemodel.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
                Marker markerG2 = mMap.addMarker(new MarkerOptions().position(new LatLng(gagemodel2.getLatitude(), gagemodel2.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
                Marker markerG3 = mMap.addMarker(new MarkerOptions().position(new LatLng(gagemodel3.getLatitude(), gagemodel3.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
                Marker markerG4 = mMap.addMarker(new MarkerOptions().position(new LatLng(gagemodel4.getLatitude(), gagemodel4.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
               //Marker markerG5 = mMap.addMarker(new MarkerOptions().position(new LatLng(gagemodel5.getLatitude(), gagemodel5.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));

                if (marker == markerG) {

                    final TextView textviewinfo = (TextView) getView().findViewById(R.id.tv_cage1);
                    textviewinfo.setVisibility(View.VISIBLE);
                    textviewinfo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            textviewinfo.setVisibility(View.INVISIBLE);
                        }
                    });
                    // Toast.makeText(getActivity(), R.string.catchbonbon, Toast.LENGTH_SHORT)

                }
                if (marker == markerG2) {

                    final TextView textviewinfo = (TextView) getView().findViewById(R.id.tv_cage2);
                    textviewinfo.setVisibility(View.VISIBLE);
                    textviewinfo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            textviewinfo.setVisibility(View.INVISIBLE);
                        }
                    });
                    // Toast.makeText(getActivity(), R.string.catchbonbon, Toast.LENGTH_SHORT)

                }
                if (marker == markerG3) {

                    final TextView textviewinfo = (TextView) getView().findViewById(R.id.tv_cage3);
                    textviewinfo.setVisibility(View.VISIBLE);
                    textviewinfo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            textviewinfo.setVisibility(View.INVISIBLE);
                        }
                    });
                    // Toast.makeText(getActivity(), R.string.catchbonbon, Toast.LENGTH_SHORT)

                }
                if (marker == markerG4) {

                    final TextView textviewinfo = (TextView) getView().findViewById(R.id.tv_cage4);
                    textviewinfo.setVisibility(View.VISIBLE);
                    textviewinfo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            textviewinfo.setVisibility(View.INVISIBLE);
                        }
                    });
                    // Toast.makeText(getActivity(), R.string.catchbonbon, Toast.LENGTH_SHORT)

                }

                return false;
            }
        });
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

        //TODO: A faire démarrer quand click sur trick + visible
        //ImageView ivPumpkin = (ImageView) getActivity().findViewById(R.id.iv_pumpkin);
        //ivPumpkin.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.tourne_infini));
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
    public LatLng getRandomLocation(LatLng point, int radius) {

        List<LatLng> randomPoints = new ArrayList<>();
        List<Float> randomDistances = new ArrayList<>();
        Location myLocation = new Location("");
        myLocation.setLatitude(point.latitude);
        myLocation.setLongitude(point.longitude);

        //This is to generate 10 random points
        for (int i = 0; i < 10; i++) {
            double x0 = point.latitude;
            double y0 = point.longitude;

            Random random = new Random();

            // Convert radius from meters to degrees
            double radiusInDegrees = radius / 111000f;

            double u = random.nextDouble();
            double v = random.nextDouble();
            double w = radiusInDegrees * Math.sqrt(u);
            double t = 2 * Math.PI * v;
            double x = w * Math.cos(t);
            double y = w * Math.sin(t);

            // Adjust the x-coordinate for the shrinking of the east-west distances
            double new_x = x / Math.cos(y0);

            double foundLatitude = new_x + x0;
            double foundLongitude = y + y0;
            LatLng randomLatLng = new LatLng(foundLatitude, foundLongitude);
            randomPoints.add(randomLatLng);
            Location l1 = new Location("");
            l1.setLatitude(randomLatLng.latitude);
            l1.setLongitude(randomLatLng.longitude);
            randomDistances.add(l1.distanceTo(myLocation));
        }
        //Get nearest point to the centre
        int indexOfNearestPointToCentre = randomDistances.indexOf(Collections.min(randomDistances));
        return randomPoints.get(indexOfNearestPointToCentre);
    }



}
