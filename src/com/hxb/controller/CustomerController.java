package com.hxb.controller;


import com.hxb.po.Customer;
import com.hxb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 和学博
 */
@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    /**
     * 根据ID查询客户详情
     */
    @RequestMapping("/findCustomerById")
    public String findCustomerById(Integer id, Model model) {
        Customer customer = this.customerService.findCustomerById(id);
        model.addAttribute("customer", customer);

        //返回客户页面展示
        return "customer";
    }

    @RequestMapping(value = "getCustomer")
    @ResponseBody
    public Customer getCustomer(Integer id) {
        return this.customerService.findCustomerById(id);
    }

    @RequestMapping(value = "/toCustomer")
    public String toCustomer() {
        return "customer";
    }

    @RequestMapping(value = "/updateCustomer1")
    @ResponseBody
    public String updateCustomer1(Customer customer) {
        int num = this.customerService.updateCustomer(customer);
        if (num > 0) {
            return "OK";
        } else {
            return "FAIL";
        }
    }


    /**
     * 全查询
     *
     * @param model
     * @return
     */
    @RequestMapping("/selectAllCustomer")
    public String selectAllCustomer(Model model) {
        Map<Integer, Customer> map = new HashMap<>();
        for (Customer customer : customerService.selectAllCustomer()) {
            map.put(customer.getId(), customer);
        }
        model.addAttribute("customer", map);
        return "customer";
    }

    @RequestMapping("/selectCustomer")
    public String selectCustomer(Customer customer,Model model){
        Map<Integer,Customer> map = new HashMap<>();
        for (Customer customer1: customerService.selectCustomer(customer)){
            map.put(customer1.getId(),customer1);
        }
        model.addAttribute("customer",map);
        return "customer";
    }
    @RequestMapping("/selectCustomer2")
    public String selectCustomer1(Customer customer,Model model){
        Map<Integer,Customer> map = new HashMap<>();
        for (Customer customer1: customerService.selectCustomer(customer)){
            map.put(customer1.getId(),customer1);
        }
        model.addAttribute("customer",map);
        return "person2";
    }


    @RequestMapping("/selectCustomer1")
    public String selectCustomer1(Model model){
        Map<Integer,Customer> map = new HashMap<>();
        for (Customer customer1: customerService.selectAllCustomer()){
            map.put(customer1.getId(),customer1);
        }
        model.addAttribute("customer",map);
        return "person2";
    }

    /**
     * 根据id 删除
     */
    @RequestMapping(value = "/deleteCustomerById")
    public String deleteCustomerById(Integer id, Model model) {
        int num = this.customerService.deleteCustomerById(id);
        if (num > 0) {
            model.addAttribute("msg", "删除成功");

        } else {
            model.addAttribute("msg", "删除失败");
        }
        return "customer";
    }

    @RequestMapping(value = "/deleteCustomer")
    @ResponseBody
    public String deleteCustomer(Integer id) {
        int num = this.customerService.deleteCustomerById(id);
        if (num > 0) {
            return "OK";
        } else {
            return "FAIL";
        }
    }


    /**
     * 根据id更新
     */
    @RequestMapping(value = "/updateCustomerById")
    public String updateCustomerById(Customer customer, Model model) {
        int num = this.customerService.updateCustomer(customer);
        if (num > 0) {
            model.addAttribute("msg1", "更新成功");
        } else {
            model.addAttribute("msg1", "更新失败");
        }
        return "customer";
    }

    /**
     * 添加
     */

    @RequestMapping(value = "/addCustomer")
    @ResponseBody
    public String addCustomer(Customer customer) {
        int num = this.customerService.addCustomer(customer);
        if (num > 0) {
            return "OK";
        } else {
            return "FAIL";
        }

    }



}
