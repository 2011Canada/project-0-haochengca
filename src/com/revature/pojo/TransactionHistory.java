package com.revature.pojo;

public class TransactionHistory {
	private String customerusername;
	private String customerusername1;
	private String transactionid;
	private double amount;
	public String getCustomerusername() {
		return customerusername;
	}
	public void setCustomerusername(String customerusername) {
		this.customerusername = customerusername;
	}
	public String getCustomerusername1() {
		return customerusername1;
	}
	public void setCustomerusername1(String customerusername1) {
		this.customerusername1 = customerusername1;
	}
	public String getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public TransactionHistory(String customerusername, String customerusername1, String transactionid, double amount) {
		super();
		this.customerusername = customerusername;
		this.customerusername1 = customerusername1;
		this.transactionid = transactionid;
		this.amount = amount;
	}
	public TransactionHistory() {
		super();
	}
	@Override
	public String toString() {
		return "TransactionHistory customerusername:" + customerusername + ", transfer to customerusername1:" + customerusername1
				+  ", amount is " + amount ;
	}
	
	

}
