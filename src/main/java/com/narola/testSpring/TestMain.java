package com.narola.testSpring;

import com.narola.testSpring.config.AppConfig;
import com.narola.testSpring.model.Student;
import com.narola.testSpring.validator.StudentValidator;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

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

        System.out.println("================================================================");

        BindingResult bindingResult = new BeanPropertyBindingResult(student1, "student");
        org.springframework.validation.Validator springValidator = context.getBean(StudentValidator.class);
        springValidator.validate(student1, bindingResult);


        Locale locale = new Locale("en");
        MessageSource messageSource = (MessageSource) context.getBean("messageSource");

        if (bindingResult.hasErrors()) {
            List<ObjectError> fieldErrorList = bindingResult.getAllErrors();
            for (ObjectError e : fieldErrorList) {

                System.out.println(messageSource.getMessage(e, locale));
            }
        }


        //System.out.println(messageSource.getMessage("student.course_null",new Object[]{},locale));
    }

}
