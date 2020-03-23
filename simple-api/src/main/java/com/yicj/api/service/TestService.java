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

    public String test(){
        Environment environment = applicationContext.getEnvironment();
        String key1 = environment.getProperty("key1");
        return Optional.ofNullable(key1).orElse("default value") ;
    }
}
