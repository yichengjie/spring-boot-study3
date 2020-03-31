package com.yicj.ioc;

import com.yicj.ioc.ann.MyImportBeanDefinitionRegistrar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(MyImportBeanDefinitionRegistrar.class)
public class IocApplication {

    public static void main(String[] args)  {
        new SpringApplication(IocApplication.class).run(args) ;
    }

}
