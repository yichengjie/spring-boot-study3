package com.yicj.exception;

import com.yicj.exception.demo3.Solid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EXApplication {

    @Autowired
    private Solid solid ;

    public static void main(String[] args) {
        SpringApplication.run(EXApplication.class,args) ;
    }
}
