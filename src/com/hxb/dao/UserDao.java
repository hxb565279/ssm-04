package com.hxb.dao;

import com.hxb.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    User login(@Param("username") String username, @Param("password") String password,@Param("status") String status);
    User login1(@Param("username") String username );
    int register1(@Param("username") String username,@Param("password") String password,@Param("id_card") String id_card,@Param("status") String status);
    User checkUser(@Param("username") String username);
    User checkId(@Param("id_card") String id_card);
    User checkUser1(@Param("username") String username);
    User checkUser2(@Param("username") String username,@Param("id_card") String id_card);
    int update_password1(@Param("username") String username,@Param("password") String password);
    List<String> queryName(@Param("username") String username);
    public User findUser(@Param("usercode") String usercode,
                         @Param("password") String password);

}
