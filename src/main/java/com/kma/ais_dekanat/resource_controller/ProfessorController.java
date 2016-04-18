package com.kma.ais_dekanat.resource_controller;

import com.kma.ais_dekanat.model.Professor;
import com.kma.ais_dekanat.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nira on 05.04.16.
 */
@RestController
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    @RequestMapping(value = "/getAllProfessors", method = RequestMethod.GET)
    public List<Professor> getAllProfessors() {
        return professorService.getAllProfessors();
    }

}
