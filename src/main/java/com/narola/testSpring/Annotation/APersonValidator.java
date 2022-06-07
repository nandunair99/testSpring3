package com.narola.testSpring.Annotation;

import com.narola.testSpring.model.Person;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class APersonValidator implements ConstraintValidator<IsPersonValid, Person> {
    @Override
    public void initialize(IsPersonValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Person person, ConstraintValidatorContext constraintValidatorContext) {
        if(person.getAge()<24 || person.getAge()>100)
        {
            return false;
        }
        else
        {
            if(person.getName()==null)
            {
                return false;
            }
            else
                return true;
        }
    }
}
