package com.kma.ais_dekanat.controller;

import com.kma.ais_dekanat.model.FinalTest;
import com.kma.ais_dekanat.service.DepartmentService;
import com.kma.ais_dekanat.service.ExamService;
import com.kma.ais_dekanat.utils.ExamScheduleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


/**
 * Created by nira on 24.04.16.
 */
@Controller
@RequestMapping("/exams")
public class ExamController {

    public static final String EXAMS = "exams";
    public static final String GOTO_EXAMS = "/exams";

    @Autowired
    ExamService examService;

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/group", method = RequestMethod.GET)
    public String gotoExamsByGroupForm(Model model) {
        return "/examsByGroup";
    }

    @RequestMapping(value = "/professor", method = RequestMethod.GET)
    public String gotoExamsByProfessorForm(Model model) {
        return "/examsByProfessor";
    }

    @RequestMapping(value = {"/professor/{id}"}, method = RequestMethod.GET)
    public String getExamsByProfessorId(@PathVariable("id") Integer id, HttpServletRequest request) {
        Map<Integer, List<FinalTest>[]> schedule = prepareForDisplay(examService.getExamsByProfessorId(id));
        request.getSession().setAttribute(EXAMS, schedule);
        return GOTO_EXAMS;
    }

    @RequestMapping(value = {"/group/{id}"}, method = RequestMethod.GET)
    public String getExamsByGroupId(@PathVariable("id") Integer id, HttpServletRequest request) {
        Map<Integer, List<FinalTest>[]> schedule = prepareForDisplay(examService.getExamsByGroupId(id));
        request.getSession().setAttribute(EXAMS, schedule);
        return GOTO_EXAMS;
    }

    private Map<Integer, List<FinalTest>[]> prepareForDisplay(List<FinalTest> examsByGroupId) {
        return ExamScheduleUtil.prepare(examsByGroupId);
    }

}
