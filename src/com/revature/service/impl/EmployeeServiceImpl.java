package com.revature.service.impl;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.dao.EmployeeDao;
import com.revature.dao.impl.EmployeeDaoImpl;
import com.revature.pojo.Customer;
import com.revature.pojo.Employee;
import com.revature.pojo.TransactionHistory;
import com.revature.service.EmployeeService;
import com.revature.util.MyUtil;

public class EmployeeServiceImpl implements EmployeeService{
	Scanner scanner = new Scanner(System.in);
	Employee employee;
	EmployeeDao edi = new EmployeeDaoImpl();
	Logger logger = org.apache.log4j.Logger.getLogger(EmployeeServiceImpl.class);
	

	@Override
	public void menu() {
		System.out.println("==========Employee System==========");
		System.out.println("***     1.Add customer          ***");
		System.out.println("***     2.Show customers        ***");
		System.out.println("***     3.Show customer by name ***");
		System.out.println("***     4.Show transactions     ***");
		System.out.println("***     5.Back to Main menu     ***");
		System.out.println("===================================");
		System.out.print("Please Choose:");
		String choose = scanner.next();
		switch (choose) {
		case "1":
			addCustomer();
			break;
		case "2":
			showCustomers();
			break;
		case "3":
			showCustomer();
			break;
		case "4":
			showTransactions();
			break;
		case "5":
			new BankServiceImpl().menu();
			return;
		default:
			System.out.println("Wrong input, please input again！");
			menu();
			break;
		}
		menu();
		
		
	}

	private void showTransactions() {
		List<TransactionHistory> transactionHistories= edi.showAllTransactions();
		for(TransactionHistory transactionHistory: transactionHistories) {
			System.out.println(transactionHistory.toString());
		}
	}

	private void showCustomer() {
		Customer customer;
		
		System.out.println("username:");
		String username = scanner.next();
		customer = edi.showCustomerByName(username);
		System.out.println(customer.toString());
	}

	@Override
	public void login() {
		employee = new Employee();
		System.out.println("username:");
		employee.setUsername(scanner.next());
		System.out.println("password:");
		employee.setPassword(scanner.next());
		if(edi.login(employee)) {
			System.out.println("login successfully!");
			logger.debug("employee "+employee.getUsername()+" login sucessfully!");
		}else {
			System.out.println("username or password wrong!");
			logger.debug("employee "+employee.getUsername()+" login failed!");
			new BankServiceImpl().menu();
		}
	}

	@Override
	public void addCustomer() {
		Customer customer = new Customer();
		customer.setCustomernumber(MyUtil.AutoNumber());
		System.out.print("input customer username:");
		customer.setCustomerusername(scanner.next());
		System.out.print("input password:");
		customer.setCustomerpwd(scanner.next());
		
		System.out.print("input initial balance:");
		String money = scanner.next();
		customer.setInitmoney(MyUtil.isnum(money));
		if (edi.addCustomer(customer)) {
			System.out.println("Add customer successfully！");
			logger.debug("customer " + customer.getCustomerusername()+ "is added successfully");
		} else {
			System.out.println("Add customer failed");
			logger.debug("customer " + customer.getCustomerusername()+ "is added failed");
		}
		;
		
	}

	@Override
	public void showCustomers() {
		List<Customer> customers = edi.showAll();
		for(Customer customer:customers) {
			System.out.println(customer.toString());
		}
		
	}


}
