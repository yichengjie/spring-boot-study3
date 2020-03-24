package com.yicj.ioc.xml;

import com.yicj.ioc.model.Animal;
import com.yicj.ioc.model.Cat;
import com.yicj.ioc.model.Dog;

public class AnimalFactory {

    public Animal getAnimal(String type) {
        if ("dog".equals(type)){
            return new Dog() ;
        }else {
            return new Cat() ;
        }
    }
}
