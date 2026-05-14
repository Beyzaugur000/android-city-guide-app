package com.example.projectstaj_beyzaugur;

import android.content.Intent;

import java.io.Serializable;
import java.util.List;

public class city implements Serializable {

    String cityname;
    int image;
    private List<String> historicalPlaces;
    private List<String> universities;
    private List<String> hospitals;
    private List<String> malls;

    private String description;

    public city(String cityname, int image) {
        this.cityname = cityname;
        this.image = image;

    }

    public String getCityname() {

        return cityname;
    }

    public int getImage() {

        return image;
    }

    public List<String> getHistoricalPlaces() {
        return historicalPlaces;
    }

    public void setHistoricalPlaces(List<String> historicalPlaces) {
        this.historicalPlaces = historicalPlaces;
    }

    public List<String> getUniversities() {
        return universities;
    }

    public void setUniversities(List<String> universities) {
        this.universities = universities;
    }

    public List<String> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<String> hospitals) {
        this.hospitals = hospitals;
    }

    public List<String> getMalls() {
        return malls;
    }

    public void setMalls(List<String> malls) {
        this.malls = malls;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
