package com.hxb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 和学博
 */
@Controller
public class indexController {
    @RequestMapping(value = "/toPerson1")
    public String toPerson1(){
        return "person1";
    }
    @RequestMapping(value ="/toPeron2")
    public String toPerson2(){
        return "person2";
    }
    @RequestMapping(value = "/toPerson3")
   public String toPerson3(){
        return "person3";
    }


    @RequestMapping(value = "/toAddManager")
    public String toManager(){
        return "addManager";
    }
   @RequestMapping(value = "/toCustomer1")
    public String toCustomer1(){
        return "customer1";
   }

}
