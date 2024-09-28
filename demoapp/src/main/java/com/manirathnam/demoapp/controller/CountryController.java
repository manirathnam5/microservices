package com.manirathnam.demoapp.controller;

import com.manirathnam.demoapp.model.AddResponse;
import com.manirathnam.demoapp.model.Country;
import com.manirathnam.demoapp.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/getCountries")
    public List<Country> getAllCountryies(){
        return countryService.getAllCountry();
    }

    @GetMapping("/getCountries/{id}")
    public Country getCountryById(@PathVariable(value = "id") int id){
        return countryService.getCountryById(id);
    }

    @GetMapping("/getCountries/country")
    public Country getCountryByName(@RequestParam(value = "name")String countryName){
        return countryService.getCountryByName(countryName);
    }


    @PostMapping("/addcountry")
    public Country addCountry(@RequestBody Country country){
      return countryService.addCountryName(country);

    }


    @PostMapping("/updatecountry")
    public Country updateCountry(@RequestBody Country country){
        return countryService.addCountryName(country);

    }

    @DeleteMapping("/deletecountry/{id}")
    public AddResponse deleteCountry(@PathVariable(value = "id") int id){
        return countryService.deleteCountry(id);

    }


}
