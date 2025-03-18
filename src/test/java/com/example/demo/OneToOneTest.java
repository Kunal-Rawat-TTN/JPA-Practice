package com.example.demo;

import com.example.demo.Models.Drivers.License;
import com.example.demo.Models.Drivers.Person;
import com.example.demo.Repository.LicenseRepository;
import com.example.demo.Repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.sql.Date;

@SpringBootTest
@Rollback(value = false)
class OneToOneTest {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    LicenseRepository licenseRepository;

    @Test
    void createOneToOneData()
    {
        License license= new License("2-Wheeler", Date.valueOf("2025-10-22"),Date.valueOf("2035-10-21"));
        Person person=new Person("Kunal","Rawat",23,license);
        personRepository.save(person);
    }

//    @Test
//    void createOneToOneData2()
//    {
//        License license= new License("2-Wheeler", Date.valueOf("2025-10-22"),Date.valueOf("2035-10-21"));
//        Person person=new Person("Kunal","Rawat",23,license);
//        personRepository.save(person);
//    }
}
