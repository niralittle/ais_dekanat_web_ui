package com.kma.ais_dekanat.service;

import com.kma.ais_dekanat.dao.GenericDAO;
import com.kma.ais_dekanat.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    GenericDAO genericDAO;

//    @Transactional
//    public User getByLogin(String login) {//TODO nira
//        Criteria crit = genericDAO.createCriteria(User.class).add(Restrictions.eq("login", login));
//        List<User> users = crit.list();
//        return users.get(0);
//    }
}
