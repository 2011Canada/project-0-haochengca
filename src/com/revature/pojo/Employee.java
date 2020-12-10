package com.revature.pojo;

public class Employee {

	 private String employeenumber;
	 private String password;
	 private String username;
	public String getEmployeenumber() {
		return employeenumber;
	}
	public void setEmployeenumber(String employeenumber) {
		this.employeenumber = employeenumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Employee(String employeenumber, String password, String username) {
		super();
		this.employeenumber = employeenumber;
		this.password = password;
		this.username = username;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [employeenumber=" + employeenumber + ", password=" + password + ", username=" + username + "]";
	}
	
	 
	 
}
