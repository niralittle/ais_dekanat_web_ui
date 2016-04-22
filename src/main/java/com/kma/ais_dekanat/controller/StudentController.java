package com.kma.ais_dekanat.controller;

import com.kma.ais_dekanat.model.Student;
import com.kma.ais_dekanat.model.UniversityGroup;
import com.kma.ais_dekanat.service.StudentService;
import com.kma.ais_dekanat.service.UniversityGroupService;
import com.kma.ais_dekanat.utils.StudentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    UniversityGroupService universityGroupService;
    @Autowired
    StudentValidator validator;

    @RequestMapping(value = "/student/allStudents", method = RequestMethod.GET)
    @ResponseBody
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/student/groups", method = RequestMethod.GET)
    @ResponseBody
    public List<UniversityGroup> UniversityGroupbyGroup(@RequestParam("id") Integer id) {
        List<UniversityGroup> universityGroups = universityGroupService.getUniversityGroupByCourse(id);
        return universityGroups;
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

    @RequestMapping(value = "/student/create", method = RequestMethod.GET)
    public String createStudent(ModelMap model) {
        Student student = new Student();
        List<UniversityGroup> universityGroups = universityGroupService.getAllUniversityGroup();
        model.addAttribute("newStudent", student);
        model.addAttribute("universityGroups", universityGroups);
        return "studentPage/createStudent";
    }

    @RequestMapping(value = "/student/create", method = RequestMethod.POST)
    public String createStudentPost(@RequestParam("courseNumber") Integer course, @RequestParam("department") String department, @ModelAttribute("newOrder") Student student, ModelMap model, BindingResult result) {
        validator.validate(student, result);
        if (result.hasErrors()) {
            List<UniversityGroup> universityGroups = universityGroupService.getAllUniversityGroup();
            model.addAttribute("newStudent", student);
            model.addAttribute("universityGroups", universityGroups);
            return "studentPage/createStudent";
        }
        UniversityGroup group = universityGroupService.getGroupByDepAndCourse(course, department);
        student.setGroup(group);
        studentService.saveOrUpdateStudent(student);

        return "redirect:/student/home";
    }


}
