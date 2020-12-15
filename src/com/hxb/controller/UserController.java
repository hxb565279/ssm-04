package com.hxb.controller;

import com.hxb.po.User;
import com.hxb.service.UserService;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** The type User controller. */
@Controller
public class UserController {
  @Autowired private UserService userService;
  /**
   * Login string.
   *
   * @param session the session
   * @param model the model
   * @param username the username
   * @param password the password
   * @param status the status
   * @return the string
   */
  @RequestMapping(value = "/login.action", method = RequestMethod.POST)
  public String login(
      HttpSession session, Model model, String username, String password, String status) {
    if (Objects.equals(username, "")
        || Objects.equals(password, "")
        || Objects.equals(status, "")) {
      model.addAttribute("msg1", "账号或密码为空或未选择权限");
      return "login1";
    } else {
      User user1 = this.userService.login1(username);
      if (user1 != null) {
        if (Objects.equals(user1.getUsername(), username)
            && Objects.equals(user1.getPassword(), password)) {
          if (Objects.equals(user1.getStatus(), status)) {
            if (Integer.parseInt(status) == 0) {
              session.setAttribute("USER_SESSION", user1);
              return "main1";
            } else if (Integer.parseInt(status) == 1) {
              session.setAttribute("USER_SESSION", user1);
              return "main2";
            } else {
              return "login1";
            }

          } else {
            model.addAttribute("msg2", "该权限下账户不存在,请核实重新选择");
            return "login1";
          }
        } else {
          model.addAttribute("msg1", "密码不对");
          return "login1";
        }
      } else {
        model.addAttribute("msg1", "该账户不存在,请注册");
        return "login1";
      }
    }
  }
  /**
   * Register 1 string.
   *
   * @param username the username
   * @param password the password
   * @param id_card the id card
   * @param status the status
   * @param model the model
   * @return the string
   */
  // 注册
  @RequestMapping(value = "/register.action", method = RequestMethod.POST)
  public String register1(
      String username, String password, String id_card, String status, Model model) {
    if (Objects.equals(username, "") || Objects.equals(password, "")) {
      model.addAttribute("msg2", "账号或密码为空");
      return "register1";
    } else {
      User user2 = this.userService.login1(username);
      if (user2 == null) {
        int num = this.userService.register1(username, password, id_card, status);
        if (num > 0) {
          model.addAttribute("msg1", "注册成功,请登录");
          return "redirect:toLogin";
        } else {
          model.addAttribute("msg2", "注册失败");
          return "register1";
        }
      } else {
        model.addAttribute("msg2", "该账户已经存在,请重新注册或登录");
        return "register1";
      }
    }
  }
  /**
   * Check user user.
   *
   * @param user the user
   * @return the user
   */
  // 检查用户名存在
  @RequestMapping(value = "/checkUser.action", method = RequestMethod.POST)
  @ResponseBody
  public User checkUser(@RequestBody User user) {
    System.out.println(user.getUsername());
    String username = user.getUsername();
    User user1 = this.userService.checkUser(username);
    if (user1 != null) {
      return user1;
    }
    return null;
  }
  /**
   * Check id user.
   *
   * @param user the user
   * @return the user
   */
  // 检查身份证存在
  @RequestMapping(value = "/checkId.action", method = RequestMethod.POST)
  @ResponseBody
  public User checkId(@RequestBody User user) {
    String card = user.getId_card();
    User user1 = this.userService.checkId(card);
    if (user1 != null) {
      return user1;
    }
    return null;
  }

  /**
   * To login string.
   *
   * @return the string
   */
  // 跳转登录
  @RequestMapping(value = "/toLogin", method = RequestMethod.GET)
  public String toLogin() {
    return "login1";
  }
  /**
   * To register string.
   *
   * @return the string
   */
  // 跳转注册
  @RequestMapping(value = "toRegister", method = RequestMethod.GET)
  public String toRegister() {
    return "register1";
  }
  /**
   * To password string.
   *
   * @return the string
   */
  // 跳转忘记密码
  @RequestMapping(value = "toPassword", method = RequestMethod.GET)
  public String toPassword() {
    return "password";
  }

