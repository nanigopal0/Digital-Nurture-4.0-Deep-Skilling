package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.exception.CountryNotFoundException;
import com.cognizant.spring_learn.model.Country;
import com.cognizant.spring_learn.service.CountryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @RequestMapping(method = RequestMethod.GET,path = "country")
     public Country getCountryIndia(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        return context.getBean("country",Country.class);
    }

    @GetMapping("/countries/{code}")
    private Country getCountry(@PathVariable("code") String code){
        try{
            return countryService.getCountry(code);
        }catch (CountryNotFoundException e){
            return null;
        }
    }


}
