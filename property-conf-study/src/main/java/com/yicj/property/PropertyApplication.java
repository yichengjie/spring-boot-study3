package com.yicj.property;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import java.util.Properties;

@SpringBootApplication
@PropertySource({"demo.properties"})
public class PropertyApplication {

    public static void main(String[] args) {
        //SpringApplication.run(PropertyApplication.class,args) ;
        SpringApplication application = new SpringApplication(PropertyApplication.class) ;
        Properties properties = new Properties() ;
        properties.setProperty("mooc.website.url","mooc.url_1") ;
        application.setDefaultProperties(properties);
        application.run(args) ;
    }

}
