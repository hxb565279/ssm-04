package com.hxb.dao;
import java.util.List;
import com.hxb.po.Customer1;

/** Customer接口 */
public interface CustomerDao1 {
  /**
   * Select customer list list.
   *
   * @param customer the customer
   * @return the list
   */
  // 客户列表
  public List<Customer1> selectCustomerList(Customer1 customer);
  /**
   * Select customer list count integer.
   *
   * @param customer the customer
   * @return the integer
   */
  // 客户数
  public Integer selectCustomerListCount(Customer1 customer);

  /**
   * Create customer int.
   *
   * @param customer the customer
   * @return the int
   */
  // 创建客户
  public int createCustomer(Customer1 customer);
  /**
   * Gets customer by id.
   *
   * @param id the id
   * @return the customer by id
   */
  // 通过id查询客户
  public Customer1 getCustomerById(Integer id);
  /**
   * Update customer int.
   *
   * @param customer the customer
   * @return the int
   */
  // 更新客户信息
  public int updateCustomer(Customer1 customer);
  /**
   * Delete customer int.
   *
   * @param id the id
   * @return the int
   */
  // 删除客户
  int deleteCustomer(Integer id);
}
