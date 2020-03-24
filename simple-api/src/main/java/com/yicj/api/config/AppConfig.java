package com.yicj.api.config;

import com.yicj.api.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.yicj.api")
@PropertySource(value = {"classpath:jdbc.properties"})
public class AppConfig {

    @Bean
    public Person person(){
        Person person = new Person() ;
        return person ;
    }
}
