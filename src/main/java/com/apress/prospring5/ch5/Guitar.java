package com.apress.prospring5.ch5;

public class Guitar {
    private String brand;

    public String play() {
        return "Cm Eb Fm Ab Bb";
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
