package com.kma.ais_dekanat.controller;

import com.kma.ais_dekanat.model.FinalTest;
import com.kma.ais_dekanat.service.DepartmentService;
import com.kma.ais_dekanat.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;


/**
 * Created by nira on 24.04.16.
 */
@Controller
@RequestMapping("/exams")
public class ExamController {

    @Autowired
    ExamService examService;

    @Autowired
    DepartmentService departmentService;


//    @RequestMapping(value = {"/group/{id}"}, method = RequestMethod.POST)
//    public String getExamsByGroupId(Model model) {
//        Integer id = (Integer) model.asMap().get("groupId");
//        model.addAttribute("exams", examService.getExamsByGroupId(id));
//        return "/exams.jsp";
//    }

    @RequestMapping(value = {"/group/{id}"}, method = RequestMethod.GET)
    public String getExamsByGroupId(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("exams", examService.getExamsByGroupId(id));
        return "redirect:exams.jsp";
    }


//    @RequestMapping()
//    public String getExams(Model model) {
//        if (model.containsAttribute("exams")) return "/exams";
//        else return "redirect:error";
//    }



    /*
    *
        @RequestMapping(method=RequestMethod.POST)
        @ResponseStatus(HttpStatus.CREATED)
        public @ResponseBody Spittle createSpittle(@Valid Spittle spittle, BindingResult result, HttpServletResponse response) throws BindException {
            if(result.hasErrors()) {
            throw new BindException(result);
            }
            spitterService.saveSpittle(spittle);
            response.setHeader("Location", "/spittles/" + spittle.getId());
            return spittle;
        }
    * */

}
