package com.yicj.mybatis;

import com.yicj.mybatis.service.UserQueryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Method;

@Slf4j
public class ReflectTest {


    @Test
    public void test1() throws Exception {
        Method method = UserQueryService.class.getMethod("queryUserById", Integer.class);
        log.info("method declaring class is : {}", method.getDeclaringClass());
    }
}
