package com.yicj.mybatis;

import com.sun.deploy.util.StringUtils;
import com.yicj.mybatis.bean.Demo;
import com.yicj.mybatis.mapper.DemoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTest {

    @Autowired
    private DemoMapper demoMapper ;

    @Test
    public void testInsert(){
        Demo demo = new Demo();
        demo.setName("张三");
        demo.setJob("student");
        demoMapper.insert(demo) ;
    }

    @Test
    public void testInsert2(){
        Demo demo = new Demo();
        demo.setName("李四");
        demo.setJob("teacher");
        demoMapper.insert(demo) ;
    }

    @Test
    public void testQuery(){
        List<Demo> demos = demoMapper.selectByExample(null);
        demos.forEach(System.out::println);
    }

}
