package com.hxb.service;


import com.hxb.po.User;

import java.util.List;

public interface UserService {
    User login(String username,String password,String status);
    User login1(String username);
    int register1(String username,String password,String id_card,String status);
    User checkUser(String username);
    User checkUser1(String username);
    User checkUser2(String username,String id_card);
    User checkId(String id_card);
   int update_password1(String username,String password);
   List<String> queryName(String username);
    // 通过账号和密码查询用户
    public User findUser(String usercode,String password);
}
