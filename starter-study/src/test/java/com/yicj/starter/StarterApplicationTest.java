package com.yicj.starter;

import com.yicj.starter.condition.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StarterApplicationTest {

    @Autowired
    private ApplicationContext context;


    @Test
    public void testGetA(){
        A bean = context.getBean(A.class);
        System.out.println(bean);
    }

}
