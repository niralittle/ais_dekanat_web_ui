package com.kma.ais_dekanat.controller;

import com.kma.ais_dekanat.model.UniversityGroup;
import com.kma.ais_dekanat.service.UniversityGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by nira on 24.04.16.
 */

@Controller
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    UniversityGroupService universityGroupService;

    @RequestMapping(value = {"/department/{deptId}/year/{yearId}"}, method = RequestMethod.GET)
    public @ResponseBody List<UniversityGroup> getGroupsByDeptAndYear(@PathVariable("deptId") Integer deptId,
                                                                      @PathVariable("yearId") Integer yearId) {
        return universityGroupService.getGroupByDeptIdAndYear(deptId, yearId);
    }


}
