package com.example.batchprocessing.config;

//import org.springframework.boot.context.properties.ConfigurationProperties;
import com.example.batchprocessing.domain.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfiguration {

    @Bean
    JedisConnectionFactory jedisConnectionFactory(String host, Integer port, String password) {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(host, port);
        config.setPassword(password);
        return new JedisConnectionFactory(config);
    }

    @Bean
    RedisTemplate<String, Person> redisTemplate(@Value("${app.conf.datasource.redis.host}") String host,
                                                @Value("${app.conf.datasource.redis.port}") Integer port,
                                                @Value("${app.conf.datasource.redis.password}") String password) {
        RedisTemplate redisTemplate = new RedisTemplate<String, Person>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory(host, port, password));
        return redisTemplate;
    }
}
