package com.project.studentmanagement.Entities;

import com.project.studentmanagement.Util.DateUtil;

import javax.persistence.*;
import java.text.ParseException;
import java.util.Date;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "groupid")
    private String groupID;

    @Column(name = "subjectid")
    private String subjectID;

    @Column(name = "registrationdate")
    private Date registrationDate;

    @Column(name = "startdate")
    private Date startDate;

    @Column(name = "expirationdate")
    private Date expirationDate;

    public Student(int id, String name, String surname, String groupID, String subjectID, Date registrationDate,
                   String startDate, String expirationDate) throws ParseException {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.groupID = groupID;
        this.subjectID = subjectID;
        this.registrationDate = registrationDate;
        this.startDate = DateUtil.parse(startDate);
        this.expirationDate = DateUtil.parse(expirationDate);
    }

    public Student() {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }


    public String getRegistrationDate() {
        return DateUtil.formatStringDate(registrationDate, "yyyy-MM-dd");
    }

    public Date getRegistrationDateType() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getStartDate() {
        return DateUtil.formatStringDate(startDate,"yyyy-MM-dd");
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getExpirationDate() {
        return DateUtil.formatStringDate(expirationDate, "yyyy-MM-dd");
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
