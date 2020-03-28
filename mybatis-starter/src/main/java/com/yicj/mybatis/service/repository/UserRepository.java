package com.yicj.mybatis.service.repository;

import com.yicj.mybatis.bean.User;

public interface UserRepository {

    User queryUserById(Integer id) ;
}
