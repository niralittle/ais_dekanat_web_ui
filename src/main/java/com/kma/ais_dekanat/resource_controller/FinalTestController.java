package com.kma.ais_dekanat.resource_controller;

import com.kma.ais_dekanat.model.FinalTest;
import com.kma.ais_dekanat.service.FinalTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FinalTestController {
    @Autowired
    FinalTestService finalTestService;

    @RequestMapping(value = "/finaltest/course", method = RequestMethod.GET)
    List<FinalTest> getFinalTestByCourse(@RequestParam(value = "id") String id) {
        List<FinalTest> finalTests = finalTestService.getFinalTestByCourse(Integer.parseInt(id));
        if(finalTests!=null){
            return finalTests;
        }
        return null;

    }
}
