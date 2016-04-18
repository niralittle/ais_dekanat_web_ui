package com.kma.ais_dekanat.resource_controller;

import com.kma.ais_dekanat.model.UniversityGroup;
import com.kma.ais_dekanat.service.UniversityGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nira on 05.04.16.
 */
@RestController
public class UniversityGroupController {

    @Autowired
    UniversityGroupService universityGroupService;

    @RequestMapping(value = "/getAllGroups ", method = RequestMethod.GET)
    public List<UniversityGroup> getAllStudents() {
        return universityGroupService.getAllUniversityGroup();
    }


}
