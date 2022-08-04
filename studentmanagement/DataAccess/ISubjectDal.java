package com.project.studentmanagement.DataAccess;

import com.project.studentmanagement.Entities.Subject;

import java.util.List;

public interface ISubjectDal {
    /*
    @Override
    public abstract List<Subject> getAll();

    @Override
    public abstract Subject getById(int id);

    @Override
    public abstract <Subject> void add(Subject subject);

    @Override
    public abstract <Subject> void update(Subject subject);

    @Override
    public abstract <Subject> void delete(Subject subject);
*/

    public abstract List<Subject> getAll();

    public abstract Subject getById(int id);

    public abstract void add(Subject subject);

    public abstract void update(Subject subject);

    public abstract void delete(Subject subject);
}