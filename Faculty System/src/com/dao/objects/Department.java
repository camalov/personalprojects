package com.dao.objects;

public class Department {

    private int id;
    private String name;
    private int teacherCount;
    private int groupCount;
    private int studentCount;
    private int subjectCount;

    public Department(int id, String name, int teacherCount, int groupCount, int studentCount, int subjectCount) {
        this.id = id;
        this.name = name;
        this.teacherCount = teacherCount;
        this.groupCount = groupCount;
        this.studentCount = studentCount;
        this.subjectCount = subjectCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeacherCount() {
        return teacherCount;
    }

    public void setTeacherCount(int teacherCount) {
        this.teacherCount = teacherCount;
    }

    public int getGroupCount() {
        return groupCount;
    }

    public void setGroupCount(int groupCount) {
        this.groupCount = groupCount;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public int getSubjectCount() {
        return subjectCount;
    }

    public void setSubjectCount(int subjectCount) {
        this.subjectCount = subjectCount;
    }
}
