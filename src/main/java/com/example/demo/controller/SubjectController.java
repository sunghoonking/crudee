package com.example.demo.controller;

import com.example.demo.Repository.SubjectRepository;
import com.example.demo.dto.request.SubjectDto;
import com.example.demo.dto.request.Wrapper;
import com.example.demo.models.Subject;
import com.example.demo.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class SubjectController {
    private final SubjectRepository subjectRepository;
    private final SubjectService subjectService;

    @PostMapping("/api/subjects")
    public void setSubjectInfo(@RequestBody SubjectDto subjectDto){
        subjectService.setSubjectInfo(subjectDto);
    }

    @GetMapping("/api/subjects")
    public List<Subject> getSubjects(){
        return subjectRepository.findAll();
    }

    @PutMapping("/api/subjects/{id}")
    public String updateSubject(@PathVariable Long id, @RequestBody SubjectDto subjectDto){
        return subjectService.updateSubject(id,subjectDto);
    }

    @DeleteMapping("/api/subjects")
    public void deleteSubject(@RequestBody Wrapper subjects){
        subjectService.deleteSubjects(subjects);
    }



//    @GetMapping("/api/subjects")
//    public List<Subject> getSubjects() {
//        return subjectService.getSubjects;
//
//    }


}
