package com.kma.ais_dekanat.controller;

import com.kma.ais_dekanat.model.Student;
import com.kma.ais_dekanat.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "student/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}
