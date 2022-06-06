package com.narola.testSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class Student {
    @Autowired
    Environment environment;
    
    @Valid
    @IsPersonValid()
    private Person person;
    @NotNull(message = "Course cannot be null")
    private String course;

    public Person getPerson() {
        return person;
    }

    @Autowired
    public void setPerson(Person person) {
        this.person = person;
    }

    public String getCourse() {
        return course;
    }

    @Autowired
    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "person=" + person +
                ", course='" + course + '\'' +
                '}';
    }

    public void getProperties() {
        System.out.println(environment.getProperty("user"));
    }

}
