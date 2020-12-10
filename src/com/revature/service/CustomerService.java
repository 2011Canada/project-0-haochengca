package com.revature.service;

public interface CustomerService {
	/**
	 * 菜单 对顾客登陆、存款、取款、查询余额、转账、修改密码界面的输入和显示
	 */
	public void menu() ;
	/**
	 * 用户登录
	 */
	public void login();
	/**
	 * 存款
	 */
	public void depositMoney();
	/**
	 * 取款
	 */
	public void drawMoney();
	/**
	 * 查询余额
	 */
	public void checkblance();
	
	/**
	 * 转账
	 */
	public void transferAccount();
	
}
