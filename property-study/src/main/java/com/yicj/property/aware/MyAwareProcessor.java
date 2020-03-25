package com.yicj.property.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyAwareProcessor implements BeanPostProcessor {
    private ApplicationContext ac ;
    public MyAwareProcessor(ApplicationContext ac){
        this.ac = ac ;
    }
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Aware){
            if (bean instanceof MyAware){
                Flag flag = (Flag) ac.getBean("flag") ;
                ((MyAware)bean).setFlag(flag);
            }
        }
        return bean;
    }
}
