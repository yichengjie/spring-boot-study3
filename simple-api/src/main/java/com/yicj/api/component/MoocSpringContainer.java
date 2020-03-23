package com.yicj.api.component;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

//监听ContextRefreshedEvent容器启动完成事件
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
