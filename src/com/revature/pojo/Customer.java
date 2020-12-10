package com.revature.pojo;

import java.sql.Date;

public class Customer {
	private String customernumber;
	private String customerusername;
	private String customerpwd;
	private double initmoney;
	public String getCustomernumber() {
		return customernumber;
	}
	public void setCustomernumber(String customernumber) {
		this.customernumber = customernumber;
	}
	
	public String getCustomerusername() {
		return customerusername;
	}
	public void setCustomerusername(String customerusername) {
		this.customerusername = customerusername;
	}
	public String getCustomerpwd() {
		return customerpwd;
	}
	public void setCustomerpwd(String customerpwd) {
		this.customerpwd = customerpwd;
	}
	public double getInitmoney() {
		return initmoney;
	}
	public void setInitmoney(double initmoney) {
		this.initmoney = initmoney;
	}
	public Customer(String customernumber, String customername, String customerpwd, double initmoney) {
		super();
		this.customernumber = customernumber;
		this.customerusername = customername;
		this.customerpwd = customerpwd;
		this.initmoney = initmoney;
	}
	public Customer() {
		super();
	}
	@Override
	public String toString() {
		return "Customer [customernumber=" + customernumber + ", customerusername=" + customerusername + ", money=" + initmoney + "]";
	}
	
	
	
}
