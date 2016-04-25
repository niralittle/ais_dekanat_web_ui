package com.kma.ais_dekanat.service;

import com.kma.ais_dekanat.dao.GenericDAO;
import com.kma.ais_dekanat.model.FinalTest;
import org.hibernate.Criteria;
import org.hibernate.criterion.*;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExamService {
    @Autowired
    GenericDAO dao;

    public List<FinalTest> getExamsByGroupId(Integer id) {
        Criteria crit = dao.createCriteria(FinalTest.class)
                .add(Restrictions.eq("group.groupId", id))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return crit.list();
    }

    public List<FinalTest> getExamsByProfessorId(Integer id){
        Criteria crit = dao.createCriteria(FinalTest.class)
                .createCriteria("subject", "subj", JoinType.INNER_JOIN)
                .add(Restrictions.eq("subj.professor.professorId", id))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return crit.list();
    }

}
