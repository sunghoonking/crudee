package com.example.demo.service;


import com.example.demo.Repository.ProfessorRepository;
import com.example.demo.dto.request.ProfessorDto;
import com.example.demo.dto.request.Wrapper;
import com.example.demo.models.Professor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;


    @Transactional
    public void setProfessorInfo(ProfessorDto professorDto){
        Professor professor = new Professor(professorDto);
        professorRepository.save(professor);
    }

    @Transactional
    public String update(Long id, ProfessorDto professorDto){
        Professor professor = professorRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이다가 존재하지 않습니다")
        );
    professor.update(professorDto);
    return "success";
    }

    @Transactional
    public void deleteProfessors(Wrapper professors){

        List<String> test = professors.getProfessors();

        for (String s : test
             ) {
            long id = Long.parseLong(s);

            professorRepository.deleteById(id);

        }
    }


}
