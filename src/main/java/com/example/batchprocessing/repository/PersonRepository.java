package com.example.batchprocessing.repository;

import com.example.batchprocessing.domain.Person;

import java.util.Map;

public interface PersonRepository {
    void save(Person person);
    Map<String, Person> getAll();
    Person getById(String id);
    void update(Person person);
    void delete(String id);
}
