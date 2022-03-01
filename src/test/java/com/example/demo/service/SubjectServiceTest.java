package com.example.demo.service;


import com.example.demo.Repository.SubjectRepository;
import com.example.demo.dto.request.SubjectDto;
import com.example.demo.models.Subject;
import jdk.internal.loader.AbstractClassLoaderValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.transaction.Transactional;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@Transactional
@ExtendWith(MockitoExtension.class)
public class SubjectServiceTest {


    @Mock
    SubjectRepository subjectRepository;

    SubjectDto subjectDto;

    @InjectMocks
    SubjectService subjectService;

    @Test
    @DisplayName("과목을 처음 저장할 때")
    void newSubject(){

        //given
        Subject subject = null;
        subjectDto = new SubjectDto("컴퓨터공학과");

        ArgumentCaptor<Subject> captor = ArgumentCaptor.forClass(Subject.class);

        given(subjectRepository.findBySubject("컴퓨터공학과")).willReturn(Optional.ofNullable(subject));

        //when
        String result = subjectService.setSubjectInfo(subjectDto);

        //then
        verify(subjectRepository,times(1)).save(captor.capture());
        Subject result1 = captor.getValue();

        assertEquals(result1.getSubject(),"컴퓨터공학과");


    }
    @Test
    @DisplayName("똑같은 과목을 저장할 때")
    void sameSubject(){

        subjectDto = new SubjectDto("컴퓨터공학과");

        Subject subject = new Subject(subjectDto);
    }



}
