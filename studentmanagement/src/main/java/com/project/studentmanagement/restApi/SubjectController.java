package com.project.studentmanagement.restApi;

import com.project.studentmanagement.Business.ISubjectService;
import com.project.studentmanagement.Entities.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubjectController {
    ISubjectService iSubjectService;

    @Autowired
    public SubjectController(ISubjectService iSubjectService) {
        this.iSubjectService = iSubjectService;
    }

    @GetMapping("/subjects")
    public List<Subject> get(){
        return iSubjectService.getAll();
    }

    @GetMapping("/subjects/{id}")
    public Subject getById(@PathVariable int id){
        return iSubjectService.getById(id);
    }

    @PostMapping("/subjects/add")
    public void add(@RequestBody Subject subject) {
        iSubjectService.add(subject);
    }

    @PostMapping("/subjects/update")
    public void update(@RequestBody Subject subject) {
        iSubjectService.update(subject);
    }

    @PostMapping("/subjects/delete")
    public void delete(@RequestBody Subject subject) {
        iSubjectService.delete(subject);
    }
}
