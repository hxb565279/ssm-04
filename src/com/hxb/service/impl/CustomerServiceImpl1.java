package com.hxb.service.impl;
import java.util.List;

import com.hxb.common.utils.Page;

import com.hxb.dao.CustomerDao1;
import com.hxb.po.Customer;
import com.hxb.po.Customer1;
import com.hxb.service.CustomerService1;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 客户管理
 */
@Service("customerService")
@Transactional
public class CustomerServiceImpl1 implements CustomerService1 {
	// 声明DAO属性并注入
	@Autowired
	private CustomerDao1 customerDao1;
	// 客户列表
	@Override
	public Page<Customer1> findCustomerList(Integer page, Integer rows,
											String custName, String custSource, String custIndustry,
											String custLevel) {
		// 创建客户对象
         Customer1 customer1 = new Customer1();
		// 判断客户名称
		if(StringUtils.isNotBlank(custName)){
			customer1.setCust_name(custName);
		}
		// 判断客户信息来源
		if(StringUtils.isNotBlank(custSource)){
			customer1.setCust_source(custSource);
		}
		// 判断客户所属行业
		if(StringUtils.isNotBlank(custIndustry)){
			customer1.setCust_industry(custIndustry);
		}
		// 判断客户级别
		if(StringUtils.isNotBlank(custLevel)){
			customer1.setCust_level(custLevel);
		}
		// 当前页
		customer1.setStart((page-1) * rows) ;
		// 每页数
		customer1.setRows(rows);
		// 查询客户列表
		List<Customer1> customers =
                            customerDao1.selectCustomerList(customer1);
		// 查询客户列表总记录数
		Integer count = customerDao1.selectCustomerListCount(customer1);
		// 创建Page返回对象
		Page<Customer1> result = new Page<>();
		result.setPage(page);
		result.setRows(customers);
		result.setSize(rows);
		result.setTotal(count);
		return result;
	}


	/**
	 * 创建客户
	 */
	@Override
	public int createCustomer(Customer1 customer1) {
	    return customerDao1.createCustomer(customer1);
	}
	/**
	 * 通过id查询客户
	 */
	@Override
	public Customer1 getCustomerById(Integer id) {
	    Customer1 customer1 = customerDao1.getCustomerById(id);
	    return customer1;
	}


	/**
	 * 更新客户
	 */
	@Override
	public int updateCustomer(Customer1 customer1) {
	    return customerDao1.updateCustomer(customer1);
	}
	/**
	 * 删除客户
	 */
	@Override
	public int deleteCustomer(Integer id) {
	    return customerDao1.deleteCustomer(id);
	}

	
}
