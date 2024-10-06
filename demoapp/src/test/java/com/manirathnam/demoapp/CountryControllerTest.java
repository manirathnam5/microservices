package com.manirathnam.demoapp;


import com.manirathnam.demoapp.controller.CountryController;
import com.manirathnam.demoapp.model.Country;
import com.manirathnam.demoapp.service.CountryService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@TestMethodOrder(MethodOrderer.class)
@SpringBootTest(classes={CountryControllerTest.class} )
public class CountryControllerTest {

    @Mock
    CountryService countryService;

    @InjectMocks
    CountryController countryController;

    List<Country> myCountries;

    Country country;


   @Test
   @Order(1)
   public void getAllCountryTest(){

       myCountries = new ArrayList<>();
       myCountries.add(new Country(1,"INDIA","DELHI"));
       myCountries.add(new Country(2,"INDIA","DELHI"));
       myCountries.add(new Country(3,"INDIA","DELHI"));


       when(countryService.getAllCountry()).thenReturn(myCountries);
       ResponseEntity<List<Country>> res = countryController.getAllCountryies();

       assertEquals(HttpStatus.OK,res.getStatusCode());
       assertEquals(3,res.getBody().size());

   }


   @Test
   @Order(2)
   public void testGetCountryById(){

     country = new Country(3,"USA","New York");
     int countryId = 3;

     when(countryService.getCountryById(countryId)).thenReturn(country);

     ResponseEntity<Country> res = countryController.getCountryById(countryId);

     assertEquals(HttpStatus.OK,res.getStatusCode());
     assertEquals(3,res.getBody().getId());

   }



@Test
@Order(3)
public void testGetCountryByName() {

     country = new Country(3, "USA", "New York");
     String countryName = "USA";

     when(countryService.getCountryByName(countryName)).thenReturn(country);

     ResponseEntity<Country> res = countryController.getCountryByName(countryName);

     assertEquals(HttpStatus.OK, res.getStatusCode());
     assertEquals("USA", res.getBody().getCountryName());
  }
}