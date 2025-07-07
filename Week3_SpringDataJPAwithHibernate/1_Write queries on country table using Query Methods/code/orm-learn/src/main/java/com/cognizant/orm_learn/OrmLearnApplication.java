package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;


@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");
        countryService = context.getBean(CountryService.class);
//        testGetAllCountries();
        testGetAllCountriesByNameContaining("ou");
        testGetCountriesByAlphabetCode("z");
    }

    private static void testGetAllCountries() {
        LOGGER.info("Start");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries: ");
        for (Country country : countries) {
            System.out.println(country.getCode() + "\t \t" + country.getName() );
        }
        LOGGER.info("End");
    }

    private static void testGetAllCountriesByNameContaining(String name) {
        LOGGER.info("Start");
        List<Country> countries = countryService.getCountriesByNameContaining(name);
        LOGGER.debug("countries: ");
        for (Country country : countries) {
            System.out.println(country.getCode() + "\t \t" + country.getName() );
        }
        LOGGER.info("End");
    }

    private static void testGetCountriesByAlphabetCode(String alpha) {
        LOGGER.info("Start");
        List<Country> countries = countryService.getCountriesByAlphabetCodeStartingWith(alpha);
        LOGGER.debug("countries: ");
        for (Country country : countries) {
            System.out.println(country.getCode() + "\t \t" + country.getName() );
        }
        LOGGER.info("End");
    }



}
