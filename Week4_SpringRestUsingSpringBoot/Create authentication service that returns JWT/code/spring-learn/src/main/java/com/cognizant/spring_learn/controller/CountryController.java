package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.exception.CountryNotFoundException;
import com.cognizant.spring_learn.model.Country;
import com.cognizant.spring_learn.service.CountryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }


    @GetMapping("/country/{code}")
    private Country getCountry(@PathVariable("code") String code) {
        try {
            return countryService.getCountry(code);
        } catch (CountryNotFoundException e) {
            return null;
        }
    }

    @GetMapping("/countries")
    private List<Country> getAllCountry() {
        return countryService.getAllCountry();
    }
}
