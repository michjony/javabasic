package com.michjony.basic.thinkingjava.allobject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloDate {
	public static void main(String[] args) {
		DateFormat sf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		System.out.println(sf.format(new Date()));
	}
}
