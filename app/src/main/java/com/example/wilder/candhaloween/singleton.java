package com.example.wilder.candhaloween;

class singleton {
    private int compteur;
    private boolean gris;
    private static final singleton ourInstance = new singleton();

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

}
