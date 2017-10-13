package com.example.demo.controllers;

import com.example.demo.entity.PersonEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class PersonControllerTest extends BaseControllerTest {

    @Autowired
    private PersonController personController;

    private JacksonTester<PersonEntity> personEntityJacksonTester;

    @Before
    public void setUp() throws Exception {
        initController(personController);
    }

    @Test
    public void testHome() throws Exception {
        MvcResult res = mockMvc.perform(MockMvcRequestBuilders.get("/person")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        PersonEntity person = personEntityJacksonTester.parse(res.getResponse().getContentAsString()).getObject();

        Assert.assertEquals("First Name", person.getFirstname());
        Assert.assertEquals("Last Name", person.getLastname());
    }

}