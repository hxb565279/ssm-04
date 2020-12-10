package com.hxb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
