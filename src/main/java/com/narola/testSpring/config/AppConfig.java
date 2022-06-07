package com.narola.testSpring.config;

import com.narola.testSpring.model.Student;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
@Import({DevConfig.class, ProdConfig.class})
public class AppConfig {

    @Bean
    public Student studentBean() {
        return new Student();
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("errorMessages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
