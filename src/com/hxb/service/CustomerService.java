package com.hxb.service;

import com.hxb.po.Customer;

import java.util.List;

public interface CustomerService {
    Customer findCustomerById(Integer id);
    List<Customer> selectAllCustomer();

    int    deleteCustomerById(Integer id);
    int updateCustomer(Customer customer);
    int addCustomer(Customer customer);
   List<Customer> selectCustomer(Customer customer);
}
