package com.yicj.ioc.service;

import com.yicj.ioc.model.Animal;
import com.yicj.ioc.model.Dog;
import com.yicj.ioc.model.Student;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Data
@Component
public class HelloService {
    private Student student ;

    @Autowired
    @Qualifier("bird")
    private Animal animal ;

    public String hello(){
       return animal.getName() ;
    }

}
