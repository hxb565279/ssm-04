package com.hxb.dao;

import com.hxb.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    User login(@Param("username") String username, @Param("password") String password);
    User login1(@Param("username") String username );
    int register1(@Param("username") String username,@Param("password") String password);
    User checkUser(@Param("username") String username);
    User checkUser1(@Param("username") String username);
    int update_password1(@Param("username") String username,@Param("password") String password);
    List<String> queryName(@Param("username") String username);


}
