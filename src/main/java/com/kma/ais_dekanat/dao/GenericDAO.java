package com.kma.ais_dekanat.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;

import java.util.List;

public interface GenericDAO {
    <T> T save(T o);

    void delete(Object object);

    <T> T get(Class<T> type, Integer id);

    <T> T merge(T o);

    <T> void saveOrUpdate(T o);

    <T> List<T> getAll(Class<T> type);

    <T> List<T> findByCriterions(Class<T> type, Criterion... criterion);

    <T> Criteria createCriteria(final Class<T> type);

}