package com.narola.testSpring;

import org.springframework.stereotype.Component;

import javax.validation.constraints.*;

public class Person {
    @NotNull(message = "name connot be null")
    private String name;
    @Min(value = 24, message = "Age cannot be less than 24")
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("age setter");
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("name setter");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
