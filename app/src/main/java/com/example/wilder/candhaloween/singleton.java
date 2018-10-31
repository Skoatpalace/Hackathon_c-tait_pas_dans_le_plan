package com.example.wilder.candhaloween;

import java.util.ArrayList;

class singleton {
    private int compteur;
    private boolean gris;
    private static final singleton ourInstance = new singleton();
    private ArrayList<BonbonModel> Bonbons = new ArrayList<>();

    static singleton getInstance() {
        return ourInstance;
    }

    private singleton() {
    }
    public void ajc1(){
        compteur++;
    }
    public void ajc2(){
        compteur=compteur+2;
    }


    public int getCompteur() {
        return compteur;
    }

    public boolean isGris() {
        return true;
    }

    public void setGris(boolean gris) {
        this.gris = gris;
    }

    public void listeb() {
        ArrayList<BonbonModel> bonbons = new ArrayList<>();
    }

    public ArrayList<BonbonModel> getBonbons() {
        ArrayList<BonbonModel> bonbons = new ArrayList<>();

        return Bonbons;
    }

    public void setBonbons(ArrayList<BonbonModel> bonbons) {
        Bonbons = bonbons;
    }
}
