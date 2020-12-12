package com.revature.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class MyUtil {
	
	
	public static String AutoNumber() {
		// Calendar calendar =Calendar.getInstance();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yymmddhhmmss");
		Math.random();
		String num = getdate() + String.valueOf((int) (Math.random() * 10));
		return num;
	}
	
	public static String getdate() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String date = simpleDateFormat.format(calendar.getTime());
		return date;
	}

	
	public static double isnum(String num) {
		boolean flag = true;
		for (int i = 0; i < num.length(); i++) {
			if (!Character.isDigit(num.charAt(i))) {
				flag = false;
			}
		}
		double temp = 0;
		if (flag) {
			temp = Double.parseDouble(num);
		} else {
			System.out.println("输入有误");
		}
		return temp;
	}
	
	public static String dateformat(Date date){
		DateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		return sdf.format(date);
		
	}

}
