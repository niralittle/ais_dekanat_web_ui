package com.kma.ais_dekanat.controller;

import com.kma.ais_dekanat.model.Cathedra;
import com.kma.ais_dekanat.model.Professor;
import com.kma.ais_dekanat.service.CathedraService;
import com.kma.ais_dekanat.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 25.04.2016 1:48.
 */
@Controller
public class ProfessorsController {

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private CathedraService cathedraService;

    @RequestMapping(value = "/professors", method = RequestMethod.GET)
    public String getProfessor (Model model) {
        List<Professor> professors = professorService.getAllProfessors();
        model.addAttribute("professors", professors);
        return "/professors";
    }


    @RequestMapping(value = "/createProfessor", method = RequestMethod.POST)
    public String createProfessor(Model model, @ModelAttribute("newProfessor") Professor newProfessor,
                                  @ModelAttribute("cathedraId") Cathedra cathedra) {

        if (newProfessor.getFullName().length()>1
                && newProfessor.getAcademicDegree().length()>1
                && cathedra!=null) {
            newProfessor.setCathedra(cathedraService.getCathedraById(cathedra.getCathedraId()));
            professorService.createProfessor(newProfessor);
            return "redirect:/professors";
        }
        List<Professor> professors = professorService.getAllProfessors();
        model.addAttribute("professors", professors);
        model.addAttribute("error", "Fill all fields");
        return "/professors";

    }

    @RequestMapping(value = "/createProfessor", method = RequestMethod.GET)
    public String getCreateCathedraPage(Model model, HttpServletRequest request) {
        List<Cathedra> cathedras = cathedraService.getAllCathedras();
        model.addAttribute("cathedras", cathedras);
        return "/createProfessor";
    }


    @RequestMapping(value = "/deleteProfessor/{id}", method = RequestMethod.GET)
    public String deleteCathedra(Model model, @PathVariable int id) {
        //TODO: add method delete by id
        professorService.deleteProfessor(professorService.getProfessorById(id));
        return "redirect:/professors";
    }

    @RequestMapping(value = "/editProfessor/{id}", method = RequestMethod.GET)
    public String getEditCathedraPage(Model model, @PathVariable int id) {
        Professor professor = professorService.getProfessorById(id);
        List<Cathedra> cathedras = cathedraService.getAllCathedras();
        model.addAttribute("cathedras", cathedras);
        model.addAttribute("editProfessor", professor);
        return "/editProfessor";
    }

    @RequestMapping(value = "/editProfessor/{id}", method = RequestMethod.POST)
    public String editCathedra(Model model, @PathVariable int id,
                               @ModelAttribute("editProfessor") Professor editProfessor,
                               @ModelAttribute("cathedraId") Cathedra cathedra) {
        if (!(editProfessor.getFullName().length()>1
                && editProfessor.getAcademicDegree().length()>1
                && cathedra!=null)) {
            editProfessor.setCathedra(cathedraService.getCathedraById(cathedra.getCathedraId()));
            professorService.createProfessor(editProfessor);
            return "/editProfessor/"+id+"";
        }
        editProfessor.setProfessorId(id);
        editProfessor.setCathedra(cathedraService.getCathedraById(cathedra.getCathedraId()));
        professorService.saveOrUpdateProfessor(editProfessor);
        return "redirect:/professors";
    }

}
