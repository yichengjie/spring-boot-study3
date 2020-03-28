package com.yicj.mybatis.service.impl;

import com.yicj.mybatis.bean.User;
import com.yicj.mybatis.service.UserQueryService;
import com.yicj.mybatis.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserQueryServiceImpl implements UserQueryService {

    @Autowired
    @Qualifier("userRepositoryCacheImpl")
    private UserRepository userRepository ;

    @Override
    public User queryUserById(Integer id) {
        return userRepository.queryUserById(id);
    }
}
