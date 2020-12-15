package com.hxb.dao;

import com.hxb.po.Customer;

import java.util.List;

/** Customer接口文件
 * @author 和学博*/
public interface CustomerDao {

  /**
   * 根据ID查询客户信息
   *
   * @param id the id
   * @return the customer
   */
  Customer findCustomerById(Integer id);

  /**
   * \ 全查询
   *
   * @return 列表 list
   */
  List<Customer> selectAllCustomer();

  /**
   * 根据id删除
   *
   * @param id the id
   * @return the int
   */
  int deleteCustomerById(Integer id);
  /**
   * 根据id修改
   *
   * @param customer the customer
   * @return the int
   */
  int updateCustomer(Customer customer);
  /**
   * 添加
   *
   * @param customer the customer
   * @return the int
   */
  int addCustomer(Customer customer);

  /**
   * Select customer list.
   *
   * @param customer the customer
   * @return the list
   */
  List<Customer> selectCustomer(Customer customer);



}
