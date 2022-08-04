package com.project.studentmanagement.restApi;

import com.project.studentmanagement.Business.ISubjectGroupService;
import com.project.studentmanagement.Entities.SubjectGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SubjectGroupController {
    private ISubjectGroupService iSubjectService;

    @Autowired
    public SubjectGroupController(ISubjectGroupService iSubjectService) {
        this.iSubjectService = iSubjectService;
    }

    @GetMapping("/subjectgroups")
    public List<SubjectGroup> get(SubjectGroup subjectGroup) {
        return iSubjectService.getAll();
    }

    @GetMapping("/subjectgroups/{id}")
    public SubjectGroup getById(@PathVariable int id) {
        return iSubjectService.getById(id);
    }

    @PostMapping("/subjectgroups/add")
    public void add(@RequestBody SubjectGroup subjectGroup) throws ParseException {
        iSubjectService.add(subjectGroup);
    }

    @PostMapping("/subjectgroups/update")
    public void update(@RequestBody SubjectGroup subjectGroup) throws ParseException {
        iSubjectService.update(subjectGroup);
    }

    @PostMapping("/subjectgroups/delete")
    public void delete(@RequestBody SubjectGroup subjectGroup) throws ParseException {
        iSubjectService.delete(subjectGroup);
    }
}
