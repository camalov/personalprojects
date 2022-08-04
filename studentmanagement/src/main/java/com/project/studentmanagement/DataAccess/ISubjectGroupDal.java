package com.project.studentmanagement.DataAccess;

import com.project.studentmanagement.Entities.SubjectGroup;

import java.util.List;

public interface ISubjectGroupDal {
    public abstract List<SubjectGroup> getAll();

    public abstract SubjectGroup getById(int id);

    public abstract void add(SubjectGroup subjectGroup);

    public abstract void update(SubjectGroup subjectGroup);

    public abstract void delete(SubjectGroup subjectGroup);
}
