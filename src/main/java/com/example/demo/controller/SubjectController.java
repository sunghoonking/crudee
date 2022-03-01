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


    // 과목 저장
    @PostMapping("/api/subjects")
    public void setSubjectInfo(@RequestBody SubjectDto subjectDto){
        subjectService.setSubjectInfo(subjectDto);
    }

    // 과목 목록 조회
    @GetMapping("/api/subjects")
    public List<Subject> getSubjects(){
        return subjectRepository.findAll();
    }

    // 과목 목록 변경
    @PutMapping("/api/subjects/{id}")
    public String updateSubject(@PathVariable Long id, @RequestBody SubjectDto subjectDto){
        return subjectService.updateSubject(id,subjectDto);
    }
    // 과목 목록 삭제
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
