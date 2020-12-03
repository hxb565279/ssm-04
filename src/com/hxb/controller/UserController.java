package com.hxb.controller;


import com.hxb.po.User;
import com.hxb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;


@Controller
public class UserController {
    @Autowired
    private UserService userService;
//登录
    @RequestMapping(value = "/login.action", method = RequestMethod.POST)
    public String login(HttpSession session, Model model, String username, String password) {
        if (Objects.equals(username, "") || Objects.equals(password, "")) {
            model.addAttribute("msg1", "账号或密码为空");
            return "login1";
        } else {
            User user1 = this.userService.login1(username);
            if (user1 != null) {
                if (Objects.equals(user1.getUsername(), username) && Objects.equals(user1.getPassword(), password)) {
                    session.setAttribute("USER_SESSION", user1);
                    return "main";
                } else {
                    model.addAttribute("msg1", "密码错误");
                    return "login1";
                }
            } else {
                model.addAttribute("msg1", "该账户不存在,请注册");
                return "login1";
            }
        }

    }
//注册
    @RequestMapping(value = "/register.action", method = RequestMethod.POST)
    public String register1(String username, String password, Model model) {
        if (Objects.equals(username, "") || Objects.equals(password, "")) {
            model.addAttribute("msg2", "账号或密码为空");
            return "register1";
        } else {
            User user2 = this.userService.login1(username);
            if (user2 == null) {
                int num = this.userService.register1(username, password);
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
//检查用户名存在
    @RequestMapping(value = "/checkUser.action", method = RequestMethod.POST)
    @ResponseBody
    public User checkUser( @RequestBody User user) {
        System.out.println(user.getUsername());
        String username= user.getUsername();
        User user1 = this.userService.checkUser(username);
        if (user1 != null) {
            return user1;
        }
        return null;
    }

//跳转登录
    @RequestMapping(value = "/toLogin", method = RequestMethod.GET)
    public String toLogin() {
        return "login1";
    }
//跳转注册
    @RequestMapping(value = "toRegister", method = RequestMethod.GET)
    public String toRegister() {
        return "register1";
    }
//跳转忘记密码
    @RequestMapping(value = "toPassword", method = RequestMethod.GET)
    public String toPassword() {
        return "password";
    }

 //根据用户名返回密码
    @RequestMapping(value = "/checkUser1.action",method = RequestMethod.POST)
    public String checkUser1(User user,HttpSession session,Model model){
      User  user1=  this.userService.checkUser1(user.getUsername());
      if (user1!=null){
//          session.setAttribute("PASSWORD_SESSION",user1.getPassword());
          model.addAttribute("user",user1);
          return "password";
      }
      model.addAttribute("password","查询失败");
      return "password";
    }

    //修改密码
    @RequestMapping(value = "/update_password1.action",method = RequestMethod.POST)
    public String update_password1(String username,String password,Model model){
       int num= this.userService.update_password1(username,password);
       if (num>0){
           model.addAttribute("msg_update",username+"用户修改 成功");
            return "login1";
       }
       return "password";
    }

    //自动填充
    @RequestMapping(value = "/queryName.action" ,method = RequestMethod.POST)
    @ResponseBody
    public List<String> queryName(String username){
        return this.userService.queryName(username);
    }

}
