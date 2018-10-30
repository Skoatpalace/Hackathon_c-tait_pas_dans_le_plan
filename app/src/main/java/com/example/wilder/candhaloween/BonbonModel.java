package com.example.wilder.candhaloween;

public class BonbonModel {

    private String name;
    private String photo;

    public BonbonModel(String name, String photo){

        this.name = name;
        this.photo = photo;
    }
    public BonbonModel(){}

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
