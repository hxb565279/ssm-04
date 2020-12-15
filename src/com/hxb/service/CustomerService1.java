package com.hxb.service;

import com.hxb.common.utils.Page;
import com.hxb.po.Customer1;

public interface CustomerService1 {
  // 查询客户列表
  public Page<Customer1> findCustomerList(
      Integer page,
      Integer rows,
      String custName,
      String custSource,
      String custIndustry,
      String custLevel);

  public int createCustomer(Customer1 customer);

  // 通过id查询客户
  public Customer1 getCustomerById(Integer id);
  // 更新客户
  public int updateCustomer(Customer1 customer);
  // 删除客户
  public int deleteCustomer(Integer id);
}
