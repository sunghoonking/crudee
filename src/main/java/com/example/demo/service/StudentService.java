package com.example.demo.service;

import com.example.demo.Repository.StudentRepository;
import com.example.demo.dto.request.StudentDto;
import com.example.demo.dto.request.Wrapper;
import com.example.demo.dto.response.StudentResponseDto;
import com.example.demo.models.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;


    @Transactional
    public void setStudentInfo(StudentDto studentDto){
        Student student = new Student(studentDto);
        studentRepository.save(student);

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
