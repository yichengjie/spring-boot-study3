package com.yicj.listener.component;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class MoocSpringContainer implements ApplicationListener<ContextRefreshedEvent> {
    private ApplicationContext context ;
    private static MoocSpringContainer moocSpringContainer ;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(context == null){
            context = event.getApplicationContext() ;
        }
        //注意这里直接将this赋值给单例
        moocSpringContainer = this ;
    }

    public MoocSpringContainer getInstance(){
        return moocSpringContainer ;
    }

    public <T> T getBean(Class<T> clazz){

        return context.getBean(clazz) ;
    }
}