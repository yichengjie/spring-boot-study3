package com.yicj.api.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class HelloBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(HelloBootstrap.class,args) ;
    }
}
