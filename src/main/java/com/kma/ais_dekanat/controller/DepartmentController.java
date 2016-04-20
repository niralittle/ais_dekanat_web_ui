package com.kma.ais_dekanat.controller;

import com.kma.ais_dekanat.model.Department;
import com.kma.ais_dekanat.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 19.04.2016 1:23.
 */
@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    public String getDepartment (Model model) {
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("departments", departments);
        return "/departments";
    }

    @RequestMapping(value = "/createDepartment", method = RequestMethod.POST)
    public String createDepartment(Model model, HttpServletRequest request) {
        Department department = new Department();
        department.setName(request.getParameter("name"));
        department.setMainInfo(request.getParameter("mainInfo"));

        departmentService.createDepartment(department);
        return "redirect:/departments";
    }

    @RequestMapping(value = "/deleteDepartment/{id}", method = RequestMethod.GET)
    public String deleteDepartment(Model model, @PathVariable int id) {
        //TODO: add method delete by id
        departmentService.deleteDepartment(departmentService.getDepartmentById(id));
        return "redirect:/departments";
    }

    @RequestMapping(value = "/editDepartment/{id}", method = RequestMethod.GET)
    public String editDepartment(Model model, @PathVariable int id) {
        Department department = departmentService.getDepartmentById(id);
        model.addAttribute("editDepartment", department);
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("departments", departments);
        return "/departments";
    }

}
