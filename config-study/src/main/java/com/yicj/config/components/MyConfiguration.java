package com.yicj.config.components;

import com.yicj.config.model.Student;
import com.yicj.config.model.Teacher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    public Student student(){
        return new Student() ;
    }

    @Bean
    public Teacher teacher(){
        return new Teacher() ;
    }

}
