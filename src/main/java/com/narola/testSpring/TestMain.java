package com.narola.testSpring;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.validation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class TestMain {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("production");
        context.register(AppConfig.class);
        context.refresh();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Student student1 = (Student) context.getBean("studentBean");
        Set<ConstraintViolation<Student>> violations = validator.validate(student1);
        for (ConstraintViolation<Student> violation : violations) {
            System.out.println("in:" + violation.getMessage());
        }
        System.out.println(student1);


        DataBinder dataBinder = new DataBinder(student1.getPerson());
        dataBinder.addValidators(new PersonValidator());
        dataBinder.validate();
        List<ObjectError> errors = dataBinder.getBindingResult().getAllErrors();

        for (ObjectError err : errors
        ) {
            System.err.println(err.getCode());
        }


        BindingResult bindingResult = new BeanPropertyBindingResult(student1, "student");
        org.springframework.validation.Validator springValidator = context.getBean(StudentValidator.class);
        springValidator.validate(student1, bindingResult);


        Locale locale= new Locale("en");
        MessageSource messageSource= (MessageSource) context.getBean("messageSource");

        if (bindingResult.hasErrors()) {
            List<ObjectError> fieldErrorList = bindingResult.getAllErrors();
            for (ObjectError e : fieldErrorList) {

                System.out.println(messageSource.getMessage(e,locale));
            }
        }


        //System.out.println(messageSource.getMessage("student.course_null",new Object[]{},locale));
    }

}
