//package com.kma.ais_dekanat.service;
//
//import com.kma.ais_dekanat.dao.GenericDAO;
//import com.kma.ais_dekanat.model.FinalTest;
//import org.hibernate.Criteria;
//import org.hibernate.criterion.Restrictions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//public class FinalTestService {
//    @Autowired
//    GenericDAO genericDAO;
//
//    @Transactional
//    public List<FinalTest> getAllFinalTest() {
//        return genericDAO.getAll(FinalTest.class);
//    }
//
//    @Transactional
//    public void createFinalTest(FinalTest finalTest) {
//        genericDAO.save(finalTest);
//    }
//
//    @Transactional
//    public void deleteFinalTest(FinalTest finalTest) {
//        genericDAO.delete(finalTest);
//    }
//
//    @Transactional
//    public void saveOrUpdateFinalTest(FinalTest finalTest) {
//        genericDAO.saveOrUpdate(finalTest);
//    }
//
//    @Transactional
//    public FinalTest getFinalTestById(Integer id) {
//        return genericDAO.get(FinalTest.class, id);
//    }
//
//    @Transactional
//    public List<FinalTest> getFinalTestByCourse(Integer id){
//        Criteria crit = genericDAO.createCriteria(FinalTest.class)
//                .createAlias("group", "g")
//                .add(Restrictions.eq("g.course", id));
//        List<FinalTest> finalTests = crit.list();
//        return  finalTests;
//    }
//
//    @Transactional
//    public List<FinalTest> getFinalTestByProfesorId(Integer id){
//        Criteria crit = genericDAO.createCriteria(FinalTest.class)
//                .createAlias("subject", "subj")
//                .createAlias("subj.syllabuses", "sylab")
//                .createAlias("sylab.professor", "proff")
//                .add(Restrictions.eq("proff.professorId", id));
//        List<FinalTest> finalTests = crit.list();
//        return  finalTests;
//    }
//
//}
