package com.manirathnam.demoapp;

import com.manirathnam.demoapp.dao.CountryRepo;
import com.manirathnam.demoapp.model.Country;
import com.manirathnam.demoapp.service.CountryService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {CountryServiceTest.class})
public class CountryServiceTest {

    @Mock
    CountryRepo countryRepo;

    @InjectMocks
    CountryService countryService;

    public List<Country> countryList;


    @Test
    @Order(1)
    public void getAllCountryTest() {

        List<Country> countryList = new ArrayList<>();
        countryList.add(new Country(1, "India", "Delhi"));
        countryList.add(new Country(2, "USA", "California"));
        countryList.add(new Country(3, "Aussies", "Sydney"));

        // Mockito.when(countryService.getAllCountry()).thenReturn(countryList);

        when(countryRepo.findAll()).thenReturn(countryList);
        assertEquals(3, countryService.getAllCountry().size());

    }

    @Test
    @Order(2)
    public void getAllCountryById() {

        List<Country> countryList = new ArrayList<>();
        countryList.add(new Country(1, "India", "Delhi"));
        countryList.add(new Country(2, "USA", "California"));
        countryList.add(new Country(3, "Aussies", "Sydney"));


        int countryId = 2;
        when(countryRepo.findAll()).thenReturn(countryList);
        assertEquals(2, countryService.getCountryById(countryId).getId());

    }


    @Test
    @Order(3)
    public void getAllCountryByName() {

        List<Country> countryList = new ArrayList<>();
        countryList.add(new Country(1, "India", "Delhi"));
        countryList.add(new Country(2, "USA", "California"));
        countryList.add(new Country(3, "Aussies", "Sydney"));


        String countryName = "USA";
        when(countryRepo.findAll()).thenReturn(countryList);
        assertEquals(countryName, countryService.getCountryByName(countryName).getCountryName());

    }


    @Test
    @Order(4)
    public void testAddCountry() {

        Country country = new Country(1, "India", "Delhi");

        when(countryRepo.save(country)).thenReturn(country);
        assertEquals(country, countryService.addCountryName(country));
    }


    @Test
    @Order(5)
    public void testUpdateCountry() {

        Country country = new Country(1, "India", "Delhi");

        when(countryRepo.save(country)).thenReturn(country);
        assertEquals(country, countryService.updateCountry(country));
    }

    @Test
    @Order(6)
    public void testDeleteCountry() {

        Country country = new Country(2, "Germany", "Berlin");

        countryService.deleteCountry(country);

        verify(countryRepo, times(1)).delete(country);
    }


}
