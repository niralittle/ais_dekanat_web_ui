package com.kma.ais_dekanat.service;

import com.kma.ais_dekanat.dao.GenericDAO;
import com.kma.ais_dekanat.model.Cathedra;
import com.kma.ais_dekanat.model.Professor;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
public class CathedraService {
    @Autowired
    GenericDAO genericDAO;

    @Transactional
    public List<Cathedra> getAllCathedras() {
        Criteria crit = genericDAO.createCriteria(Cathedra.class);
                //.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Cathedra> cathedras = new ArrayList<Cathedra>();
        crit.list();
        for (int i = 0; i<crit.list().size(); i++) {
            Cathedra cathedra = new Cathedra();
            cathedra.setCathedraId(((Cathedra)crit.list().get(i)).getCathedraId());
            cathedra.setName(((Cathedra)crit.list().get(i)).getName());
            cathedra.setDepartment(((Cathedra)crit.list().get(i)).getDepartment());
            Set<Professor> newProf = new TreeSet<Professor>();
            Set<Professor> professors = (Set<Professor>) ((Cathedra)crit.list().get(i)).getProfessors();
            for (Professor p: professors) {
                Professor professor = new Professor();
                professor.setProfessorId(p.getProfessorId());
                professor.setFullName(p.getFullName());
                professor.setAcademicDegree(p.getAcademicDegree());
                professor.setCathedra(p.getCathedra());
                newProf.add(professor);
            }
            cathedra.setProfessors(newProf);
            cathedras.add(cathedra);
        }
        return cathedras;
    }

    @Transactional
    public void createCathedra(Cathedra cathedra) {
        genericDAO.save(cathedra);
    }


    @Transactional
    public void deleteCathedra(Cathedra cathedra) {
        genericDAO.delete(cathedra);
    }

    @Transactional
    public Cathedra getCathedraById(Integer id) {
        return genericDAO.get(Cathedra.class, id);
    }

    @Transactional
    public void saveOrUpdateCathedra(Cathedra cathedra) {
        genericDAO.saveOrUpdate(cathedra);
    }

    @Transactional
    public List<Cathedra> getCathedrasByDepartmentId(int id) {
        Criteria crit = genericDAO.createCriteria(Cathedra.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .add(Restrictions.eq("department.departmentId", id));
        return crit.list();
    }

    public boolean validate(Cathedra newCathedra) {
        //TODO
        return true;
    }
}
