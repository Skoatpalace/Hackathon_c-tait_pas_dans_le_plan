package com.example.wilder.candhaloween;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
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
    singleton singletonn = singleton.getInstance();
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

        mBonbon.add(new BonbonModel(getResources().getString(R.string.Crocodile), getResources().getDrawable(R.drawable.crocodilebonbno),43.606489, 1.444153));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Tagada), getResources().getDrawable(R.drawable.tagadabonbon),43.592190, 1.441698));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Marshmallow), getResources().getDrawable(R.drawable.marshmallow),43.594278, 1.444409));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Dragibus), getResources().getDrawable(R.drawable.dragibus),43.594278, 1.444409));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Ourson), getResources().getDrawable(R.drawable.ourson),43.59923812, 1.43892695));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Arlequin), getResources().getDrawable(R.drawable.arlequin),43.60201328, 1.44465463));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Oeuf_au_plat), getResources().getDrawable(R.drawable.oeuf),43.59388259, 1.4508802));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Schtroumpfs), getResources().getDrawable(R.drawable.schtrounf),43.60152454, 1.43924955));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Carambar), getResources().getDrawable(R.drawable.carambar),43.60400284, 1.432515));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Cola), getResources().getDrawable(R.drawable.cola),43.59839905, 1.44201096));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Roudoudou), getResources().getDrawable(R.drawable.roudoudou),43.60572688, 1.45061624));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Langue_pik), getResources().getDrawable(R.drawable.languedechat),43.6035295, 1.44562683));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Banane), getResources().getDrawable(R.drawable.bananebonbon),43.59147733, 1.440788));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Boule_de_mammouth), getResources().getDrawable(R.drawable.mamouthbonbon),43.60083768, 1.44874592));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Skittles), getResources().getDrawable(R.drawable.skittlesbonbon),43.60090453, 1.43445538));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.M_Ms), getResources().getDrawable(R.drawable.mnmbonbon),43.60363231, 1.43805026));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Kinder_surprise), getResources().getDrawable(R.drawable.kindersurprisebonbon),43.59882815, 1.4413074));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Car_en_Sac), getResources().getDrawable(R.drawable.pilsbonbon),43.59431834, 1.43704105));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Car_en_Sac), getResources().getDrawable(R.drawable.pilsbonbon),43.6062955, 1.43540997));

        ArrayList<Gagemodel> mGage = new ArrayList<>();
        mGage.add(new Gagemodel(getString(R.string.gage1), 43.606838, 1.465845, getResources().getString(R.string.gage1)));
        mGage.add(new Gagemodel(getString(R.string.gage2), 43.604268, 1.441019, getResources().getString(R.string.gage2)));
        mGage.add(new Gagemodel(getString(R.string.gage3), 43.614954, 1.499982, getResources().getString(R.string.gage3)));
        //mGage.add(new Gagemodel(getString(R.string.gage4), 43.604268, 1.441019, getResources().getString(R.string.gage4)));
        mGage.add(new Gagemodel(getString(R.string.gage4), 43.567716, 1.487043,getResources().getString(R.string.gage4)));

        mMap = googleMap;
        mMap.getUiSettings().setMapToolbarEnabled(false);
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
            BonbonModel bonbonModel15 = mBonbon.get(14);
            BonbonModel bonbonModel16 = mBonbon.get(15);
            BonbonModel bonbonModel17 = mBonbon.get(16);
            BonbonModel bonbonModel18 = mBonbon.get(17);
            BonbonModel bonbonModel19 = mBonbon.get(18);


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
            Marker markerB15 = mMap.addMarker(new MarkerOptions().position(new LatLng(bonbonModel14.getLatitude(), bonbonModel14.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
            Marker markerB16 = mMap.addMarker(new MarkerOptions().position(new LatLng(bonbonModel14.getLatitude(), bonbonModel14.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
            Marker markerB17 = mMap.addMarker(new MarkerOptions().position(new LatLng(bonbonModel14.getLatitude(), bonbonModel14.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
            Marker markerB18 = mMap.addMarker(new MarkerOptions().position(new LatLng(bonbonModel14.getLatitude(), bonbonModel14.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
            Marker markerB19 = mMap.addMarker(new MarkerOptions().position(new LatLng(bonbonModel14.getLatitude(), bonbonModel14.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
            markerB.setTag(bonbonModel);
            markerB2.setTag(bonbonModel2);
            markerB3.setTag(bonbonModel3);
            markerB4.setTag(bonbonModel4);
            markerB5.setTag(bonbonModel5);
            markerB6.setTag(bonbonModel6);
            markerB7.setTag(bonbonModel7);
            markerB8.setTag(bonbonModel8);
            markerB9.setTag(bonbonModel9);
            markerB10.setTag(bonbonModel10);
            markerB11.setTag(bonbonModel11);
            markerB12.setTag(bonbonModel12);
            markerB13.setTag(bonbonModel13);
            markerB14.setTag(bonbonModel14);
            markerB15.setTag(bonbonModel15);
            markerB16.setTag(bonbonModel16);
            markerB17.setTag(bonbonModel17);
            markerB18.setTag(bonbonModel18);
            markerB19.setTag(bonbonModel19);
            Marker markerG = mMap.addMarker(new MarkerOptions().position(new LatLng(gagemodel.getLatitude(), gagemodel.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
            Marker markerG2 = mMap.addMarker(new MarkerOptions().position(new LatLng(gagemodel2.getLatitude(), gagemodel2.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
            Marker markerG3 = mMap.addMarker(new MarkerOptions().position(new LatLng(gagemodel3.getLatitude(), gagemodel3.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
            Marker markerG4 = mMap.addMarker(new MarkerOptions().position(new LatLng(gagemodel4.getLatitude(), gagemodel4.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bonbonlambda)));
            markerG.setTag(gagemodel);
            markerG2.setTag(gagemodel2);
            markerG3.setTag(gagemodel3);
            markerG4.setTag(gagemodel4);
            //Marker markerG= mMap.addMarker(new MarkerOptions().position(new LatLng(gagemodel.getLatitude(),gagemodel.getLongitude())));
        }


        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker markerG) {
                Object stuff = markerG.getTag();
                if (stuff == null) {
                    return false;
                }
                if (stuff.getClass() == Gagemodel.class) {

                    Gagemodel g1=(Gagemodel)markerG.getTag();
                    MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.piano);
                    mediaPlayer.start();
                    final TextView textviewinfo = (TextView) getView().findViewById(R.id.tv_cage1);
                    final ImageView ivNoir = getView().findViewById(R.id.iv_splashscreen);
                    final ImageView ivPumpkin = getView().findViewById(R.id.iv_pumpkin);
                    textviewinfo.setVisibility(View.VISIBLE);
                    ivNoir.setVisibility(View.VISIBLE);
                    ivPumpkin.setVisibility(View.VISIBLE);
                    ivPumpkin.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.tourne_infini));
                    textviewinfo.setText(g1.getGage());
                    ivNoir.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            singletonn.ajc1();
                            textviewinfo.setVisibility(View.INVISIBLE);
                            ivNoir.setVisibility(View.INVISIBLE);
                            ivPumpkin.clearAnimation();
                            ivPumpkin.setVisibility(View.INVISIBLE);
                        }

                    });
                    markerG.setVisible(false);
                } else {
                    BonbonModel b1 = (BonbonModel)markerG.getTag();
                    MediaPlayer mediaPlayerB = MediaPlayer.create(getActivity(),R.raw.papercandy);
                    mediaPlayerB.start();
                    Toast.makeText(getActivity(), b1.getName(), Toast.LENGTH_SHORT).show();
                    singletonn.ajc2();
                    singletonn.setGris(false);
                    markerG.setVisible(false);
                    return false;
                }

                return false;
                // Toast.makeText(getActivity(), R.string.catchbonbon, Toast.LENGTH_SHORT)

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


        final Handler handler = new Handler();
        //final MediaPlayer mediaPlayerC = MediaPlayer.create(getActivity(),R.raw.cri);
        Runnable runnableCode = new Runnable() {
            @Override
            public void run() {
                Log.d("Handlers", "Called on main thread");
                gifSpider.setVisibility(View.VISIBLE);
                //mediaPlayerC.start();
                new Handler().postDelayed(new Runnable(){
                    public void run() {
                        gifSpider.setVisibility(View.INVISIBLE);
                        //mediaPlayerC.stop();
                        //mediaPlayerC.release();
                    }
                }, 4020);
                handler.postDelayed(this, 30000);
            }
        };
// Start the initial runnable task by posting through the handler
        handler.post(runnableCode);
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


