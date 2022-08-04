package com.project.studentmanagement.Business;

import com.project.studentmanagement.DataAccess.IStudentDal;
import com.project.studentmanagement.DataAccess.ISubjectGroupDal;
import com.project.studentmanagement.Entities.Student;
import com.project.studentmanagement.Entities.SubjectGroup;
import com.project.studentmanagement.Util.StringUtil;
import com.project.studentmanagement.Util.StudentDalServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceManager implements IStudentService {

    private IStudentDal iStudentDal;
    private ISubjectGroupDal iSubjectGroupDal;
    private StudentDalServiceUtil studentDalServiceUtil;

    @Autowired
    public StudentServiceManager(IStudentDal iStudentDal, ISubjectGroupDal iSubjectGroupDal, StudentDalServiceUtil studentDalServiceUtil) {
        this.iStudentDal = iStudentDal;
        this.iSubjectGroupDal = iSubjectGroupDal;
        this.studentDalServiceUtil = studentDalServiceUtil;
    }

    @Override
    @Transactional
    public List<Student> getAll() {
        List<Student> students = iStudentDal.getAll();
        studentDalServiceUtil.getStudentsWhithSubjectAndGroupName(students);
        return students;
    }

    @Override
    @Transactional
    public List<Student> getAllWithId() {
        List<Student> students = iStudentDal.getAll();
        return students;
    }

    @Override
    public Student getById(int id) {
        return studentDalServiceUtil.getStudentWhithSubjectAndGroupName(iStudentDal.getById(id));
    }

    @Override
    public void add(Student student) {
        if (!student.getGroupID().isEmpty()) {
            increaseTheStudentNumberOfGroup(student);
        }
        iStudentDal.add(student);
    }

    @Override
    public void update(Student student) {
        increaseTheStudentNumberOfGroup(getNewGroup(student));
        reduceTheStudentNumberOfGroup(getRemovedGroup(student));
        iStudentDal.update(student);
    }

    @Override
    public void delete(Student student) {
        reduceTheStudentNumberOfGroup(getRemovedGroup(student));
        iStudentDal.delete(student);
    }

    public void increaseTheStudentNumberOfGroup(Student student) {
        String groups = student.getGroupID();
        String[] groupArr = StringUtil.stringConvertToStringArr(groups, ", ");

        for (int i = 0; i < groupArr.length; i++) {
            int groupId = Integer.parseInt(groupArr[i]);
            int studentNumber = iSubjectGroupDal.getById(groupId).getNumberOfStudent();
            System.out.println(studentNumber);
            SubjectGroup subjectGroup = iSubjectGroupDal.getById(groupId);
            subjectGroup.setNumberOfStudent(++studentNumber);
            iSubjectGroupDal.update(subjectGroup);
        }

    }

    public void increaseTheStudentNumberOfGroup(String group) {
        if (group == null) {
            return;
        }

        String[] groupArr = StringUtil.stringConvertToStringArr(group, ", ");

        for (int i = 0; i < groupArr.length; i++) {
            int groupId = Integer.parseInt(groupArr[i]);
            int studentNumber = iSubjectGroupDal.getById(groupId).getNumberOfStudent();
            SubjectGroup subjectGroup = iSubjectGroupDal.getById(groupId);
            subjectGroup.setNumberOfStudent(++studentNumber);
            iSubjectGroupDal.update(subjectGroup);
        }
    }

    public void reduceTheStudentNumberOfGroup(String group) {
        if (group == null) {
            return;
        }

        String[] groupArr = StringUtil.stringConvertToStringArr(group, ", ");

        for (int i = 0; i < groupArr.length; i++) {
            int groupId = Integer.parseInt(groupArr[i]);
            int studentNumber = iSubjectGroupDal.getById(groupId).getNumberOfStudent();
            SubjectGroup subjectGroup = iSubjectGroupDal.getById(groupId);
            subjectGroup.setNumberOfStudent(--studentNumber);
            iSubjectGroupDal.update(subjectGroup);
        }
    }

    public String getNewGroup(Student student) {
        if (student.getGroupID() == null || student.getGroupID().isEmpty()) {
            return null;
        }

        String groups = student.getGroupID();
        String existingGroupArr = iStudentDal.getById(student.getId()).getGroupID();
        String[] checkedStudentGroup = StringUtil.stringConvertToStringArr(groups, ", ");
        StringBuffer newGroupArr = new StringBuffer();

        for (int id = 0; id < checkedStudentGroup.length; id++) {
            if (!existingGroupArr.contains(checkedStudentGroup[id])) {
                newGroupArr.append(checkedStudentGroup[id]);

                if (id >= 0 && id < checkedStudentGroup.length - 1) {
                    newGroupArr.append(", ");
                }
            }
        }

        return newGroupArr.toString();
    }

    public String getRemovedGroup(Student student) {
        String existingGroupArr = iStudentDal.getById(student.getId()).getGroupID();

        if (existingGroupArr == null || existingGroupArr.isEmpty()) {
            return null;
        }

        String groups = student.getGroupID();
        String[] checkedStudentGroup = StringUtil.stringConvertToStringArr(existingGroupArr, ", ");
        StringBuffer removedGroupArr = new StringBuffer();
        System.out.println(groups);
        for (int id = 0; id < checkedStudentGroup.length; id++) {
            if (!groups.contains(checkedStudentGroup[id])) {
                removedGroupArr.append(checkedStudentGroup[id]);

                if (id >= 0 && id < checkedStudentGroup.length - 1) {
                    removedGroupArr.append(", ");
                }
            }
        }
        return removedGroupArr.toString();
    }
    /*
    public List<Student> getGroupName(List<Student> students) {
        List<String> groupIdArr = new ArrayList<>();
        String groupName;

        for (Student student : students) {
            groupIdArr.add(student.getGroupID());
        }

        for (int id = 0; id < groupIdArr.size(); id++) {
            groupName = fetchGroups(stringConvertToStringArr(groupIdArr.get(id), ", "));
            students.get(id).setGroupID(groupName);
        }

        return null;
    }

    //String convert to StringArray
    public String[] stringConvertToStringArr(String id, String regex) {
        String[] stringArray = id.split(regex);
        return stringArray;
    }

    public String fetchGroups(String[] groupId) {
        StringBuffer groupName = new StringBuffer();

        for (int i = 0, intID; i < groupId.length; i++) {
            System.out.println(groupId[i]);
            intID = Integer.parseInt(groupId[i]);
            groupName.append(iSubjectGroupDal.getById(intID).getName());

            if (i >= 0 && i != groupId.length - 1) {
                groupName.append(", ");
            }
        }

        return groupName.toString();

     */

}