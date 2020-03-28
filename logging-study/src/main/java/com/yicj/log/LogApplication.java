package com.yicj.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class LogApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogApplication.class, args) ;
    }
}
