package com.example.demo.service;


import com.example.demo.Repository.SubjectRepository;
import com.example.demo.dto.request.SubjectDto;
import com.example.demo.models.Subject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.transaction.Transactional;

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
        subjectDto = new SubjectDto("컴퓨터 공학과");


    }



}
