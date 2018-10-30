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
    private Location location;

    public BonbonModel(String name, String photo, double latitude, double longitude) {

        this.name = name;
        this.photo = photo;
        this.location = location;
    }

    public BonbonModel() {
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

    public Location getLocation() {

        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}






