package com.kma.ais_dekanat.resource_controller;


import com.kma.ais_dekanat.model.FinalTest;
import com.kma.ais_dekanat.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by denysburlakov on 05.04.16.
 */
@RestController
public class ExamController {
    @Autowired
    private ExamService examService;

    @RequestMapping(value = "/getAllExams", method = RequestMethod.GET)
    public List<FinalTest> getAllExams() {
        return examService.getAllExams();
    }

//    @RequestMapping(value = "/getExamsByProfessorId", method = RequestMethod.GET)
//    public List<FinalTest> getExamsByProfessorId() {
//        return examService.getExamsByProfessorId();
//    }
//
}
