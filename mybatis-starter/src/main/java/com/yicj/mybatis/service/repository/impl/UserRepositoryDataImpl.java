package com.yicj.mybatis.service.repository.impl;

import com.yicj.mybatis.bean.User;
import com.yicj.mybatis.mapper.UserMapper;
import com.yicj.mybatis.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryDataImpl implements UserRepository {

    @Autowired
    private UserMapper userMapper ;

    @Override
    public User queryUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
