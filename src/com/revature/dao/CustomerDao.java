package com.revature.dao;

import com.revature.pojo.Customer;

public interface CustomerDao {
		// login
		public boolean login(Customer customer);
		//depositMoney
		public boolean depositMoney(Customer customer, double num);
		//drawMoney
		public boolean drawMoney(Customer customer, double num);
		//balance
		public double blance(Customer customer);
		//transfer
		public boolean transferAccount(Customer customer, Customer customer1, double num);
		
}
