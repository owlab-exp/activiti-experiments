package com.owlab.activiti.rest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateTest {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		
		TimeZone tz = TimeZone.getTimeZone("UTC");
		//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"); //yyyy-MM-dd'T'HH:mm:ss.SSS'Z
		//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz"); //yyyy-MM-dd'T'HH:mm:ss.SSS'Z
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		System.out.println(dateFormat.format(date));
		
		
		dateFormat.setTimeZone(tz);
		System.out.println(dateFormat.format(date));

		
	}

}
