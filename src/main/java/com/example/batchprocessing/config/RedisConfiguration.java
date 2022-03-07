package com.example.batchprocessing.config;

//import org.springframework.boot.context.properties.ConfigurationProperties;
import com.example.batchprocessing.domain.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
//@ConfigurationProperties(prefix = "app.conf.datasource.sileg")
public class RedisConfiguration {

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("localhost", 6379);
        return new JedisConnectionFactory();
    }

    @Bean
    RedisTemplate<String, Person> redisTemplate() {
        RedisTemplate redisTemplate = new RedisTemplate<String, Person>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }
}
