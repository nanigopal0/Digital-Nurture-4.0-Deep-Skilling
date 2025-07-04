package com.cognizant.country.service;

import com.cognizant.country.exception.CountryNotFoundException;
import com.cognizant.country.model.Country;
import com.cognizant.country.repository.CountryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country getCountryByCode(String code) {
        return countryRepository.findById(code).orElseThrow(() -> new CountryNotFoundException("Country with code " + code + " not found"));
    }

    @Transactional
    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    @Transactional
    public Country updateCountry(Country country) {
        Country old = getCountryByCode(country.getCode());
        old.setName(country.getName());
        return countryRepository.save(old);
    }

    @Transactional
    public void deleteCountry(Country country) {
        countryRepository.delete(country);
    }

    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    @Transactional
    public List<Country> getCountriesByName(String name) {
        return countryRepository.findCountriesByNameStartsWith(name);
    }

}
