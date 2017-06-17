package com.michjony.basic.thinkingjava.reuse;

public class Bettle extends Insect {
	private static int x2 = printInit("static Bettle.x2 initialized ");

	public static void main(String[] args) {
		System.out.println("Bettle constructor");
	}
}

class Insect {
	private int i = 9;
	protected int j;

	Insect() {
		System.out.println("i = " + i + ",j = " + j);
		j = 39;
	}

	private static int x1 = printInit("static Insect.x1 initialized ");

	static int printInit(String s) {
		System.out.println(s);
		return 47;
	}
}
