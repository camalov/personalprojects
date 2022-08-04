package com.project.studentmanagement.DataAccess;

import com.project.studentmanagement.Entities.Student;

import java.util.List;

public interface IStudentDal {
    public abstract List<Student> getAll();

    public abstract Student getById(int id);

    public abstract void add(Student student);

    public abstract void update(Student student);

    public abstract void delete(Student student);
}
