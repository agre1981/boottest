package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "Person")
public class PersonEntity {

    @Id
    private UUID id;

    private String firstname;

    private String lastname;

    public PersonEntity() {
    }

    public PersonEntity(UUID id, String fName, String lName) {
        this.id = id;
        this.firstname = fName;
        this.lastname = lName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }}
