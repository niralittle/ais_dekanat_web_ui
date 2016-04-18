package com.kma.ais_dekanat.service;

import com.kma.ais_dekanat.dao.GenericDAO;
import com.kma.ais_dekanat.dao.GenericDAOHibernateImpl;
import com.kma.ais_dekanat.model.FinalTest;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by denysburlakov on 05.04.16.
 */
@Service
public class ExamService {
    @Autowired
    GenericDAO genericDAO;

    @Transactional
    public List<FinalTest> getAllExams() {
        Criteria crit = genericDAO.createCriteria(FinalTest.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return crit.list();
    }

//    public List<FinalTest> getExamsByProfessorId(String id) {
//        return ((GenericDAOHibernateImpl) genericDAO).executeQuery("SELECT * from final_test where subject_subject_id " +
//                "in (SELECT subject_subject_id from syllabus where professor_professor_id = "
//                + id +");");
//    }

}
