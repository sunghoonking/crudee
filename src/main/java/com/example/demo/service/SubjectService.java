package com.example.demo.service;


import com.example.demo.Repository.SubjectRepository;
import com.example.demo.dto.request.SubjectDto;
import com.example.demo.dto.request.Wrapper;
import com.example.demo.models.Subject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;


    @Transactional
    public String setSubjectInfo(SubjectDto subjectDto){
        Subject subject = new Subject(subjectDto);
        subjectRepository.save(subject);

        return "success";
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
