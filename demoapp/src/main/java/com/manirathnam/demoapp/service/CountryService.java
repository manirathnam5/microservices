package com.manirathnam.demoapp.service;

import com.manirathnam.demoapp.dao.CountryRepo;
import com.manirathnam.demoapp.model.AddResponse;
import com.manirathnam.demoapp.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class CountryService {


    @Autowired
    private CountryRepo countryRepo;


    public List<Country> getAllCountry() {

        return countryRepo.findAll();

    }


    public Country getCountryById(int id) {
        return countryRepo.findById(id).get();

    }

    public Country getCountryByName(String countryByName) {
        List<Country> countries = countryRepo.findAll();
        Country country = null;

        for (Country c : countries) {
            if (c.getCountryName().equalsIgnoreCase(countryByName))
                country = c;
        }
        return country;

    }


    public Country addCountryName(Country country) {
        country.setId(getMaxID());
        countryRepo.save(country);
        return country;
    }

    //utility method to maxID
    public int getMaxID() {

        return countryRepo.findAll().size() + 1;
    }


    public Country updateCountry(Country country) {

        countryRepo.save(country);
        return country;
    }

    public AddResponse deleteCountry(int id) {
        countryRepo.deleteById(id);
        AddResponse res = new AddResponse();
        res.setId(id);
        res.setMessage("Country deleted ...");
        return res;
    }

}


// Uncomment the below code works without connecting to DB
/*

@Component
public class CountryService {


    private static HashMap<Integer, Country> countryHashMap;

    public CountryService() {
        countryHashMap = new HashMap<Integer, Country>();
        countryHashMap.put(1, new Country(1, "INDIA", "DELHI"));
        countryHashMap.put(2, new Country(2, "Australia", "Sydney"));
        countryHashMap.put(3, new Country(3, "America", "Washington"));
        countryHashMap.put(4, new Country(1, "ENGLAND", "LONDON"));


    }


    public List<Country> getAllCountry() {
        //return new ArrayList<>(countryHashMap.values());
        return new ArrayList<>(countryHashMap.values());
    }

    public Country getCountryById(int id) {
        return countryHashMap.get(id);
    }

    public Country getCountryByName(String countryByName) {
        Country country = null;
        for (int i : countryHashMap.keySet()) {
            if (countryHashMap.get(i).getCountryName().equals(countryByName)) {
                country = countryHashMap.get(i);
            }
        }
        return country;
    }


    public Country addCountryName(Country country) {
        country.setId(getMaxID());
        countryHashMap.put(country.getId(), country);
        return country;
    }

    //utility method to maxID
    public static int getMaxID() {

        int max = 0;

        for (int id : countryHashMap.keySet()) {
            if (max <= id)
                max = id;
        }
        return max + 1;
    }


    public AddResponse deleteCountry(int id){
        countryHashMap.remove(id);
        AddResponse res = new AddResponse();
        res.setId(id);
        res.setMessage("Country deleted ...");
        return res;
    }

}
*/
