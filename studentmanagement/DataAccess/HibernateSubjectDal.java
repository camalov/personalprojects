package com.project.studentmanagement.DataAccess;

import com.project.studentmanagement.Entities.Subject;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class HibernateSubjectDal implements ISubjectDal {

    private EntityManager entityManager;

    @Autowired
    public HibernateSubjectDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Subject> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<Subject> subjects = session.createQuery("from Subject", Subject.class).getResultList();
        return subjects;
    }

    @Override
    @Transactional
    public Subject getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Subject subject = session.get(Subject.class, id);
        return subject;
    }

    @Override
    @Transactional
    public void add(Subject subject) {
        Session session = entityManager.unwrap(Session.class);
        session.save(subject);
    }

    @Override
    @Transactional
    public void update(Subject subject) {
        Session session = entityManager.unwrap(Session.class);
        session.update(subject);
    }

    @Override
    @Transactional
    public void delete(Subject subject) {
        Session session = entityManager.unwrap(Session.class);
        Subject subjectToDelete = session.get(Subject.class, subject.getId());
        session.delete(subjectToDelete);
    }


}
