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
        Criteria crit = genericDAO.createCriteria(Student.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).setMaxResults(20);
        return crit.list();
    }
}
