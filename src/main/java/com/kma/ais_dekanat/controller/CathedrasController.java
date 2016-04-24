package com.kma.ais_dekanat.controller;

import com.kma.ais_dekanat.model.Cathedra;
import com.kma.ais_dekanat.model.Department;
import com.kma.ais_dekanat.service.CathedraService;
import com.kma.ais_dekanat.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    private CathedraService cathedraService;

    @RequestMapping(value = "/cathedras", method = RequestMethod.GET)
    public String getCathedras (Model model) {
        List<Cathedra> cathedras = cathedraService.getAllCathedras();

        model.addAttribute("cathedras", cathedras);
        return "/cathedras";
    }

    @RequestMapping(value = "/createCathedra", method = RequestMethod.POST)
    public String createCathedra(Model model, @ModelAttribute("newCathedra") Cathedra newCathedra) {
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
        model.addAttribute("editCathedra", cathedra);
        return "/editCathedra";
    }

    @RequestMapping(value = "/editCathedra/{id}", method = RequestMethod.POST)
    public String editCathedra(Model model, @PathVariable int id, @ModelAttribute("editCathedra") Cathedra editCathedra) {
        if (!cathedraService.validate(editCathedra)) {
            model.addAttribute("error","Fill all fields");
            return "/editCathedra/"+id+"";
        }
        cathedraService.saveOrUpdateCathedra(editCathedra);
        return "/cathedras";
    }
}
