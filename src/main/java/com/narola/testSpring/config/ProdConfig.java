package com.narola.testSpring.config;

import com.narola.testSpring.model.Person;
import com.narola.testSpring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:productionProperties.properties")
@ComponentScan(basePackages = {"com.narola.testSpring"})
@Profile("production")
public class ProdConfig {

    @Autowired
    Environment environment;

    @Bean
    public String courseBean() {
        return environment.getProperty("courses");
    }



    @Bean
    public Person personBean() {
        Person person = new Person();
        person.setName(null);
        person.setAge(21);
        return person;
    }


}
