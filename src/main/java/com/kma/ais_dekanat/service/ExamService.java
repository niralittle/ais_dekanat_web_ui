package com.kma.ais_dekanat.service;

import com.kma.ais_dekanat.dao.GenericDAO;
import com.kma.ais_dekanat.model.FinalTest;
import com.kma.ais_dekanat.model.Professor;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExamService {
    @Autowired
    GenericDAO dao;

//    public List<FinalTest> getAllExams() {
//        Criteria crit = dao.createCriteria(FinalTest.class)
//                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
//        return crit.list();
//    }

    public List<FinalTest> getExamsByGroupId(Integer id) {
        Criteria crit = dao.createCriteria(FinalTest.class).add(Restrictions.eq("group.groupId", id))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return crit.list();
    }

//    public List<FinalTest> getExamsByProfessorId(String id) {
//
////        return dao.createCriteria(FinalTest.class).add(Restrictions.in("subject_subject_id",
////                dao.createCriteria(Professor.class).add(Restrictions.eq("professor_professor_id", id)).list()))
////                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
//
//        return dao.executeQuery("SELECT * from final_test where subject_subject_id " +
//                "in (SELECT subject_subject_id from syllabus where professor_professor_id = "
//                + id +" );");
//    }

}
