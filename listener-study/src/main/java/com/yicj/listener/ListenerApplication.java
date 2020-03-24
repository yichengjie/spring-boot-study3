package com.yicj.listener;

import com.yicj.listener.component.SecondListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ListenerApplication {

    public static void main(String[] args) {
        //SpringApplication.run(ListenerApplication.class,args) ;
        SpringApplication application = new SpringApplication(ListenerApplication.class) ;
        application.addListeners(new SecondListener());
        application.run(args) ;
    }
}
