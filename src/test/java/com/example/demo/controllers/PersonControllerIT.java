package com.example.demo.controllers;

import com.example.demo.entity.PersonEntity;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.json.JacksonTester;

public class PersonControllerIT extends BaseControllerIT {

    private JacksonTester<PersonEntity> personEntityJacksonTester;

    @Test
    public void testHome() throws Exception {
        String body = this.restTemplate.getForObject("/person", String.class);

        PersonEntity person = personEntityJacksonTester.parse(body).getObject();

        Assert.assertEquals("First Name", person.getFirstname());
        Assert.assertEquals("Last Name", person.getLastname());
    }

}