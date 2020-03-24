package com.yicj.ioc.ann;

import com.yicj.ioc.model.Animal;
import com.yicj.ioc.model.Cat;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class CatFactoryBean implements FactoryBean<Animal> {
    @Override
    public Animal getObject() throws Exception {
        return new Cat();
    }

    @Override
    public Class<?> getObjectType() {
        return Animal.class;
    }
}
