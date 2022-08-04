package com.project.studentmanagement.Business;

import com.project.studentmanagement.Entities.SubjectGroup;

import java.text.ParseException;
import java.util.List;

public interface ISubjectGroupService {
    public abstract List<SubjectGroup> getAll();

    public abstract SubjectGroup getById(int id);

    public abstract void add(SubjectGroup subjectGroup) throws ParseException;

    public abstract void update(SubjectGroup subjectGroup) throws ParseException;

    public abstract void delete(SubjectGroup subjectGroup) throws ParseException;
}
