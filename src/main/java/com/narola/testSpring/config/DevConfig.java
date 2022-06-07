package com.narola.testSpring.config;

import com.narola.testSpring.model.Person;
import com.narola.testSpring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:developmentProperties.properties")
@ComponentScan(basePackages = {"com.narola.testSpring"})
@Profile("development")
public class DevConfig {
    @Autowired
    Environment environment;

    @Bean
    public String courseBean() {
        return environment.getProperty("course");
    }



    @Bean
    public Person personBean() {
        Person person = new Person();
        person.setName("Hardik");
        person.setAge(26);
        return person;
    }

}
