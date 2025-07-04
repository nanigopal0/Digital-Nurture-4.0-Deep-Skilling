package com.cognizant.country.repository;

import com.cognizant.country.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country,String > {
    List<Country> findCountriesByNameStartsWith(String name);
}
