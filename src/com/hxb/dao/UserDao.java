package com.hxb.dao;

import com.hxb.po.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * The interface User dao.
 *
 * @author 和学博
 */
public interface UserDao {
  /**
   * Login user.
   *
   * @param username the username
   * @param password the password
   * @param status the status
   * @return the user
   */
  User login(
      @Param("username") String username,
      @Param("password") String password,
      @Param("status") String status);

  /**
   * Login 1 user.
   *
   * @param username the username
   * @return the user
   */
  User login1(@Param("username") String username);

  /**
   * Register 1 int.
   *
   * @param username the username
   * @param password the password
   * @param id_card the id card
   * @param status the status
   * @return the int
   */
  int register1(
      @Param("username") String username,
      @Param("password") String password,
      @Param("id_card") String id_card,
      @Param("status") String status);

  /**
   * Check user user.
   *
   * @param username the username
   * @return the user
   */
  User checkUser(@Param("username") String username);

  /**
   * Check id user.
   *
   * @param id_card the id card
   * @return the user
   */
  User checkId(@Param("id_card") String id_card);

  /**
   * Check user 1 user.
   *
   * @param username the username
   * @return the user
   */
  User checkUser1(@Param("username") String username);

  /**
   * Check user 2 user.
   *
   * @param username the username
   * @param id_card the id card
   * @return the user
   */
  User checkUser2(@Param("username") String username, @Param("id_card") String id_card);

  /**
   * Update password 1 int.
   *
   * @param username the username
   * @param password the password
   * @return the int
   */
  int update_password1(@Param("username") String username, @Param("password") String password);

  /**
   * Query name list.
   *
   * @param username the username
   * @return the list
   */
  List<String> queryName(@Param("username") String username);

  /**
   * Select all user list.
   *
   * @return the list
   */
  List<User> selectAllUser();

  /**
   * Find user user.
   *
   * @param usercode the usercode
   * @param password the password
   * @return the user
   */
  public User findUser(@Param("usercode") String usercode, @Param("password") String password);

  /**
   * Update manager 1 int.
   *
   * @param id the id
   * @param status the status
   * @return the int
   */
  int updateManager1(@Param("id") Integer id, @Param("status") String status);

  /**
   * Update manager 2 int.
   *
   * @param id the id
   * @param status the status
   * @return the int
   */
  int updateManager2(@Param("id") Integer id, @Param("status") String status);

  /**
   * Select manager list.
   *
   * @param username the username
   * @param id_card the id card
   * @param status the status
   * @return the list
   */
  List<User> selectManager(
      @Param("username") String username,
      @Param("id_card") String id_card,
      @Param("status") String status);
}
