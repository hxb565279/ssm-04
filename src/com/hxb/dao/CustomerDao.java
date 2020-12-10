package com.hxb.dao;

import com.hxb.po.Customer;

import java.util.List;

/**
    Customer接口文件
   */
public interface CustomerDao {


/**
 * 根据ID查询客户信息
 */
Customer findCustomerById(Integer id);

    /**\
     * 全查询
     * @return 列表
     */
    List<Customer> selectAllCustomer();

    /**
     * 根据id删除
     */
      int deleteCustomerById(Integer id);
    /**
     * 根据id修改
     */
     int updateCustomer(Customer customer);
    /**
     * 添加
     */
    int   addCustomer(Customer customer);

    List<Customer> selectCustomer(Customer customer);
}
