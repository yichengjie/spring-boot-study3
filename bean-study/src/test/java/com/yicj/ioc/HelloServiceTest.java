package com.yicj.ioc;

import com.yicj.ioc.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
//@ContextConfiguration(locations = "classpath:ioc/demo.xml")
public class HelloServiceTest {

    @Autowired
    private HelloService helloService ;

    @Test
    public void testHello(){

        System.out.println("=======> " + helloService.hello());
    }
}
