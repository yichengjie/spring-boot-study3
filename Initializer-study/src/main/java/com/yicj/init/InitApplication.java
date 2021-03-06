package com.yicj.init;

import com.yicj.init.component.SecondInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@PropertySource("jdbc.properties")
public class InitApplication {

    public static void main(String[] args) {
        //SpringApplication.run(InitApplication.class,args) ;
        SpringApplication application = new SpringApplication(InitApplication.class) ;
        application.addInitializers(new SecondInitializer());
        application.run(args) ;
    }
}
