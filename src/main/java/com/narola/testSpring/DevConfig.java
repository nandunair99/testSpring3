package com.narola.testSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

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
    public Student studentBean() {
        return new Student();
    }

    @Bean
    public Person personBean() {
        Person person = new Person();
        person.setName("Hardik");
        person.setAge(26);
        return person;
    }

}
