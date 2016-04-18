package com.kma.ais_dekanat.service;

import com.kma.ais_dekanat.dao.GenericDAO;
import com.kma.ais_dekanat.model.Syllabus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SyllabusService {
    @Autowired
    GenericDAO genericDAO;

    @Transactional
    public List<Syllabus> getAllSyllabus() {
        return genericDAO.getAll(Syllabus.class);
    }

    @Transactional
    public void createSyllabus(Syllabus syllabus) {
        genericDAO.save(syllabus);
    }

    @Transactional
    public void deleteSyllabus(Syllabus syllabus) {
        genericDAO.delete(syllabus);
    }

    @Transactional
    public Syllabus getSyllabusById(Integer id) {
        return genericDAO.get(Syllabus.class, id);
    }

    @Transactional
    public void saveOrUpdateSyllabus(Syllabus syllabus) {
        genericDAO.saveOrUpdate(syllabus);
    }
}
