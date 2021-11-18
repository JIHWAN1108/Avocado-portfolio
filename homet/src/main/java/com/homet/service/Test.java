package com.homet.service;

import java.sql.Timestamp;
import java.util.Calendar;

public class Test {
	public static void main(String[] args) {
		
	long retryDate = System.currentTimeMillis();
	int time = 1;
	Timestamp original = new Timestamp(retryDate);
	Calendar cal = Calendar.getInstance();
	cal.setTimeInMillis(original.getTime()); 
	cal.add(Calendar.DATE, time);
	Timestamp later = new Timestamp(cal.getTime().getTime()); 
	System.out.println(original); 
	System.out.println(later);

	}
}
