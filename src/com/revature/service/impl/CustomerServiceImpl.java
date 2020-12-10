package com.revature.service.impl;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.dao.CustomerDao;
import com.revature.dao.impl.CustomerDaoImpl;
import com.revature.pojo.Customer;
import com.revature.service.CustomerService;
import com.revature.util.MyUtil;

public class CustomerServiceImpl implements CustomerService{
	Customer customer;
	Scanner scanner = new Scanner(System.in);
	CustomerDao cdi = new CustomerDaoImpl();
	Logger logger = Logger.getLogger(CustomerServiceImpl.class);
	
	@Override
	public void menu() {
		System.out.println("========Customer System========");
		System.out.println("*********1.Deposite   ********");
		System.out.println("*********2.Withdraw   ********");
		System.out.println("*********3.Balance    ********");
		System.out.println("*********4.Transfer   ********");
		System.out.println("*********5.Return to Main ****");
		System.out.println("===============================");
		System.out.print("Please choose:");
		String choose = scanner.next();
		switch (choose) {
		case "1":
			depositMoney();
			break;
		case "2":
			drawMoney();
			break;
		case "3":
			checkblance();
			break;
		case "4":
			transferAccount();
			break;
		case "5":
			new BankServiceImpl().menu();
		default:
			System.out.println("Wrong input, please input again!");
			menu();
			break;
		}
		menu();
		
	}

	@Override
	public void login() {
		customer = new Customer();
		System.out.println("username:");
		customer.setCustomerusername(scanner.next());
		System.out.println("password:");
		customer.setCustomerpwd(scanner.next());
		if(cdi.login(customer)) {
			System.out.println("login successfully!");
			logger.debug(customer.getCustomerusername()+" login successful!");
		}else {
			System.out.println("username or password wrong!");
			logger.debug(customer.getCustomerusername()+" login failed!");
			new BankServiceImpl().menu();
		}
	}

	@Override
	public void depositMoney() {
		System.out.print("input the deposit amount:");
		String num = scanner.next();
		if (cdi.depositMoney(customer, MyUtil.isnum(num))) {
			System.out.println("Deposit done！");
			logger.debug(customer.getCustomerusername() + " deposit " + num + " sucessful");
		} else {
			logger.debug(customer.getCustomerusername() + " deposit " + num + " failed");
		}
		checkblance();
		
	}

	@Override
	public void drawMoney() {
		System.out.print("input the withdraw amount:");
		String num = scanner.next();
		if (cdi.drawMoney(customer, MyUtil.isnum(num))) {
			System.out.println("WithDraw sucessfully");
			logger.debug(customer.getCustomerusername()+" withdraw "+ num +" sucessfully!");
		}
		checkblance();
	}

	@Override
	public void checkblance() {
		System.out.println("your balance is "+cdi.blance(customer));
		
	}

	@Override
	public void transferAccount() {
		Customer customer1 = new Customer();
		System.out.print("input payee:");
		customer1.setCustomerusername(scanner.next());
		System.out.print("input amount:");
		String num = scanner.next();
		if (cdi.transferAccount(customer, customer1, MyUtil.isnum(num))) {
			System.out.println("transfer sucessfully!");
			logger.debug(customer.getCustomerusername() + " transfer " +num+ " to " + customer1.getCustomerusername()+ " sucessfully！");
		} else {
			System.out.println("transfer failed");
			logger.debug(customer.getCustomerusername() + " transfer " +num+ " to " + customer1.getCustomerusername()+ " failed！");
		}
		checkblance();
		
	}

	

}
