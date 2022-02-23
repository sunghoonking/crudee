package com.example.demo.models;


import com.example.demo.dto.request.SubjectDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity

public class Subject {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String subject;


    @OneToMany(mappedBy = "subject")
    List<Student> students = new ArrayList<>();



    public Subject(SubjectDto subjectDto){

        this.subject = subjectDto.getSubject();

    }

    public Subject update(SubjectDto subjectDto){
        this.subject = subjectDto.getSubject();

        return this;
    }
    public Subject(String subject){
        this.subject = subject;
    }

}
