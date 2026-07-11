package com.cognizant;

import com.cognizant.entity.Country;
import com.cognizant.repository.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryRepository countryRepository;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryRepository = context.getBean(CountryRepository.class);

        testFindByNameContaining();
        testFindByNameContainingOrderByName();
        testFindByNameStartingWith();
    }

    private static void testFindByNameContaining() {
        LOGGER.info("Start");
        List<Country> countries = countryRepository.findByNameContaining("ou");
        LOGGER.debug("Countries containing 'ou': {}", countries);
        LOGGER.info("End");
    }

    private static void testFindByNameContainingOrderByName() {
        LOGGER.info("Start");
        List<Country> countries = countryRepository.findByNameContainingOrderByName("ou");
        LOGGER.debug("Countries containing 'ou' ordered: {}", countries);
        LOGGER.info("End");
    }

    private static void testFindByNameStartingWith() {
        LOGGER.info("Start");
        List<Country> countries = countryRepository.findByNameStartingWith("Z");
        LOGGER.debug("Countries starting with 'Z': {}", countries);
        LOGGER.info("End");
    }
}
