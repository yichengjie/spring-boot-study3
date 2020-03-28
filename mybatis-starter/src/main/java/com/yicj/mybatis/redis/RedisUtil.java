package com.yicj.mybatis.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class RedisUtil {


    @Autowired
    private RedisTemplate redisTemplate ;


    public boolean set(String key ,Object value){
        try {
            redisTemplate.opsForValue().set(key,value);
            return true ;
        }catch (Exception e){
            log.error("error : ", e);
            return false ;
        }
    }

    public boolean set(String key ,Object value, long time){
        try {
            redisTemplate.opsForValue().set(key,value, time, TimeUnit.SECONDS);
            return true ;
        }catch (Exception e){
            log.error("error : ", e);
            return false ;
        }
    }

    public Object get(String key){
        return key == null ? null : redisTemplate.opsForValue().get(key) ;
    }

}
