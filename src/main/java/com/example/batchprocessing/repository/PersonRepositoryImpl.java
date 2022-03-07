package com.example.batchprocessing.repository;

import com.example.batchprocessing.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private RedisTemplate<String, Person> redisTemplate;
    private HashOperations hashOperations;

    private static final Logger log = LoggerFactory.getLogger(PersonRepositoryImpl.class);

    public PersonRepositoryImpl(RedisTemplate<String, Person> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Person person) {
        log.info("Saving " + person.getFirstName());
        hashOperations.put("PERSON", person.getId(), person);
    }

    @Override
    public Map<String, Person> getAll() {
        return hashOperations.entries("PERSON");
    }

    @Override
    public Person getById(String id) {
        return (Person) hashOperations.get("PERSON", id);
    }

    @Override
    public void update(Person person) {
        save(person);
    }
    @Override
    public void delete(String id) {
        hashOperations.delete("PERSON", id);
    }
}
