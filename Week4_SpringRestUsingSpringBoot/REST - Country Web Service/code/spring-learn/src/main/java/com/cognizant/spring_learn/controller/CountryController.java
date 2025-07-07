package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @RequestMapping(method = RequestMethod.GET,path = "country")
    Country getCountryIndia(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        return context.getBean("country",Country.class);
    }
}
