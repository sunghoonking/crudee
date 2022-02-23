package com.example.demo.models;


import com.example.demo.dto.request.ProfessorDto;
import com.example.demo.dto.request.StudentDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity

public class Professor {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    public Professor(ProfessorDto professorDto){
        this.name = professorDto.getName();
        this.age = professorDto.getAge();
    }
    public Professor update(ProfessorDto professorDto){
        this.name = professorDto.getName();
        this.age = professorDto.getAge();

        return this;
    }



}
