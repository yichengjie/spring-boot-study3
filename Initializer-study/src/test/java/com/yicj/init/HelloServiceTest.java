package com.yicj.init;

import com.yicj.init.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloServiceTest {

    @Autowired
    private HelloService helloService ;

    @Test
    public void testTest1(){
        System.out.println("=======> " + helloService.test1()); ;
    }

    //单元测试中这里获取不到设置的值，在web环境中正常获取value2
    @Test
    public void testTest2(){
        System.out.println("=======> " + helloService.test2());
    }

    @Test
    public void testTest3(){
        System.out.println("=======> " + helloService.test2());
    }

}
