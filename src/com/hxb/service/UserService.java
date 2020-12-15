package com.hxb.service;


import com.hxb.po.User;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/** The interface User service. */
public interface UserService {
  /**
   * Login user.
   *
   * @param username the username
   * @param password the password
   * @param status the status
   * @return the user
   */
  User login(String username, String password, String status);

  /**
   * Login 1 user.
   *
   * @param username the username
   * @return the user
   */
  User login1(String username);

  /**
   * Register 1 int.
   *
   * @param username the username
   * @param password the password
   * @param id_card the id card
   * @param status the status
   * @return the int
   */
  int register1(String username, String password, String id_card, String status);

  /**
   * Check user user.
   *
   * @param username the username
   * @return the user
   */
  User checkUser(String username);

  /**
   * Check user 1 user.
   *
   * @param username the username
   * @return the user
   */
  User checkUser1(String username);

  /**
   * Check user 2 user.
   *
   * @param username the username
   * @param id_card the id card
   * @return the user
   */
  User checkUser2(String username, String id_card);

  /**
   * Check id user.
   *
   * @param id_card the id card
   * @return the user
   */
  User checkId(String id_card);

  /**
   * Update password 1 int.
   *
   * @param username the username
   * @param password the password
   * @return the int
   */
  int update_password1(String username, String password);

  /**
   * Query name list.
   *
   * @param username the username
   * @return the list
   */
  List<String> queryName(String username);
  /**
   * Find user user.
   *
   * @param usercode the usercode
   * @param password the password
   * @return the user
   */
  // 通过账号和密码查询用户
  public User findUser(String usercode, String password);

  /**
   * Select all user user.
   *
   * @return the user
   */
  List<User> selectAllUser();

  /**
   * Update manager 1 int.
   *
   * @param id the id
   * @param status the status
   * @return the int
   */
  int updateManager1(Integer id, String status);

  /**
   * Update manager 2 int.
   *
   * @param id the id
   * @param status the status
   * @return the int
   */
  int updateManager2(Integer id, String status);

  /**
   * Select manager user.
   *
   * @param username the username
   * @param id_card the id card
   * @param status the status
   * @return the user
   */
 List< User> selectManager(String username, String id_card, String status);
}
