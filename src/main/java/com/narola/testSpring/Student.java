package com.narola.testSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Student {
    private Person person;
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
                "person=" + person.getName() +
                ", course='" + course + '\'' +
                '}';
    }
}
