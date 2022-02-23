package com.example.demo.service;


import com.example.demo.Repository.SubjectRepository;
import com.example.demo.dto.request.SubjectDto;
import com.example.demo.dto.request.Wrapper;
import com.example.demo.models.Subject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;


    @Transactional
    public String setSubjectInfo(SubjectDto subjectDto){

        String sub = subjectDto.getSubject();
        String message;
        Optional<Subject> found = subjectRepository.findBySubject(sub);
        if(found.isPresent()){
            message = "이미 있는 학과명 입니다";

        } else {
            Subject subject = new Subject(sub);
            subjectRepository.save(subject);
        }
        
        return "false";
    }


    @Transactional
    public String updateSubject(Long id, SubjectDto subjectDto){
        Subject subject = subjectRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재지 않습니다")
        );

        subject.update(subjectDto);
        return "success";
    }


    @Transactional
    public void deleteSubjects(Wrapper subjects) {
        List<String> test = subjects.getSubjects();
        for (String s: test
             ) {
            long id = Long.parseLong(s);
            subjectRepository.deleteById(id);

        }
    }
}
