package com.kma.ais_dekanat.controller;

import com.kma.ais_dekanat.model.Professor;
import com.kma.ais_dekanat.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by nira on 05.04.16.
 */
@RestController()
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    @RequestMapping(value = "/getAllProfessors", method = RequestMethod.GET)
    public List<Professor> getAllProfessors() {
        return professorService.getAllProfessors();
    }

    @RequestMapping(value = "/professors/cathedra/{id}", method = RequestMethod.GET)
    public @ResponseBody List<Professor> getProfessorsByCathedraId(@PathVariable("id") Integer id) {
        return professorService.getProfessorByCathedraId(id);
    }

}
