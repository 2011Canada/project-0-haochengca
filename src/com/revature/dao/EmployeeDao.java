package com.revature.dao;

import java.util.List;

import com.revature.pojo.Customer;
import com.revature.pojo.Employee;

public interface EmployeeDao {
	/**
	 * login
	 * 登陆
	 * @param administrator
	 *            administeator info
	 * @return
	 */
	public boolean login(Employee employee);

	/**
	 * 增加用户
	 * @param customer
	 * @return
	 */
	public boolean addCustomer(Customer customer);

	/**
	 * 计算总金额
	 * @return
	 */
	public Double totalMoney();

	/**
	 * 返回富豪排行榜
	 * @return
	 */
	public List<Customer> showAll();
}
