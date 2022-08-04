package com.project.studentmanagement.DataAccess;

import com.project.studentmanagement.Entities.Student;
import com.project.studentmanagement.Util.SessionDalUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class HibernateStudentDal implements IStudentDal {
    EntityManager entityManager;

    @Autowired
    public HibernateStudentDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Student> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<Student> students = session.createQuery("from Student", Student.class).getResultList();
        SessionDalUtil.clearSession(session);
        return students;
    }

    @Override
    @Transactional
    public Student getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Student student = session.get(Student.class, id);
        SessionDalUtil.clearSession(session);
        return student;
    }

    @Override
    @Transactional
    public void add(Student student) {
        Session session = entityManager.unwrap(Session.class);
        session.save(student);
    }

    @Override
    @Transactional
    public void update(Student student) {
        Session session = entityManager.unwrap(Session.class);
        session.update(student);
    }

    @Override
    @Transactional
    public void delete(Student student) {

    }
}
