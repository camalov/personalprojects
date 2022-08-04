package com.project.studentmanagement.Business;

import com.project.studentmanagement.DataAccess.ISubjectDal;
import com.project.studentmanagement.Entities.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubjectServiceManager implements ISubjectService {

    private ISubjectDal iSubjectDal;

    @Autowired
    public SubjectServiceManager(ISubjectDal iSubjectDal) {
        this.iSubjectDal = iSubjectDal;
    }

    @Override
    @Transactional
    public List<Subject> getAll() {
        return iSubjectDal.getAll();
    }

    @Override
    @Transactional
    public Subject getById(int id) {
        return iSubjectDal.getById(id);
    }

    @Override
    @Transactional
    public void add(Subject subject) {
        iSubjectDal.add(subject);
    }

    @Override
    @Transactional
    public void update(Subject subject) {
        iSubjectDal.update(subject);
    }

    @Override
    @Transactional
    public void delete(Subject subject) {
        iSubjectDal.delete(subject);
    }
}
