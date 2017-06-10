package com.michjony.basic.thinkingjava.allobject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class ShowProperties {
	public static void main(String[] args) throws FileNotFoundException {
		System.getProperties().list(System.out);
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("user.dir"));
		System.out.println(System.getProperty("java.library.path"));
		String fileName = "property.txt";
		PrintStream out = new  PrintStream(new File(fileName));
		System.getProperties().list(out);
	}
}
