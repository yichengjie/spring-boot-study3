package com.yicj.web;

import org.junit.Test;
import org.springframework.beans.factory.ObjectFactory;

public class WebApplicationTest {


    @Test
    public void testHell(){
        ObjectFactory factory = () -> 1 ;
        Object object = factory.getObject();
        System.out.println(object);
    }

}
