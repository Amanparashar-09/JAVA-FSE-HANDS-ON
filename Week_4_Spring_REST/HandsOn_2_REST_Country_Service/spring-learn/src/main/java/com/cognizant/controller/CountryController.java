package com.cognizant.controller;

import com.cognizant.model.Country;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return Arrays.asList(
            new Country("US", "United States"),
            new Country("IN", "India"),
            new Country("DE", "Germany"),
            new Country("JP", "Japan")
        );
    }

    @GetMapping("/countries/{code}")
    public Country getCountryByCode(@PathVariable String code) {
        return getAllCountries().stream()
            .filter(c -> c.getCode().equalsIgnoreCase(code))
            .findFirst()
            .orElse(null);
    }
}
