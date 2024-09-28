package com.manirathnam.demoapp.model;

public class Country {


    private int id;

    private String countryName;

    private String capitalName;

    public Country(int id, String countryName, String capitalName) {
        this.id = id;
        this.countryName = countryName;
        this.capitalName = capitalName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", countryName='" + countryName + '\'' +
                ", capitalName='" + capitalName + '\'' +
                '}';
    }
}
