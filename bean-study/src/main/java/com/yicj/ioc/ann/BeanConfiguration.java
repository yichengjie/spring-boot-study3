package com.yicj.ioc.ann;

import com.yicj.ioc.model.Animal;
import com.yicj.ioc.model.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean("dog")
    public Animal getDog(){
        return new Dog() ;
    }
}
