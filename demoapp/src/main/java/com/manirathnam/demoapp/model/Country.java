package com.manirathnam.demoapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Country")
public class Country {


    @Id
    @Column(name="id")
    private int id;
    @Column(name="countryName")
    private String countryName;

    @Column(name="capitalName")
    private String capitalName;

    public Country() {
    }

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
