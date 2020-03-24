package com.yicj.ioc.model;

import lombok.Data;

import java.util.List;

@Data
public class Student {

    private String name ;
    private Integer age ;
    private List<String> classList ;


    public Student(String name, Integer age){
        this.name = name ;
        this.age = age ;
    }

}
