package com.yicj.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootstrapApp {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(AppConfig.class) ;
//        context.close();
        SpringApplication.run(BootstrapApp.class,args) ;

    }



    public void test(){}
}
