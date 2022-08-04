package com.project.studentmanagement.Entities;

import com.project.studentmanagement.Util.DateUtil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.ParseException;
import java.util.Date;


@Entity
@Table(name = "subjectgroup")
public class SubjectGroup {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "groupauthor")
    private String groupAuthor;

    @Column(name = "subjectid")
    private int subjectID;

    @Column(name = "numberofstudent")
    private int numberOfStudent;

    @Column(name = "dateofcreation")
    private Date dateOfCreation;

    @Column(name = "startdate")
    private Date startDate;

    @Column(name = "expirationdate")
    private Date expirationDate;

    public SubjectGroup(int id, int subjectID, int numberOfStudent, Date dateOfCreation, String startDate, String expirationDate, String name, String groupAuthor) throws ParseException {
        this.id = id;
        this.name = name;
        this.subjectID = subjectID;
        this.numberOfStudent = numberOfStudent;
        this.dateOfCreation = dateOfCreation;
        this.startDate = DateUtil.parse(startDate);
        this.expirationDate = DateUtil.parse(expirationDate);
        this.groupAuthor = groupAuthor;
    }

    public SubjectGroup() {

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

    public String getGroupAuthor() {
        return groupAuthor;
    }

    public void setGroupAuthor(String groupAuthor) {
        this.groupAuthor = groupAuthor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public int getNumberOfStudent() {
        return numberOfStudent;
    }

    public void setNumberOfStudent(int numberOfStudent) {
        this.numberOfStudent = numberOfStudent;
    }

    public String getDateOfCreation() {
        return DateUtil.formatStringDate(dateOfCreation, "yyyy-MM-dd");
    }

    public Date getDateOfCreationDateType() {
        return this.dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getStartDate() {
        return DateUtil.formatStringDate(startDate, "yyyy-MM-dd");
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
