package com.narola.testSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value= "classpath:email.properties")
@Profile("development")
public class DevConfig {
    @Autowired
    Environment environment;

    @Bean
    public String courseBean() {
        return environment.getProperty("user.name");
    }

    @Bean
    public Student studentBean() {
        return new Student();
    }

    @Bean
    public Person personBean() {
        Person person = new Person();
        person.setName("hardik");
        return person;
    }
}
