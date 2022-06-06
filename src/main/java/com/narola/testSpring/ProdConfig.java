package com.narola.testSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

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
    public Student studentBean() {
        return new Student();
    }

    @Bean
    public Person personBean() {
        Person person = new Person();
        person.setName("nandu");
        person.setAge(-1);
        return person;
    }


}
