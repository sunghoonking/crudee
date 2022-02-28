package com.example.demo.service;

import com.example.demo.Repository.StudentRepository;
import com.example.demo.Repository.SubjectRepository;
import com.example.demo.dto.request.StudentDto;
import com.example.demo.dto.request.Wrapper;
import com.example.demo.dto.response.StudentResponseDto;
import com.example.demo.models.Student;
import com.example.demo.models.Subject;
import com.example.demo.utils.PagingResult;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private static final int BLOCK_PAGE_NUM_COUNT = 5;

    @Transactional
    public void setStudentInfo(StudentDto studentDto){


        Subject s = subjectRepository.findBySubject(studentDto.getSubject()).orElseThrow(
                ()-> new NullPointerException("과목이 없습니다")
        );
        Student student = new Student(studentDto,s);

        studentRepository.save(student);

    }

    public PagingResult getStudents(int curPage){
        Pageable pageable = PageRequest.of(curPage-1, BLOCK_PAGE_NUM_COUNT);
        Page<Student> students = studentRepository.findAllByOrderByCreatedAtDesc(pageable);

        List<Student> studentList = students.getContent();
        return new PagingResult(studentList, students.getTotalPages());
    }

//    public List<StudentResponseDto> getStudents(Long studentId){
//        return studentRepository.findAll(studentId);
//    }

    @Transactional
    public String update(Long id, StudentDto studentDto){
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다")
        );
        student.update(studentDto);

        return "success";
    }

    @Transactional
    public void deleteStudents(Wrapper students){

        List<String> test = students.getStudents();
        System.out.println(test);
        for (String s : test
        ) {
            long id = Long.parseLong(s);

            studentRepository.deleteById(id);
        }


    }


}
