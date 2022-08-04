package com.project.studentmanagement.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "lessonschedule")
public class LessonsSchedule {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "subjectid")
    private int subjectID;

    @Column(name = "groupid")
    private int groupID;

    @Column(name = "studentid")
    private int studentID;

    @Column(name = "lessonday")
    private Date lessonDay;

    @Column(name = "lessontime")
    private Date lessonTime;

    public LessonsSchedule(int id, int subjectID, int groupID, int studentID, Date lessonDay, Date lessonTime) {
        this.id = id;
        this.subjectID = subjectID;
        this.groupID = groupID;
        this.studentID = studentID;
        this.lessonDay = lessonDay;
        this.lessonTime = lessonTime;
    }

    public LessonsSchedule() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public Date getLessonDay() {
        return lessonDay;
    }

    public void setLessonDay(Date lessonDay) {
        this.lessonDay = lessonDay;
    }

    public Date getLessonTime() {
        return lessonTime;
    }

    public void setLessonTime(Date lessonTime) {
        this.lessonTime = lessonTime;
    }
}