  /**
   * Check user 1 string.
   *
   * @param user the user
   * @param session the session
   * @param model the model
   * @return the string
   */
  // 根据用户名返回密码
  @RequestMapping(value = "/checkUser1.action", method = RequestMethod.POST)
  public String checkUser1(User user, HttpSession session, Model model) {
    User user1 = this.userService.checkUser1(user.getUsername());
    if (user1 != null) {
      //          session.setAttribute("PASSWORD_SESSION",user1.getPassword());
      model.addAttribute("user", user1);
      return "log_password";
    }
    model.addAttribute("password", "查询失败");
    return "log_password";
  }
  /**
   * Check user 2 string.
   *
   * @param user the user
   * @param model the model
   * @return the string
   */
  // 根据用户名和身份证返回
  @RequestMapping(value = "/checkUser2.action", method = RequestMethod.POST)
  public String checkUser2(User user, Model model) {
    User user1 = this.userService.checkUser2(user.getUsername(), user.getId_card());
    if (user1 != null) {
      model.addAttribute("user2", user1);
      return "log_password";
    }
    model.addAttribute("password", "查询失败");
    return "log_password";
  }

  /**
   * Update password 1 string.
   *
   * @param username the username
   * @param password the password
   * @param model the model
   * @return the string
   */
  // 修改密码
  @RequestMapping(value = "/update_password1.action", method = RequestMethod.POST)
  public String update_password1(String username, String password, Model model) {
    int num = this.userService.update_password1(username, password);
    if (num > 0) {
      model.addAttribute("msg_update", username + "用户修改 成功");
      return "login1";
    }
    return "log_password";
  }

  /**
   * Logout string.
   *
   * @param session the session
   * @return the string
   */
  // 退出
  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public String logout(HttpSession session) {
    session.invalidate();
    return "login1";
  }

  /**
   * To customer string.
   *
   * @return the string
   */
  @RequestMapping(value = "/toCustomer", method = RequestMethod.GET)
  public String toCustomer() {
    return "customer1";
  }

  /**
   * Query name list.
   *
   * @param username the username
   * @return the list
   */
  // 自动填充
  @RequestMapping(value = "/queryName.action", method = RequestMethod.POST)
  @ResponseBody
  public List<String> queryName(String username) {
    return this.userService.queryName(username);
  }

  /**
   * To index string.
   *
   * @return the string
   */
  @RequestMapping(value = "/toIndex")
  public String toIndex() {
    return "index";
  }

  /**
   * To main 3 string.
   *
   * @return the string
   */
  @RequestMapping(value = "toMain3")
  public String toMain3() {
    return "main3";
  }

  @RequestMapping(value = "/selectAllUser")
  public String selectAllUser(Model model) {
    Map<Integer, User> map = new HashMap<>();
    for (User user1 : userService.selectAllUser()) {
      user1.setStatus(check(Integer.parseInt(user1.getStatus())));
      map.put(user1.getId(), user1);
    }
    model.addAttribute("user", map);
    return "addManager";
  }

  public String check(int status) {
    if (status == 0) {
      return "管理员";
    } else if (status == 1) {
      return "普通用户";
    }
    return "";
  }

  @RequestMapping(value = "/toMain1")
  public String toMain1() {
    return "main1";
  }

  @RequestMapping(value = "/manager1")
  @ResponseBody
  public String updateManager(Integer id, String status) {
    if (status.equals("管理员")) {
      int num1 = this.userService.updateManager1(id, status);
      if (num1 > 0) {
        return "OK";
      }else {
        return "FAIL";
      }
    } else  {
      int num2 = this.userService.updateManager2(id, status);
      if (num2 > 0) {
        return "OK";
      }else{
        return "FAIL";
      }

    }
  }

  @RequestMapping(value = "/selectManager")
  public String selectManager(String username,String id_card,String status,User user,Model model){

    Map<Integer,User> map = new HashMap<>();
    for (User user1 :  userService.selectManager(username,id_card,status)) {
      user1.setStatus(check(Integer.parseInt(user1.getStatus())));
      map.put(user1.getId(),user1);
    }
    model.addAttribute("user" ,map);
    return "addManager";
  }


}
