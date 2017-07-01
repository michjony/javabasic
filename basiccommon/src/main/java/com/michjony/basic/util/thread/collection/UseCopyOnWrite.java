package com.michjony.basic.util.thread.collection;

import java.util.concurrent.CopyOnWriteArrayList;

public class UseCopyOnWrite {
	public static void main(String[] args) {
		//适合读多写少场景 
		CopyOnWriteArrayList<String> cow = new CopyOnWriteArrayList<>();
		cow.add("a");
	}
}
