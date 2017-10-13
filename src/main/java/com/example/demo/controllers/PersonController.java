package com.example.demo.controllers;

import com.example.demo.entity.PersonEntity;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("/person")
    @ResponseBody PersonEntity home() {

        PersonEntity person = personRepository.findOne( UUID.fromString("d39a2373-da37-4168-a41c-8bfb6247f4fd") );
        return person;
    }
}
