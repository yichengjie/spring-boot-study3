package com.yicj.exception.demo4;

import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.boot.SpringBootExceptionReporter;
import org.springframework.context.ConfigurableApplicationContext;

public class MyExceptionReporter implements SpringBootExceptionReporter {

    private ConfigurableApplicationContext context ;

    public MyExceptionReporter(ConfigurableApplicationContext context){
        this.context = context ;
    }

    @Override
    public boolean reportException(Throwable failure) {
        if (failure instanceof UnsatisfiedDependencyException){
            UnsatisfiedDependencyException ex =  (UnsatisfiedDependencyException)failure ;
            System.out.println("=======> no such bean " + ex.getInjectionPoint().getField().getName());
        }
        return false;
    }
}
