package com.hxb.service.impl;

import com.hxb.dao.UserDao;
import com.hxb.po.User;
import com.hxb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User login(String username, String password) {
        return this.userDao.login(username,password);
    }

    @Override
    public User login1(String username) {
        return this.userDao.login1(username);
    }

    @Override
    public int register1(String username, String password) {
        return this.userDao.register1(username,password);
    }

    @Override
    public User checkUser(String username) {
        return this.userDao.checkUser(username);
    }

    @Override
    public User checkUser1(String username) {
        return this.userDao.checkUser1(username);
    }

    @Override
    public int update_password1(String username,String password) {
        return this.userDao.update_password1(username,password);
    }

    @Override
    public List<String> queryName(String username) {
        return this.userDao.queryName(username);
    }


}
