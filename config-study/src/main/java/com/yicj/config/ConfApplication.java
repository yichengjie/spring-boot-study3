package com.yicj.config;

import com.yicj.config.selector.MyDeferredImportSelector;
import com.yicj.config.selector.MyImportSelector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({MyDeferredImportSelector.class, MyImportSelector.class})
public class ConfApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfApplication.class,args) ;
    }

}
