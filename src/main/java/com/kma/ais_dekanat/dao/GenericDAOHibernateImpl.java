package com.kma.ais_dekanat.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenericDAOHibernateImpl implements GenericDAO {
    @Autowired
    protected SessionFactory sessionFactory;

    public <T> T save(final T o) {
        return (T) sessionFactory.getCurrentSession().save(o);
    }


    public void delete(final Object object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    public <T> T get(final Class<T> type, final Integer id) {
        return (T) sessionFactory.getCurrentSession().get(type, id);
    }

    public <T> T merge(final T o) {
        return (T) sessionFactory.getCurrentSession().merge(o);
    }

    public <T> void saveOrUpdate(final T o) {
        sessionFactory.getCurrentSession().saveOrUpdate(o);
    }

    public <T> List<T> getAll(final Class<T> type) {
        final Session session = sessionFactory.getCurrentSession();
        final Criteria crit = session.createCriteria(type);
        return crit.list();
    }

    public final <T> List<T> findByCriterions(final Class<T> type, final Criterion... criterion) {
        final Criteria crit = sessionFactory.getCurrentSession().createCriteria(type);
        for (final Criterion c : criterion) {
            crit.add(c);
        }
        return crit.list();
    }

    @Override
    public <T> Criteria createCriteria(final Class<T> type) {
        return sessionFactory.getCurrentSession().createCriteria(type);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}