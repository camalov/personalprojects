package com.project.studentmanagement.Business;

import com.project.studentmanagement.Entities.Student;

import java.util.List;

public interface IStudentService {
    public abstract List<Student> getAll();

    public abstract List<Student> getAllWithId();

    public abstract Student getById(int id);

    public abstract void add(Student student);

    public abstract void update(Student student);

    public abstract void delete(Student student);
}
