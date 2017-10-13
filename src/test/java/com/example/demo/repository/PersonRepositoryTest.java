package com.example.demo.repository;

import com.example.demo.entity.PersonEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PersonRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void findById() {
        UUID id = UUID.randomUUID();
        personRepository.save(new PersonEntity(id, "fName", "lName"));

        entityManager.flush();
        entityManager.clear();

        PersonEntity res = personRepository.findOne(id);

        Assert.assertEquals(id, res.getId());
        Assert.assertEquals("fName", res.getFirstname());
        Assert.assertEquals("lName", res.getLastname());
    }

}