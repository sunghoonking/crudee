package com.example.demo.dto.response;


import com.example.demo.models.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StudentResponseDto {
    private Long studentId;
    private String name;
    private String subject;
    private int age;
    private String address;


    public  StudentResponseDto(Student student){
        this.studentId = student.getId();
        this.name = student.getName();
        this.subject = student.getSubject();
        this.age = student.getAge();
        this.address = student.getAddress();
    }
}
