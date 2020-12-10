package com.revature.launcher;

import com.revature.service.impl.BankServiceImpl;

public class BankLauncher {
	public static void main(String[] args) {
		new BankServiceImpl().menu();
	}
}