package com.narola.testSpring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("../../../email.properties")
@Profile("production")
public class ProdConfig {

    @Bean
    public String courseBean()
    {
        return "MCA";
    }

    @Bean
    public Student studentBean()
    {
        return new Student();
    }
    @Bean
    public Person personBean()
    {
        Person person =new Person();
        person.setName("nandu");
        return person;
    }

}
