package com.narola.testSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("development");
        context.register(AppConfig.class);
        context.refresh();
        Student student1=(Student)context.getBean("studentBean");
        System.out.println(student1);
    }

}
