package com.yicj.api.hello.annos;

import com.yicj.api.hello.abstra.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {


    @Bean
    public Dog dog(){
        return new Dog() ;
    }


    @Bean
    public Dog dog2(){
        return new Dog() ;
    }

}
