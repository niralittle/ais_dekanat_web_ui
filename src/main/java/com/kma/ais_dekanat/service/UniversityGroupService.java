package com.kma.ais_dekanat.service;

import com.kma.ais_dekanat.dao.GenericDAO;
import com.kma.ais_dekanat.model.UniversityGroup;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UniversityGroupService {
    @Autowired
    GenericDAO genericDAO;

    @Transactional
    public List<UniversityGroup> getAllUniversityGroup() {
        Criteria crit = genericDAO.createCriteria(UniversityGroup.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return crit.list();
    }

    @Transactional
    public void createUniversityGroup(UniversityGroup universityGroup) {
        genericDAO.save(universityGroup);
    }


    @Transactional
    public void deleteUniversityGroup(UniversityGroup universityGroup) {
        genericDAO.delete(universityGroup);
    }

    @Transactional
    public UniversityGroup getUniversityGroupById(Integer id) {
        return genericDAO.get(UniversityGroup.class, id);
    }
    @Transactional
    public UniversityGroup getGroupByDepAndCourse(Integer course, String name) {
        Criteria crit = genericDAO.createCriteria(UniversityGroup.class).add(Restrictions.eq("course", course))
                .add(Restrictions.eq("name", name));
        List<UniversityGroup> universityGroups = crit.list();
       return universityGroups.get(0);
    }

    @Transactional
    public List<UniversityGroup> getGroupByDeptIdAndYear(Integer deptId, Integer course) {
        Criteria crit = genericDAO.createCriteria(UniversityGroup.class)
                .add(Restrictions.eq("department.departmentId", deptId))
                .add(Restrictions.eq("course", course));
        return crit.list();
    }

    @Transactional
    public List<UniversityGroup>  getUniversityGroupByCourse(Integer id) {
        Criteria crit = genericDAO.createCriteria(UniversityGroup.class).add(Restrictions.eq("course", id));
        List<UniversityGroup> universityGroups = crit.list();
        return universityGroups;
    }

    @Transactional
    public List<UniversityGroup> getUniversityGroupDepartmentId(Integer id) {
        Criteria crit = genericDAO.createCriteria(UniversityGroup.class).add(Restrictions.eq("department.departmentId", id));
        List<UniversityGroup> universityGroups = crit.list();
        return universityGroups;
    }

    @Transactional
    public void saveOrUpdateCathedra(UniversityGroup universityGroup) {
        genericDAO.saveOrUpdate(universityGroup
        );
    }

}
