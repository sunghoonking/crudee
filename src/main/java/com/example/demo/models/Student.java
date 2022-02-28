package com.example.demo.models;

import com.example.demo.dto.request.StudentDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;


@Setter
@Getter
@NoArgsConstructor
@Entity
public class Student extends TimeStamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "student_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String address;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "subjectId",nullable = true)
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "professorId",nullable = true)
    private Professor professor;





    public Student(StudentDto studentDto, Subject s){
        this.name = studentDto.getName();
        this.age = studentDto.getAge();
        this.address = studentDto.getAddress();
        this.subject = s;


    }

    public Student update(StudentDto studentDto){
        this.name = studentDto.getName();
        this.age = studentDto.getAge();

        return this;
    }

}
