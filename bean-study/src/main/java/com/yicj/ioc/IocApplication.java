package com.yicj.ioc;

import com.yicj.ioc.ann.MyBeanImport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(MyBeanImport.class)
public class IocApplication {

    public static void main(String[] args)  {
        new SpringApplication(IocApplication.class).run(args) ;
    }

}
