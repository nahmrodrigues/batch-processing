package com.example.batchprocessing;

import com.example.batchprocessing.domain.Person;
import com.example.batchprocessing.repository.PersonRepository;

import org.springframework.batch.item.ItemWriter;
import java.util.List;

public class PersonItemWriter implements ItemWriter<Person> {

    private PersonRepository personRepository;

    public PersonItemWriter(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void write(List<? extends Person> list) throws Exception {
        list.forEach(person -> personRepository.save(person));
    }
}
