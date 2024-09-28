package com.manirathnam.demoapp.service;

import com.manirathnam.demoapp.model.AddResponse;
import com.manirathnam.demoapp.model.Country;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
