package com.example.wilder.candhaloween;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class MapFragment extends android.support.v4.app.Fragment implements OnMapReadyCallback {

    final static int POPUP_POSITION_X = 0;
    final static int POPUP_POSITION_Y = 0;
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;

    // private static final String TAG = MapsFragment.class.getSimpleName();
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;
    private static final float DEFAULT_ZOOM = 17f;
    private LatLng esquirol = new LatLng(43.600346, 1.443844);
    //vars
    private Boolean mLocationPermissionsGranted = false;
    private GoogleMap mMap;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private Marker markerb;
    private PopupWindow popUp;

    @Override
    public void onMapReady(GoogleMap googleMap) {
        ArrayList<BonbonModel> mBonbon = new ArrayList<>();

        mBonbon.add(new BonbonModel(getResources().getString(R.string.Crocodile), null, 43.606489, 1.444153));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Tagada), null, 43.592190, 1.441698));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Marshmallow), null, 43.594278, 1.444409));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Dragibus), null, 43.59923812, 1.43892695));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Ourson), null, 43.60201328, 1.44465463));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Arlequin), null, 43.59388259, 1.4508802));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Oeuf_au_plat), null, 43.60152454, 1.43924955));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Schtroumpfs), null, 43.60400284, 1.432515));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Carambar), null, 43.59839905, 1.44201096));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Cola), null, 43.60572688, 1.45061624));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Roudoudou), null, 43.6035295, 1.44562683));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Langue_pik), null, 43.59147733, 1.440788));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Banane), null, 43.60083768, 1.44874592));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Boule_de_mammouth), null, 43.60090453, 1.43445538));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Skittles), null, 43.60363231, 1.43805026));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.M_Ms), null, 43.59882815, 1.4413074));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Papillote), null, 43.59431834, 1.43704105));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Kinder_surprise), null, 43.6062955, 1.43540997));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Car_en_Sac), null, 43.5974498, 1.44651802));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Reglisse), null, 43.59647033, 1.44742451));

        ArrayList<Gagemodel> mGage = new ArrayList<>();
        mGage.add(new Gagemodel(getString(R.string.gage1), 43.606838, 1.465845));
        mGage.add(new Gagemodel(getString(R.string.gage2), 43.604268, 1.441019));
        mGage.add(new Gagemodel(getString(R.string.gage3), 43.614954, 1.499982));
        mGage.add(new Gagemodel(getString(R.string.gage4), 43.604268, 1.441019));
        mGage.add(new Gagemodel(getString(R.string.gage5), 43.567716, 1.487043));

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
            BonbonModel bonbonModel = mBonbon.get(0);
            Gagemodel gagemodel = mGage.get(0);
            Gagemodel gagemodel2 = mGage.get(1);
            Gagemodel gagemodel3 = mGage.get(2);
            Gagemodel gagemodel4 = mGage.get(3);
            Gagemodel gagemodel5 = mGage.get(4);
            BonbonModel bonbonModel2 = mBonbon.get(1);
            BonbonModel bonbonModel3 = mBonbon.get(2);
            BonbonModel bonbonModel4 = mBonbon.get(3);
            BonbonModel bonbonModel5 = mBonbon.get(4);
            BonbonModel bonbonModel6 = mBonbon.get(5);
            BonbonModel bonbonModel7 = mBonbon.get(6);
            BonbonModel bonbonModel8 = mBonbon.get(7);
            BonbonModel bonbonModel9 = mBonbon.get(8);
            BonbonModel bonbonModel10 = mBonbon.get(9);
            BonbonModel bonbonModel11 = mBonbon.get(10);
            BonbonModel bonbonModel12 = mBonbon.get(11);
            BonbonModel bonbonModel13 = mBonbon.get(12);
            BonbonModel bonbonModel14 = mBonbon.get(13);


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

            Marker markerG = mMap.addMarker(new MarkerOptions().position(new LatLng(gagemodel.getLatitude(), gagemodel.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
            Marker markerG2 = mMap.addMarker(new MarkerOptions().position(new LatLng(gagemodel2.getLatitude(), gagemodel2.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
            Marker markerG3 = mMap.addMarker(new MarkerOptions().position(new LatLng(gagemodel3.getLatitude(), gagemodel3.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
            Marker markerG4 = mMap.addMarker(new MarkerOptions().position(new LatLng(gagemodel4.getLatitude(), gagemodel4.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));

            //Marker markerG= mMap.addMarker(new MarkerOptions().position(new LatLng(gagemodel.getLatitude(),gagemodel.getLongitude())));
        }


        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker markerG) {
                markerG.getTag();
                final TextView textviewinfo = (TextView) getView().findViewById(R.id.tv_cage1);
                textviewinfo.setVisibility(View.VISIBLE);
                textviewinfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        textviewinfo.setVisibility(View.INVISIBLE);
                    }
                });
                return false;
                // Toast.makeText(getActivity(), R.string.catchbonbon, Toast.LENGTH_SHORT)

            }
        });
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker markerG2) {
                markerG2.getTag();
                final TextView textviewinfo = (TextView) getView().findViewById(R.id.tv_cage2);
                textviewinfo.setVisibility(View.VISIBLE);
                textviewinfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textviewinfo.setVisibility(View.INVISIBLE);
                    }
                });
                return false;
            }
        });
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker markerG3) {
                markerG3.getTag();
                final TextView textviewinfo = (TextView) getView().findViewById(R.id.tv_cage3);
                textviewinfo.setVisibility(View.VISIBLE);
                textviewinfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textviewinfo.setVisibility(View.INVISIBLE);
                    }
                });
                return false;
            }
        });
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker markerG4) {
                markerG4.getTag();
                final TextView textviewinfo = (TextView) getView().findViewById(R.id.tv_cage4);
                textviewinfo.setVisibility(View.VISIBLE);
                textviewinfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textviewinfo.setVisibility(View.INVISIBLE);
                    }
                });
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

        //#SPIDER
        final GifImageView gifSpider = getActivity().findViewById(R.id.gif_spider);
        gifSpider.setVisibility(View.INVISIBLE);
        new Handler().postDelayed(new Runnable(){
            public void run() {
                gifSpider.setVisibility(View.VISIBLE);
            }
        }, 10000);
        new Handler().postDelayed(new Runnable(){
            public void run() {
                gifSpider.setVisibility(View.INVISIBLE);
            }
        }, 14000);
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


