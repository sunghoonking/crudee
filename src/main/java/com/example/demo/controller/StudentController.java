package com.example.demo.controller;

import com.example.demo.Repository.StudentRepository;
import com.example.demo.dto.request.StudentDto;
import com.example.demo.dto.request.Wrapper;
import com.example.demo.models.Student;
import com.example.demo.service.StudentService;
import com.example.demo.utils.PagingResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class StudentController {

    private  final StudentRepository studentRepository;
    private  final StudentService studentService;

    // 학생 저장
    @PostMapping("/api/students")
    public void setStudentInfo(@RequestBody StudentDto studentDto){
        studentService.setStudentInfo(studentDto);


    }

//    @GetMapping("/api/students")
//    public List<Student> getStudents(){
//        return studentRepository.findAll();
//
//    }
    // 학생 목록 조회
    @GetMapping("/api/students/{curPage}")
    public PagingResult getStudents(@PathVariable Integer curPage){
        return studentService.getStudents(curPage);

    }
//    @GetMapping("/api/students")
//    public List<StudentResponseDto> getStudents(@PathVariable Long studentId){
//        return studentService.getStudents(studentId);
//
//    }
    // 학생 목록 변경
    @PutMapping("/api/students/{id}")
    public String updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto){
        return studentService.update(id,studentDto);
    }

    // 학생 목록 삭제
    @DeleteMapping("/api/students")
    public void deleteStudent(@RequestBody Wrapper students){
        studentService.deleteStudents(students);






//        studentService.deleteStudent(students);

//        return studentService.deleteStudent(students);


    }


//    @DeleteMapping("/api/students/{id}")
//    public List<String> deleteStudent(@PathVariable List<String> id){
//
//        return studentService.deleteStudent(id);
//    }


//    @ResponseBody
//    @DeleteMapping("/api/students/{id}")
//    public List<String> deleteStu(@RequestBody List<String> studentIdxArray){
//        StudentService.delete(studentIdxArray);
//        return studentIdxArray;
//    }



}
