package com.hxb.service;

import com.hxb.po.Customer;

import java.util.List;

/** The interface Customer service.
 * @author 和学博*/
public interface CustomerService {
  /**
   * Find customer by id customer.
   *
   * @param id the id
   * @return the customer
   */
  Customer findCustomerById(Integer id);

  /**
   * Select all customer list.
   *
   * @return the list
   */
  List<Customer> selectAllCustomer();

  /**
   * Delete customer by id int.
   *
   * @param id the id
   * @return the int
   */
  int deleteCustomerById(Integer id);

  /**
   * Update customer int.
   *
   * @param customer the customer
   * @return the int
   */
  int updateCustomer(Customer customer);

  /**
   * Add customer int.
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
