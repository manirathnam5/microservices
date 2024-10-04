package com.manirathnam.demoapp.controller;

import com.manirathnam.demoapp.model.AddResponse;
import com.manirathnam.demoapp.model.Country;
import com.manirathnam.demoapp.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/getCountries")
    public List<Country> getAllCountryies() {
        return countryService.getAllCountry();
    }

    @GetMapping("/getCountries/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable(value = "id") int id) {
        try {
            Country country = countryService.getCountryById(id);
            //new ResponseEntity<Country>()
            return new ResponseEntity<Country>(country, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/getCountries/country")
    public ResponseEntity<Country> getCountryByName(@RequestParam(value = "name") String countryName) {
        try {
            Country country = countryService.getCountryByName(countryName);
            //new ResponseEntity<Country>()
            return new ResponseEntity<Country>(country, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/addcountry")
    public Country addCountry(@RequestBody Country country) {
        return countryService.addCountryName(country);

    }

    //there is bug in the below code

    @PostMapping("/updatecountry/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable(value = "id") int id, @RequestBody Country country) {

        try {
            Country existCountry = countryService.getCountryById(id);

            existCountry.setCountryName(country.getCountryName());
            existCountry.setCapitalName(country.getCapitalName());

            Country updatedCountry = countryService.updateCountry(existCountry);
            return new ResponseEntity<Country>(updatedCountry, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    // need to check the below code

    @DeleteMapping("/deletecountry/{id}")
    public ResponseEntity<Country> deleteCountry(@PathVariable(value = "id") int id) {

        Country country = null;

        try {
           // country = countryService.getCountryById(id);
            countryService.deleteCountry(id);
        }
        catch(NoSuchElementException noSuchElementException){
            return  new ResponseEntity<>(HttpStatus.OK);

        }
        return  new ResponseEntity<Country>(country,HttpStatus.OK);
    }


}
