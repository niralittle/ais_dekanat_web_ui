package com.kma.ais_dekanat.resource_controller;

import com.kma.ais_dekanat.model.Student;
import com.kma.ais_dekanat.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nira on 05.04.16.
 */
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/getAllStudents", method = RequestMethod.GET)
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

}
