package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService( CountryRepository countryRepository) {
        this.countryRepository = countryRepository;

    }

    @Transactional
    public List<Country> getAllCountries(){
       return countryRepository.findAll();
    }

    @Transactional
    public List<Country> getCountriesByNameContaining(String name){
        return countryRepository.findCountriesByNameContainingOrderByName(name);
    }

    public List<Country> getCountriesByAlphabetCodeStartingWith(String alphabet){
        return countryRepository.findCountriesByNameStartingWith(alphabet);
    }
}
