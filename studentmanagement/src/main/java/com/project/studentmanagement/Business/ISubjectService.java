package com.project.studentmanagement.Business;

import com.project.studentmanagement.Entities.Subject;

import java.util.List;

public interface ISubjectService {
    public abstract List<Subject> getAll();

    public abstract Subject getById(int id);

    public abstract void add(Subject subject);

    public abstract void update(Subject subject);

    public abstract void delete(Subject subject);
}
