package com.kma.ais_dekanat.service;

import com.kma.ais_dekanat.dao.GenericDAO;
import com.kma.ais_dekanat.model.Department;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    GenericDAO genericDAO;

    @Transactional
    public List<Department> getAllDepartments() {
        Criteria crit = genericDAO.createCriteria(Department.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return crit.list();
    }

    @Transactional
    public void createDepartment(Department department) {
        genericDAO.save(department);
    }


    @Transactional
    public void deleteDepartment(Department department) {
        genericDAO.delete(department);
    }

    @Transactional
    public Department getDepartmentById(Integer id) {
        return genericDAO.get(Department.class, id);
    }

    @Transactional
    public void saveOrUpdateCathedra(Department department) {
        genericDAO.saveOrUpdate(department);
    }
}
