package com.yicj.service;

import com.yicj.dao.OperationLogDao;
import com.yicj.dao.UserDao;
import com.yicj.domain.OperationLog;
import com.yicj.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private OperationLogDao operationLogDao;

    @Transactional
    public void addUser(String name){
        OperationLog log = new OperationLog();
        log.setContent("create user:"+name);
        operationLogDao.save(log);
        User user = new User();
        user.setName(name);
        userDao.save(user);
    }
}
