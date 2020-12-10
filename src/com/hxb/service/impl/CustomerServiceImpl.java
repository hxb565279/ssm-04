package com.hxb.service.impl;


import com.hxb.dao.CustomerDao;
import com.hxb.po.Customer;
import com.hxb.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDao;

    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public Customer findCustomerById(Integer id) {
        return this.customerDao.findCustomerById(id);
    }

    @Override
    public List<Customer> selectAllCustomer() {
        return this.customerDao.selectAllCustomer();
    }

    @Override
    public int deleteCustomerById(Integer id) {
        return this.customerDao.deleteCustomerById(id);
    }

    @Override
    public int updateCustomer(Customer customer) {
        return this.customerDao.updateCustomer(customer);
    }

    @Override
    public int addCustomer(Customer customer) {
        return this.customerDao.addCustomer(customer);
    }

    @Override
    public List<Customer>  selectCustomer(Customer customer) {
        return this.customerDao.selectCustomer(customer);
    }
}
