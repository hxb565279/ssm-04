package com.hxb.controller;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.hxb.po.*;
import com.hxb.service.CustomerService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxb.common.utils.Page;
import com.hxb.po.BaseDict;
import com.hxb.service.BaseDictService;

/** 客户管理控制器类 */
@Controller
public class CustomerController1 {
	// 依赖注入
	@Autowired
	private CustomerService1 customerService;
	@Autowired
	private BaseDictService baseDictService;
	// 客户来源
//	@Value("${customer1.from.type}")
	private String FROM_TYPE="002";
	// 客户所属行业
//	@Value("${customer1.industry.type}")
	private String INDUSTRY_TYPE="001";
	// 客户级别
//	@Value("${customer1.level.type}")
	private String LEVEL_TYPE="006";
  /**
   * 客户列表
   *
   * @param page the page
   * @param rows the rows
   * @param custName the cust name
   * @param custSource the cust source
   * @param custIndustry the cust industry
   * @param custLevel the cust level
   * @param model the model
   * @return the string
   */
  @RequestMapping(value = "/customer/list.action")
  public String list(
      @RequestParam(defaultValue = "1") Integer page,
      @RequestParam(defaultValue = "10") Integer rows,
      String custName,
      String custSource,
      String custIndustry,
      String custLevel,
      Model model) {
		// 条件查询所有客户
		Page<Customer1> customers = customerService
				.findCustomerList(page, rows, custName, 
                                        custSource, custIndustry,custLevel);
		model.addAttribute("page", customers);
		// 客户来源
		List<BaseDict> fromType = baseDictService
				.findBaseDictByTypeCode(FROM_TYPE);
		// 客户所属行业
		List<BaseDict> industryType = baseDictService
				.findBaseDictByTypeCode(INDUSTRY_TYPE);
		// 客户级别
		List<BaseDict> levelType = baseDictService
				.findBaseDictByTypeCode(LEVEL_TYPE);
		// 添加参数
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		model.addAttribute("custName", custName);
		model.addAttribute("custSource", custSource);
		model.addAttribute("custIndustry", custIndustry);
		model.addAttribute("custLevel", custLevel);
		return "customer1";
	}

  /**
   * 创建客户
   *
   * @param customer the customer
   * @param session the session
   * @return the string
   */
  @RequestMapping("/customer/create.action")
  @ResponseBody
  public String customerCreate(Customer1 customer, HttpSession session) {
	    // 获取Session中的当前用户信息
	    User user = (User) session.getAttribute("USER_SESSION");
	    // 将当前用户id存储在客户对象中
//	    customer.setCust_create_id(user.getUser_id());

	    // 创建Date对象
	    Date date = new Date();
	    // 得到一个Timestamp格式的时间，存入mysql中的时间格式“yyyy/MM/dd HH:mm:ss”
	    Timestamp timeStamp = new Timestamp(date.getTime());
	    customer.setCust_createtime(timeStamp);
	    // 执行Service层中的创建方法，返回的是受影响的行数
	    int rows = customerService.createCustomer(customer);
	    if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}

  /**
   * 通过id获取客户信息
   *
   * @param id the id
   * @return the customer by id
   */
  @RequestMapping("/customer/getCustomerById.action")
  @ResponseBody
  public Customer1 getCustomerById(Integer id) {
	    Customer1 customer1 = customerService.getCustomerById(id);
	    return customer1;
	}
  /**
   * 更新客户
   *
   * @param customer the customer
   * @return the string
   */
  @RequestMapping("/customer/update.action")
  @ResponseBody
  public String customerUpdate(Customer1 customer) {
	    int rows = customerService.updateCustomer(customer);
	    if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}

  /**
   * 删除客户
   *
   * @param id the id
   * @return the string
   */
  @RequestMapping("/customer/delete.action")
  @ResponseBody
  public String customerDelete(Integer id) {
	    int rows = customerService.deleteCustomer(id);
	    if(rows > 0){			
	        return "OK";
	    }else{
	        return "FAIL";			
	    }
	}

}
