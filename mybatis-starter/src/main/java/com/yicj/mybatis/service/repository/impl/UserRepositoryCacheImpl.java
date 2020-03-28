package com.yicj.mybatis.service.repository.impl;

import com.alibaba.fastjson.JSON;
import com.yicj.mybatis.bean.User;
import com.yicj.mybatis.redis.RedisUtil;
import com.yicj.mybatis.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.Random;

@Repository
public class UserRepositoryCacheImpl implements UserRepository {

    private static final String CACHE_PREFIX = "cache_prefix_" ;
    private static final Random random = new Random() ;
    private User nullUser = new User(-1) ;
    @Autowired
    private RedisUtil redisUtil ;

    @Autowired
    @Qualifier("userRepositoryDataImpl")
    private UserRepository userRepository ;

    @Override
    public User queryUserById(Integer id) {
        User user = getUserFromCache(id) ;
        if (user == null){
            System.out.println("cache not hit");
            user = userRepository.queryUserById(id) ;
            cacheUser(user, id) ;
        }else if (user.getId() == -1){
            System.out.println("cache hit null");
            return null ;
        }else {
            System.out.println("cache hit id");
        }
        return user;
    }

    private void cacheUser(User user, Integer id) {
        if(user != null){
            redisUtil.set(generateCacheKey(id), JSON.toJSONString(user), 10 + random.nextInt(5)) ;
        }else {
           //缓存穿透解决方案，防止每次请求都进入db
            redisUtil.set(generateCacheKey(id), JSON.toJSONString(nullUser), 10 + random.nextInt(5)) ;
        }
    }

    private User getUserFromCache(Integer id) {
        String user = (String)redisUtil.get(generateCacheKey(id));
        if (!StringUtils.isEmpty(user)){
            return JSON.parseObject(user, User.class) ;
        }
        return null ;
    }

    private String generateCacheKey(Integer id){
        return CACHE_PREFIX + id ;
    }
}
