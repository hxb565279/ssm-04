package com.hxb.service;


import com.hxb.po.User;

import java.util.List;

public interface UserService {
    User login(String username,String password);
    User login1(String username);
    int register1(String username,String password);
    User checkUser(String username);
    User checkUser1(String username);
   int update_password1(String username,String password);
   List<String> queryName(String username);
}
