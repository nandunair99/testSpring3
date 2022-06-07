package com.narola.testSpring.validator;

import com.narola.testSpring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class StudentValidator implements Validator {
    @Autowired
    private PersonValidator personValidator;

    @Override
    public boolean supports(Class<?> clazz) {
        return Student.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Student student = (Student) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "course", "student.course_null");

        errors.pushNestedPath("person");
        ValidationUtils.invokeValidator(personValidator, student.getPerson(), errors);


    }
}
