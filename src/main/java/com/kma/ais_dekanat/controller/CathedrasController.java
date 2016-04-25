package com.kma.ais_dekanat.controller;

import com.kma.ais_dekanat.model.Cathedra;
import com.kma.ais_dekanat.model.Department;
import com.kma.ais_dekanat.service.CathedraService;
import com.kma.ais_dekanat.service.DepartmentService;
import com.kma.ais_dekanat.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 24.04.2016 19:17.
 */

@Controller
public class CathedrasController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    CathedraService cathedraService;
    @Autowired
    ProfessorService professorService;

    @RequestMapping(value = "/cathedras/department/{id}", method = RequestMethod.GET)
    public @ResponseBody List<Cathedra> getCathedrasByDepartmentId(@PathVariable(value = "id") Integer id) {
        return cathedraService.getCathedrasByDepartmentId(id);
    }

    @RequestMapping(value = "/cathedras", method = RequestMethod.GET)
    public String getCathedras (Model model) {
        List<Cathedra> cathedras = cathedraService.getAllCathedras();
        model.addAttribute("cathedras", cathedras);
        return "/cathedras";
    }

    @RequestMapping(value = "/createCathedra", method = RequestMethod.POST)
    public String createCathedra(Model model, @ModelAttribute("newCathedra") Cathedra newCathedra,
                                 @ModelAttribute("departmentId") Department department) {
        newCathedra.setDepartment(departmentService.getDepartmentById(department.getDepartmentId()));
        if (!cathedraService.validate(newCathedra)) {
            model.addAttribute("error","Fill all fields");
            return "/createCathedra";
        }
        cathedraService.createCathedra(newCathedra);
        return "redirect:/cathedras";
    }

    @RequestMapping(value = "/createCathedra", method = RequestMethod.GET)
    public String getCreateCathedraPage(Model model, HttpServletRequest request) {
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("departments", departments);
        return "/createCathedra";
    }


    @RequestMapping(value = "/deleteCathedra/{id}", method = RequestMethod.GET)
    public String deleteCathedra(Model model, @PathVariable int id) {
        //TODO: add method delete by id
        cathedraService.deleteCathedra(cathedraService.getCathedraById(id));
        return "redirect:/cathedras";
    }

    @RequestMapping(value = "/editCathedra/{id}", method = RequestMethod.GET)
    public String getEditCathedraPage(Model model, @PathVariable int id) {
        Cathedra cathedra = cathedraService.getCathedraById(id);
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("departments", departments);
        model.addAttribute("editCathedra", cathedra);
        return "/editCathedra";
    }

    @RequestMapping(value = "/editCathedra/{id}", method = RequestMethod.POST)
    public String editCathedra(Model model, @PathVariable int id,
                               @ModelAttribute("editCathedra") Cathedra editCathedra,
                               @ModelAttribute("departmentId") Department department) {
        if (!cathedraService.validate(editCathedra)) {
            model.addAttribute("error","Fill all fields");
            return "/editCathedra/"+id+"";
        }
        editCathedra.setCathedraId(id);
        editCathedra.setDepartment(departmentService.getDepartmentById(department.getDepartmentId()));
        cathedraService.saveOrUpdateCathedra(editCathedra);
        return "redirect:/cathedras";
    }
}
