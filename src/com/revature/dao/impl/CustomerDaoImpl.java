package com.revature.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.BaseDao;
import com.revature.dao.CustomerDao;
import com.revature.pojo.Customer;
import com.revature.util.MyUtil;

public class CustomerDaoImpl extends BaseDao implements CustomerDao{
	private ResultSet rs;
	String sql;
	Logger Logger = org.apache.log4j.Logger.getLogger(CustomerDaoImpl.class);

	@Override
	public boolean login(Customer customer) {
		boolean flag = false;
		sql = "select * from CUSTOMER where customerusername = ? and customerpwd =?";
		rs = executeQuery(sql, customer.getCustomerusername(), customer.getCustomerpwd());
		try {
			if (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean depositMoney(Customer customer, double num) {
		boolean flag = false;
		sql = "update CUSTOMER set initmoney =initmoney+? where customerusername = ?";
		flag = executeUpdate(sql, num, customer.getCustomerusername());
		return flag;
	}

	@Override
	public boolean drawMoney(Customer customer, double num) {
		boolean flag = false;
		if (blance(customer) >= num) {
			sql = "update CUSTOMER set initmoney =initmoney-? where customerusername = ?";
			flag = executeUpdate(sql, num, customer.getCustomerusername());
		} else {
			System.out.println("Insufficient funds");
			Logger.debug(customer.getCustomerusername() + " withdraw " +num+ " failed!");
		}
		return flag;
	}

	@Override
	public double blance(Customer customer) {
		double blance = 0;
		sql = "select initmoney from CUSTOMER where customerusername = ?";
		rs = executeQuery(sql, customer.getCustomerusername());
		try {
			while (rs.next()) {
				blance = rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blance;
	}

	@Override
	public boolean transferAccount(Customer customer, Customer customer1, double num) {
		boolean flag = false;
		if (exitsuser(customer1)) {
			if (blance(customer) >= num) {
				drawMoney(customer, num);
				depositMoney(customer1, num);
				sql = "insert into transactionhistory(customerusername,customerusername1,transactionid,amount) values(?,?,?,?)";
				flag = executeUpdate(sql, customer.getCustomerusername(), customer1.getCustomerusername(), MyUtil.AutoNumber(),num);
				flag = true;
			} else {
				System.out.println("Insufficient funds！");
				Logger.debug(customer.getCustomerusername() + " transfer " +num+ " to " + customer1.getCustomerusername()+ " failed! Insufficient funds！");
			}
		} else {
			System.out.println("User not exist!");
			Logger.debug(customer.getCustomerusername() + " transfer " +num+ " to " + customer1.getCustomerusername()+ " failed! User not exist！");
		}
		return flag;
		
	}
	
	public boolean exitsuser(Customer customer) {
		boolean flag = false;
		sql = "select initmoney from CUSTOMER where customerusername = ?";
		rs = executeQuery(sql, customer.getCustomerusername());
		try {
			if (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
