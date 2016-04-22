package com.kma.ais_dekanat.service;

import com.kma.ais_dekanat.dao.GenericDAO;
import com.kma.ais_dekanat.model.Student;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nira on 05.04.16.
 */
@Service
public class StudentService {
    @Autowired
    GenericDAO genericDAO;

    @Transactional
    public List<Student> getAllStudents() {
        Criteria crit = genericDAO.createCriteria(Student.class);
        return crit.list();
    }
    @Transactional
    public void createStudent(Student student) {
        genericDAO.save(student);
    }


    @Transactional
    public void deleteStudent(Student student) {
        genericDAO.delete(student);
    }

    @Transactional
    public Student getStudentById(Integer id) {
        return genericDAO.get(Student.class, id);
    }

    @Transactional
    public void saveOrUpdateStudent(Student student) {
        genericDAO.saveOrUpdate(student);
    }
}
