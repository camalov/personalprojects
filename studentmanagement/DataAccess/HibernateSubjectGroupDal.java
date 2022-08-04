package com.project.studentmanagement.DataAccess;

import com.project.studentmanagement.Entities.SubjectGroup;
import com.project.studentmanagement.Util.SessionDalUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class HibernateSubjectGroupDal implements ISubjectGroupDal {

    private EntityManager entityManager;

    @Autowired
    public HibernateSubjectGroupDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<SubjectGroup> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<SubjectGroup> subjectGroups = session.createQuery("from SubjectGroup", SubjectGroup.class).getResultList();
        return subjectGroups;
    }

    @Override
    @Transactional
    public SubjectGroup getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        SubjectGroup subjectGroup = session.get(SubjectGroup.class, id);
        return subjectGroup;
    }

    @Override
    @Transactional
    public void add(SubjectGroup subjectGroup) {
        Session session = entityManager.unwrap(Session.class);
        session.save(subjectGroup);
    }

    @Override
    @Transactional
    public void update(SubjectGroup subjectGroup) {
        Session session = entityManager.unwrap(Session.class);
        session = SessionDalUtil.clearSession(session);
        session.update(subjectGroup);
    }

    @Override
    @Transactional
    public void delete(SubjectGroup subjectGroup) {
        Session session = entityManager.unwrap(Session.class);
        SubjectGroup subjectGroupToDelete = session.get(SubjectGroup.class, subjectGroup.getId());
        session.delete(subjectGroupToDelete);
    }
}
