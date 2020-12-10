package com.revature.service.impl;

import java.util.Scanner;

import com.revature.service.BankService;
import com.revature.service.CustomerService;
import com.revature.service.EmployeeService;

import com.revature.dao.BaseDao;

public class BankServiceImpl implements BankService {
	
	Scanner Scanner = new Scanner(System.in);
	
	@Override
	public void menu() {
		
		System.out.println("======My Bank System====");
		System.out.println("******   1.Employee ****");
		System.out.println("******   2.Customer ****");
		System.out.println("******   3.exit     ****");
		System.out.println("Please Choose:");
		String choose =Scanner.next();
		switch (choose) {
		case "1":
			EmployeeService employeeService = new EmployeeServiceImpl();
			employeeService.login();
			employeeService.menu();
			break;
		case "2":
			CustomerService customerService = new CustomerServiceImpl();
			customerService.login();
			customerService.menu();
		case "3":
			Scanner.close();
			new BaseDao().closeResource();
			return;
		default:
			System.out.println("Wrong input!Please try again!");
			menu();
			break;
		}
		
	}

	

}
