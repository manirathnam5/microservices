package com.manirathnam.demoapp.dao;

import com.manirathnam.demoapp.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends JpaRepository<Country,Integer> {


   }
