package com.example.demo.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class Wrapper {

    List<String> students;
    List<String> subjects;
    List<String> professors;

}
