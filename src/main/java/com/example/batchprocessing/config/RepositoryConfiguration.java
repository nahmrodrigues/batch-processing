package com.example.batchprocessing.config;

import com.example.batchprocessing.repository.PersonRepository;
import com.example.batchprocessing.repository.PersonRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RepositoryConfiguration {

    @Autowired
    RedisTemplate redisTemplate;

    @Bean
    public PersonRepository personRepository() {
        return new PersonRepositoryImpl(redisTemplate);
    }
}
