package com.kma.ais_dekanat.utils;

import com.kma.ais_dekanat.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by nira on 23.04.16.
 */
@Component
public class StudentValidator  implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Student.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        Student student = (Student) o;
        if ((student.getFullName().equals(""))) {
            errors.rejectValue("fullName", "valid.order.fillAllTheForms");
        } else {
            if (student.getFullName().equals("")) {
                errors.rejectValue("fullName", "valid.order.title");
            } else if (student.getFullName().length() < 8) {
                errors.rejectValue("fullName", "valid.order.shortTitle");
            } else if (student.getFullName().length() > 40) {
                errors.rejectValue("fullName", "valid.order.tooLongTitle");
            }
        }

    }
}
