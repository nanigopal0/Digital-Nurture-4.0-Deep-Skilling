package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.exception.CountryNotFoundException;
import com.cognizant.spring_learn.model.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {


    public Country getCountry(String code) {
        List<Country> countries = getAllCountry();
        return countries.stream().filter(country -> country.getCode().equalsIgnoreCase(code))
                .findFirst().
                orElseThrow(() -> new CountryNotFoundException("Country code " + code + " not found"));
    }

    public List<Country> getAllCountry(){
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        return (List<Country>) context.getBean("countries");
    }
}
