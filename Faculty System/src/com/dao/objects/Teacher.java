package com.dao.objects;

public class Teacher {

    private int id, gender;
    private String teacherPhotoUrl;
    private String teacherName;
    private String teacherSurname;
    private String birthDate;
    private String teacherGraduateWT;
    private String languages;
    private String scientificName;
    private String academicDegree;
    private String department;
    private String articleLocal;
    private String articleOverseas;
    private String tezis;
    private String foreignCountries;

    public Teacher(
            int id,
            String teacherPhotoUrl,
            String teacherName,
            String teacherSurname,
            String birthDate,
            String teacherGraduateWT,
            int gender,
            String languages,
            String academicDegree,
            String scientificName,
            String department,
            String articleLocal,
            String articleOverseas,
            String tezis,
            String foreignCountries) {
        this.id = id;
        this.teacherPhotoUrl = teacherPhotoUrl;
        this.teacherName = teacherName;
        this.teacherSurname = teacherSurname;
        this.birthDate = birthDate;
        this.teacherGraduateWT = teacherGraduateWT;
        this.gender = gender;
        this.languages = languages;
        this.academicDegree = academicDegree;
        this.scientificName = scientificName;
        this.department = department;
        this.articleLocal = articleLocal;
        this.articleOverseas = articleOverseas;
        this.tezis = tezis;
        this.foreignCountries = foreignCountries;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacherPhotoUrl() {
        return teacherPhotoUrl;
    }

    public void setTeacherPhotoUrl(String teacherPhotoUrl) {
        this.teacherPhotoUrl = teacherPhotoUrl;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherSurname() {
        return teacherSurname;
    }

    public void setTeacherSurname(String teacherSurname) {
        this.teacherSurname = teacherSurname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getTeacherGraduateWT() {
        return teacherGraduateWT;
    }

    public void setTeacherGraduateWT(String teacherGraduateWT) {
        this.teacherGraduateWT = teacherGraduateWT;
    }

    public String getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getArticleLocal() {
        return articleLocal;
    }

    public void setArticleLocal(String articleLocal) {
        this.articleLocal = articleLocal;
    }

    public String getArticleOverseas() {
        return articleOverseas;
    }

    public void setArticleOverseas(String articleOverseas) {
        this.articleOverseas = articleOverseas;
    }

    public String getTezis() {
        return tezis;
    }

    public void setTezis(String tezis) {
        this.tezis = tezis;
    }

    public String getForeignCountries() {
        return foreignCountries;
    }

    public void setForeignCountries(String foreignCountries) {
        this.foreignCountries = foreignCountries;
    }
}
