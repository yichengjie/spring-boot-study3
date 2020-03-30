package com.yicj.ioc.ann;

import com.yicj.ioc.model.Worker;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    @Override   //postProcessBeforeInitialization
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if(beanName.equals("worker")){
            return new Worker() ;
        }
        return null ;
    }


    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if(beanName.equals("worker")){
            Worker worker = (Worker) bean ;
            worker.setName("王五");
        }
        return false;
    }
}
