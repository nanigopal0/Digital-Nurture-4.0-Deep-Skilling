package com.cognizant.country;

import com.cognizant.country.exception.CountryNotFoundException;
import com.cognizant.country.model.Country;
import com.cognizant.country.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;


@SpringBootApplication
public class CountryApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CountryApplication.class, args);
        countryService = context.getBean(CountryService.class);

        testGetAllCountries();
        testGetCountriesByName("Ind");
        testAddCountry(new Country("Bharat", "BH"));
        testAddCountry(new Country("Bharat (India)", "BI"));
        testGetCountryByCode("BH");
        testUpdateCountry(new Country("Bharat (India)", "BH"));
        testDeleteCountryByCode("BH");
        testDeleteCountry(new Country("Bharat (India)", "BI"));
    }

    private static void testGetAllCountries() {
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("All Countries: ");
        for (int i = 0; i < countries.size(); i += 2) {
            System.out.print(countries.get(i) + "\t \t");
            if (i+1 < countries.size())
                System.out.println(countries.get(i + 1));
        }
    }

    private static void testGetCountriesByName(String countryName) {
        LOGGER.debug("Find Countries By Name: ");
        for (Country country : countryService.getCountriesByName(countryName)) {
            System.out.println(country);
        }
    }

    private static void testGetCountryByCode(String code) {
        try {
            LOGGER.debug("Find Country By Code={}", countryService.getCountryByCode(code));
        } catch (CountryNotFoundException e) {
            LOGGER.error(e.getMessage());
        }
    }

    private static void testAddCountry(Country country) {
        Country saved = countryService.addCountry(country);
        LOGGER.debug("Added Country={}", saved);
    }

    private static void testUpdateCountry(Country country) {
        try {
            Country saved = countryService.updateCountry(country);
            LOGGER.debug("Updated Country={}", saved);
        }catch (CountryNotFoundException e) {
            LOGGER.error(e.getMessage());
        }
    }

    private static void testDeleteCountry(Country country) {
        countryService.deleteCountry(country);
        LOGGER.debug("Deleted Country={}", country);
    }

    private static void testDeleteCountryByCode(String code) {
        countryService.deleteCountry(code);
        LOGGER.debug("Deleted Country! Code={}", code);
    }

}
