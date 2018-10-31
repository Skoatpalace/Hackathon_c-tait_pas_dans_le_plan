package com.example.wilder.candhaloween;

public class Gagemodel {
    private String name;
    private double latitude;
    private double longitude;

    public Gagemodel(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude=latitude;
        this.longitude=longitude;

    }
    public Gagemodel() {
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}

