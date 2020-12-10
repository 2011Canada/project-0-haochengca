package com.revature.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.BaseDao;
import com.revature.dao.EmployeeDao;
import com.revature.pojo.Customer;
import com.revature.pojo.Employee;

public class EmployeeDaoImpl extends BaseDao implements EmployeeDao {
	private ResultSet resultSet;
	String sql;

	@Override
	public boolean login(Employee employee) {
		boolean flag = false;
		sql = "select * from employee where username=? and password=?";
		resultSet = super.executeQuery(sql, employee.getUsername(), employee.getPassword());
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
	public Double totalMoney() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> showAll() {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		sql = "select * from CUSTOMER order by initmoney desc";
		resultSet = executeQuery(sql);
		try {
			while (resultSet.next()) {
				Customer customer = new Customer();
				// CUSTNUMBER,CUSTNAME,CUSPWD,CUSTIDCARD,CUSTMONEY,CUSDATE
				customer.setCustomernumber(resultSet.getString(1));
				customer.setCustomerusername(resultSet.getString(2));
				customer.setCustomerpwd(resultSet.getString(3));
				customer.setInitmoney(resultSet.getDouble(4));
				customers.add(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customers;
	}

}
