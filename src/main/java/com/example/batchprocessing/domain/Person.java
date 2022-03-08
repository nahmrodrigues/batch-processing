package com.example.batchprocessing.domain;

import java.io.Serializable;

public class Person implements Serializable {

    private String id;
    private String firstName;
    private String lastName;

    public Person() {
    }

    public Person(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "id: " + id + "firstName: " + firstName + ", lastName: " + lastName;
    }

}