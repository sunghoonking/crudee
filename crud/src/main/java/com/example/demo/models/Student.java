package com.example.demo.models;

import com.example.demo.dto.request.StudentDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@NoArgsConstructor
@Entity
public class Student {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "student_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String address;

    public Student(StudentDto studentDto){
        this.name = studentDto.getName();
        this.age = studentDto.getAge();
        this.subject = studentDto.getSubject();
        this.address = studentDto.getAddress();

    }

    public Student update(StudentDto studentDto){
        this.name = studentDto.getName();
        this.age = studentDto.getAge();
        this. subject = studentDto.getSubject();

        return this;
    }

}
