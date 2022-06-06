package com.narola.testSpring;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator{

    public boolean supports(Class cls) {
        return Person.class.equals(cls);
    }

    public void validate(Object obj, Errors e) {
        ValidationUtils.rejectIfEmpty(e, "name", "person.name_null");
        Person p = (Person) obj;
        if (p.getAge() < 0) {
            e.rejectValue("age", "person.age_negative");
        } else if (p.getAge() > 100) {
            e.rejectValue("age", "person.age_old");
        }
    }
}