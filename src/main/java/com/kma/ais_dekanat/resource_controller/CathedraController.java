package com.kma.ais_dekanat.resource_controller;

import com.kma.ais_dekanat.model.Cathedra;
import com.kma.ais_dekanat.model.Department;
import com.kma.ais_dekanat.model.Professor;
import com.kma.ais_dekanat.service.CathedraService;
import com.kma.ais_dekanat.service.DepartmentService;
import com.kma.ais_dekanat.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CathedraController {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    CathedraService cathedraService;
    @Autowired
    ProfessorService professorService;

    @RequestMapping(value = "/getCathedrasByDepartment", method = RequestMethod.GET)
    public List<Cathedra> getCathedraSByDepartmentId(@RequestParam(value = "id") String id) {
        return cathedraService.getCathedrasByDepartmentId(Integer.parseInt(id));
    }

    @RequestMapping(value = "/cathedra/professor", method = RequestMethod.GET)
    public Professor getProfessorById(@RequestParam(value = "id") String id){
        System.out.println(id);
      Professor professor=professorService.getProfessorById(Integer.parseInt(id));
       if(professor!=null){
           return professor;
       }
        return null;
    }

    @RequestMapping(value = "/getAllDepartments", method = RequestMethod.GET)
    public List<Department> getAllDepartment() {
        return departmentService.getAllDepartments();
    }

  /*  @RequestMapping(value = "/cathedra/remove/{id}",method = RequestMethod.POST)
    public @ResponseBody void deleteDepartment(@PathVariable String id) {
        System.out.println(id);
       // Department department = departmentService.getDepartmentById(Long.parseLong(id));
      //  departmentService.deleteDepartment(department);
    }*/
}
