package com.project.studentmanagement.restApi;

import com.project.studentmanagement.Business.IStudentService;
import com.project.studentmanagement.Entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    IStudentService iStudentService;

    @Autowired
    public StudentController(IStudentService iStudentService) {
        this.iStudentService = iStudentService;
    }

    @GetMapping("/students")
    public List<Student> get() {
        return iStudentService.getAll();
    }

    @GetMapping("/studentsID")
    public List<Student> getWithId() {
        return iStudentService.getAllWithId();
    }

    @PostMapping("/students/{id}")
    public Student getById(@PathVariable int id) {
        return iStudentService.getById(id);
    }

    @PostMapping("/students/add")
    public void add(@RequestBody Student student) {
        iStudentService.add(student);
    }

    @PostMapping("/students/update")
    public void update(@RequestBody Student student) {
        iStudentService.update(student);
    }
}
