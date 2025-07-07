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
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countries = (ArrayList<Country>) context.getBean("countries");
        return countries.stream().filter(country -> country.getCode().equalsIgnoreCase(code))
                .findFirst().
                orElseThrow(() -> new CountryNotFoundException("Country code " + code + " not found"));
    }
}
