package com.revature.dao;

import com.revature.pojo.Customer;

public interface CustomerDao {
		// 顾客登陆
		public boolean login(Customer customer);
		//存款
		public boolean depositMoney(Customer customer, double num);
		//取款
		public boolean drawMoney(Customer customer, double num);
		//查询余额
		public double blance(Customer customer);
		//转账
		public boolean transferAccount(Customer customer, Customer customer1, double num);
		
}
