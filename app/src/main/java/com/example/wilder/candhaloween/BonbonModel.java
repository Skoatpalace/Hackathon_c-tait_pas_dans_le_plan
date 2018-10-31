package com.example.wilder.candhaloween;

import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BonbonModel {

    private String name;
    private String photo;
    private double latitude;
    private  double longitude;



    public BonbonModel(String name, String photo, double latitude, double longitude) {

        this.name = name;
        this.photo = photo;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public BonbonModel() {
    }



    public  double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }



}






