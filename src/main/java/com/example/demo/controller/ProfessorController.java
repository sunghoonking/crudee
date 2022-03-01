package com.example.demo.controller;


import com.example.demo.Repository.ProfessorRepository;
import com.example.demo.dto.request.ProfessorDto;
import com.example.demo.dto.request.StudentDto;
import com.example.demo.dto.request.Wrapper;
import com.example.demo.models.Professor;
import com.example.demo.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.processing.SupportedAnnotationTypes;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProfessorController {

    private final ProfessorRepository professorRepository;
    private final ProfessorService professorService;


    // 교수 저장
    @PostMapping("/api/professors")
    public void setProfessorInfo(@RequestBody ProfessorDto professorDto){
        professorService.setProfessorInfo(professorDto);
    }
    // 교수 목록 조회
    @GetMapping("/api/professors")
    public List<Professor> getProfessors(){
        return professorRepository.findAll();
    }


    // 교수 목록 변경
    @PutMapping("/api/professors/{id}")
    public String updateProfessor(@PathVariable Long id, @RequestBody ProfessorDto professorDto){
        return professorService.update(id, professorDto);
    }
    // 교수 목록 삭제
    @DeleteMapping("/api/professors")
    public void deleteProfessor(@RequestBody Wrapper professor){
        professorService.deleteProfessors(professor);

    }




}
