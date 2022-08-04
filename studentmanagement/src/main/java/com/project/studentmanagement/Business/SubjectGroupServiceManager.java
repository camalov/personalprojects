package com.project.studentmanagement.Business;

import com.project.studentmanagement.DataAccess.ISubjectGroupDal;
import com.project.studentmanagement.Entities.SubjectGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class SubjectGroupServiceManager implements ISubjectGroupService {
    private ISubjectGroupDal iSubjectGroupDal;
    private EntityManager entityManager;

    @Autowired
    public SubjectGroupServiceManager(ISubjectGroupDal iSubjectGroupDal, EntityManager entityManager) {
        this.iSubjectGroupDal = iSubjectGroupDal;
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<SubjectGroup> getAll() {
        return iSubjectGroupDal.getAll();
    }

    @Override
    @Transactional
    public SubjectGroup getById(int id) {
        return iSubjectGroupDal.getById(id);
    }

    @Override
    @Transactional
    public void add(SubjectGroup subjectGroup) {
        iSubjectGroupDal.add(subjectGroup);
    }

    @Override
    @Transactional
    public void update(SubjectGroup subjectGroup) {
        iSubjectGroupDal.update(controlEmptyDateOfCreation(subjectGroup));
    }

    @Override
    @Transactional
    public void delete(SubjectGroup subjectGroup) {
        iSubjectGroupDal.delete(subjectGroup);
    }

    public SubjectGroup controlEmptyDateOfCreation(SubjectGroup subjectGroup) {
        if (subjectGroup.getDateOfCreation() == "" || subjectGroup.getDateOfCreation() == null) {
            SubjectGroup dateOfCreation = getById(subjectGroup.getId());
            subjectGroup.setDateOfCreation(dateOfCreation.getDateOfCreationDateType());
        }
        return subjectGroup;
    }

}
