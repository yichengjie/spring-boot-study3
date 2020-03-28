package com.yicj.mybatis;

import com.sun.deploy.util.StringUtils;
import com.yicj.mybatis.bean.User;
import com.yicj.mybatis.mapper.UserMapper;
import com.yicj.mybatis.redis.RedisUtil;
import com.yicj.mybatis.service.UserQueryService;
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
    private RedisUtil redisUtil ;

    @Autowired
    private UserMapper demoMapper ;

    @Autowired
    private UserQueryService userQueryService ;

    @Test
    public void testInsert(){
        User demo = new User();
        demo.setName("张三");
        demo.setJob("student");
        demoMapper.insert(demo) ;
    }

    @Test
    public void testInsert2(){
        User demo = new User();
        demo.setName("李四");
        demo.setJob("teacher");
        demoMapper.insert(demo) ;
    }

    @Test
    public void testQuery(){
        List<User> demos = demoMapper.selectByExample(null);
        demos.forEach(System.out::println);
    }


    @Test
    public void testRedis() throws InterruptedException {
        redisUtil.set("mooc", "test", 3) ;
        System.out.println(redisUtil.get("mooc"));
        Thread.sleep(3000) ;
        System.out.println(redisUtil.get("mooc"));
    }


    @Test
    public void testQuery2(){
        System.out.println(userQueryService.queryUserById(1));
        System.out.println(userQueryService.queryUserById(1));
        System.out.println(userQueryService.queryUserById(2));
        System.out.println(userQueryService.queryUserById(2));
        System.out.println(userQueryService.queryUserById(3));
        System.out.println(userQueryService.queryUserById(3));
    }

}
