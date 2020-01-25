package com.sma.backend.multidb.controller;

import com.sma.backend.multidb.database.mysql.domain.CategoryEntity;
import com.sma.backend.multidb.database.mysql.repository.CategoryRepository;
import com.sma.backend.multidb.database.sqlserver.domain.CountryEntity;
import com.sma.backend.multidb.database.sqlserver.repository.CountryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api")
@Slf4j
public class TestController {


    private CategoryRepository categoryRepository;
    private CountryRepository countryRepository;

    @Autowired
    TestController(CategoryRepository categoryRepository, CountryRepository countryRepository) {
        this.categoryRepository = categoryRepository;
        this.countryRepository = countryRepository;
    }

    @RequestMapping(value = "category", method = RequestMethod.POST)
    public ResponseEntity<CategoryEntity> createCategory(@RequestBody CategoryEntity domain) {

        categoryRepository.save(domain);
        return ResponseEntity.ok(domain);
    }


    @RequestMapping(value = "country", method = RequestMethod.POST)
    public ResponseEntity<CountryEntity> createCountry(@RequestBody CountryEntity domain)  {
        countryRepository.save(domain);
        return ResponseEntity.ok(domain);
    }


    @RequestMapping(value = "all", method = RequestMethod.GET)
    public Map<String, Object> getAll() {
        final Map<String, Object> result = new HashMap<>();
        result.put("country", countryRepository.findAll());
        result.put("category", categoryRepository.findAll());

        return result;
    }

}
