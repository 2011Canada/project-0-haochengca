package com.revature.dao;

import java.util.List;


import com.revature.pojo.Customer;
import com.revature.pojo.Employee;
import com.revature.pojo.TransactionHistory;

public interface EmployeeDao {
	/**
	 * login
	 * 
	 * @param administrator
	 *            
	 * @return
	 */
	public boolean login(Employee employee);

	/**
	 * add user
	 * @param customer
	 * @return
	 */
	public boolean addCustomer(Customer customer);

	

	/**
	 * show all customers
	 * @return
	 */
	public List<Customer> showAll();
	
	/**
	 * show user by username
	 * @param string username
	 * @return Customer
	 */
	public Customer showCustomerByName(String username);
	
	/**
	 * show all transactions
	 * @param 
	 * @return transactions list
	 */
	
	public List<TransactionHistory> showAllTransactions();
	
}
