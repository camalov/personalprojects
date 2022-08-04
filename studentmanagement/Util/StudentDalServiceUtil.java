package com.project.studentmanagement.Util;

import com.project.studentmanagement.DataAccess.ISubjectDal;
import com.project.studentmanagement.DataAccess.ISubjectGroupDal;
import com.project.studentmanagement.Entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentDalServiceUtil {

    private ISubjectGroupDal iSubjectGroupDal;
    private ISubjectDal iSubjectDal;

    @Autowired
    public StudentDalServiceUtil(ISubjectGroupDal iSubjectGroupDal, ISubjectDal iSubjectDal) {
        this.iSubjectGroupDal = iSubjectGroupDal;
        this.iSubjectDal = iSubjectDal;
    }

    public List<Student> getStudentsWhithGroupName(List<Student> students) {
        List<String> groupIdArr = new ArrayList<>();
        String groupName;

        //read groupID in students List and add to groupIdArr
        for (Student student : students) {
            groupIdArr.add(student.getGroupID());
        }

        for (int id = 0; id < groupIdArr.size(); id++) {
            groupName = getGroupName(StringUtil.stringConvertToStringArr(groupIdArr.get(id), ", "));
            students.get(id).setGroupID(groupName);
        }

        return students;
    }

    public Student getStudentWhithGroupName(Student student) {
        String groupId = student.getGroupID();
        String groupName;
        groupName = getGroupName(StringUtil.stringConvertToStringArr(groupId, ", "));
        student.setGroupID(groupName);
        return student;
    }


    public List<Student> getStudentsWhithSubjectName(List<Student> students) {
        List<String> subjectIdArr = new ArrayList<>();
        String subjectName;

        //read subjectID in students List and add to subjectIdArr
        for (Student student : students) {
            subjectIdArr.add(student.getSubjectID());
        }

        for (int id = 0; id < subjectIdArr.size(); id++) {
            subjectName = getSubjectName(StringUtil.stringConvertToStringArr(subjectIdArr.get(id), ", "));
            students.get(id).setSubjectID(subjectName);
        }

        return students;
    }

    public Student getStudentWhithSubjectName(Student student) {
        String subjectId = student.getSubjectID();
        String subjectName;
        subjectName = getSubjectName(StringUtil.stringConvertToStringArr(subjectId, ", "));
        System.out.println(subjectName);
        student.setSubjectID(subjectName);
        return student;
    }

    public List<Student> getStudentsWhithSubjectAndGroupName(List<Student> students) {
        getStudentsWhithGroupName(students);
        getStudentsWhithSubjectName(students);
        return students;
    }

    public Student getStudentWhithSubjectAndGroupName(Student student) {
        getStudentWhithGroupName(student);
        getStudentWhithSubjectName(student);
        return student;
    }

    public String getGroupName(String[] groupId) {
        StringBuffer groupName = new StringBuffer();

        for (int i = 0, intID; i < groupId.length; i++) {
            intID = Integer.parseInt(groupId[i]);
            groupName.append(iSubjectGroupDal.getById(intID).getName());

            if (i >= 0 && i != groupId.length - 1) {
                groupName.append(", ");
            }
        }
        return groupName.toString();
    }

    public String getSubjectName(String[] subjectId) {
        StringBuffer subjectName = new StringBuffer();

        for (int i = 0, intID; i < subjectId.length; i++) {
            intID = Integer.parseInt(subjectId[i]);
            subjectName.append(iSubjectDal.getById(intID).getName());

            if (i >= 0 && i != subjectId.length - 1) {
                subjectName.append(", ");
            }
        }
        return subjectName.toString();
    }
}
