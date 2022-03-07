package com.example.batchprocessing;

import com.example.batchprocessing.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public Person process(final Person person) throws Exception {
        final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getLastName().toUpperCase();

        log.info("Converting (" + person + ") into ");

        person.setFirstName(firstName);
        person.setLastName(lastName);

        log.info("(" + person + ")");

        return person;
    }

}