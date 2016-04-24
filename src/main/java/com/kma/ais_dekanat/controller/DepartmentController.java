package com.kma.ais_dekanat.controller;

import com.kma.ais_dekanat.model.Department;
import com.kma.ais_dekanat.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/departments/all", method = RequestMethod.GET)
    public @ResponseBody List<Department> getAllDeptartments () {
        return departmentService.getAllDepartments();
    }

    @RequestMapping(value = "/createDepartment", method = RequestMethod.POST)
    public String createDepartment(Model model, @ModelAttribute("newDepartment") Department newDepartment) {
        if (newDepartment.getName().length()<1 || newDepartment.getMainInfo().length()<1) {
            model.addAttribute("error","Fill all fields");
            return "/createDepartment";
        }
        departmentService.createDepartment(newDepartment);
        return "redirect:/departments";
    }

    @RequestMapping(value = "/createDepartment", method = RequestMethod.GET)
    public String getCreateDepartmentPage(Model model, HttpServletRequest request) {
        return "/createDepartment";
    }


    @RequestMapping(value = "/deleteDepartment/{id}", method = RequestMethod.GET)
    public String deleteDepartment(Model model, @PathVariable int id) {
        //TODO: add method delete by id
        departmentService.deleteDepartment(departmentService.getDepartmentById(id));
        return "redirect:/departments";
    }

    @RequestMapping(value = "/editDepartment/{id}", method = RequestMethod.GET)
    public String getEditDepartmentPage(Model model, @PathVariable int id) {
        Department department = departmentService.getDepartmentById(id);
        model.addAttribute("editDepartment", department);
        return "/editDepartment";
    }

    @RequestMapping(value = "/editDepartment/{id}", method = RequestMethod.POST)
    public String editDepartment(Model model, @PathVariable int id, @ModelAttribute("editDepartment") Department editDepartment) {
        if (editDepartment.getName().length()<1 || editDepartment.getMainInfo().length()<1) {
            model.addAttribute("error","Fill all fields");
            model.addAttribute("editDepartment", editDepartment);
            return "/editDepartment/"+id+"";
        }
        editDepartment.setDepartmentId(id);
        departmentService.updateDepartment(editDepartment);
        return "redirect:/departments";
    }

}
