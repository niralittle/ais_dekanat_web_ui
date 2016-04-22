package com.kma.ais_dekanat.controller;

import com.kma.ais_dekanat.model.Student;
import com.kma.ais_dekanat.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/student/allStudents", method = RequestMethod.GET)
    @ResponseBody
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/student/home", method = RequestMethod.GET)
    public String listUserOrders(ModelMap model) {
        return "studentPage/studentHomePage";
    }


    @RequestMapping(value = "/student/delete/{id}", method = RequestMethod.GET)
    public String deleteUserById(@PathVariable("id") int id) {
        Student student = studentService.getStudentById(id);
        studentService.deleteStudent(student);
        return "redirect:/student/home";
    }

}