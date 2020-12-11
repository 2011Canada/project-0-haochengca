package com.revature.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.BaseDao;
import com.revature.dao.EmployeeDao;
import com.revature.pojo.Customer;
import com.revature.pojo.Employee;
import com.revature.pojo.TransactionHistory;

public class EmployeeDaoImpl extends BaseDao implements EmployeeDao {
	private ResultSet resultSet;
	String sql;

	@Override
	public boolean login(Employee employee) {
		boolean flag = false;
		sql = "select * from employee where username=? and password=?";
		resultSet = executeQuery(sql, employee.getUsername(), employee.getPassword());
		try {
			if (resultSet.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean addCustomer(Customer customer) {

		boolean flag;
		sql = "insert into CUSTOMER(customernumber,customerusername,customerpwd,initmoney) values(?,?,?,?)";
		flag = executeUpdate(sql, customer.getCustomernumber(), customer.getCustomerusername(), customer.getCustomerpwd(),
				customer.getInitmoney());
		return flag;
	}

	

	@Override
	public List<Customer> showAll() {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		sql = "select * from CUSTOMER order by initmoney desc";
		resultSet = executeQuery(sql);
		try {
			while (resultSet.next()) {
				Customer customer = new Customer();
				customer.setCustomernumber(resultSet.getString(1));
				customer.setCustomerusername(resultSet.getString(2));
				customer.setCustomerpwd(resultSet.getString(3));
				customer.setInitmoney(resultSet.getDouble(4));
				customers.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	@Override
	public Customer showCustomerByName(String username) {
		Customer customer =new Customer();
		sql = "select * from CUSTOMER where customerusername = ?";
		resultSet = executeQuery(sql,username);
		try {
			while (resultSet.next()) {
				
				// CUSTNUMBER,CUSTNAME,CUSPWD,CUSTIDCARD,CUSTMONEY,CUSDATE
				customer.setCustomernumber(resultSet.getString(1));
				customer.setCustomerusername(resultSet.getString(2));
				customer.setCustomerpwd(resultSet.getString(3));
				customer.setInitmoney(resultSet.getDouble(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
		
	}

	@Override
	public List<TransactionHistory> showAllTransactions() {
		ArrayList<TransactionHistory> TransactionHistorys = new ArrayList<>();
		sql = "select * from transactionhistory order by transactionid asc";
		resultSet = executeQuery(sql);
		try {
			while (resultSet.next()) {
				TransactionHistory transactionHistory = new TransactionHistory();
				transactionHistory.setCustomerusername(resultSet.getString(1));
				transactionHistory.setCustomerusername1(resultSet.getString(2));
				transactionHistory.setTransactionid(resultSet.getString(3));
				transactionHistory.setAmount(resultSet.getDouble(4));
				TransactionHistorys.add(transactionHistory);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return TransactionHistorys;
	}

}
