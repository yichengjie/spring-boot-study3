package com.yicj.api.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestService implements ApplicationContextAware {

    private ApplicationContext applicationContext ;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext ;
    }

    public String test1(){
        Environment environment = applicationContext.getEnvironment();
        String key = environment.getProperty("key1");
        return Optional.ofNullable(key).orElse("default value") ;
    }

    public String test2(){
        Environment environment = applicationContext.getEnvironment();
        String key = environment.getProperty("key2");
        return Optional.ofNullable(key).orElse("default value") ;
    }


    public String test3(){
        Environment environment = applicationContext.getEnvironment();
        String key = environment.getProperty("key3");
        return Optional.ofNullable(key).orElse("default value") ;
    }
}
