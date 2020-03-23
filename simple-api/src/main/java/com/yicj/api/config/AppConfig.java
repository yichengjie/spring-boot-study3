package com.yicj.api.config;

import com.yicj.api.component.DatabaseProperties;
import com.yicj.api.entity.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = "com.yicj.api")
@PropertySource(value = {"classpath:jdbc.properties"})
public class AppConfig {

    @Bean
    public Person person(DatabaseProperties databaseProperties){
        System.out.println("driverName : " + databaseProperties.getDriverName());
        Person person = new Person() ;
        return person ;
    }
}