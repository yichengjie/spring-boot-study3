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
//        SpringApplication application = new SpringApplication(BootstrapApp.class) ;
//        application.addInitializers(new SecondInitializer());
//        application.addListeners(new SecondListener());
//        application.run(args) ;

    }



    public void test(){}
}
