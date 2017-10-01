package com.michjony.basic.thinkingjava.j5things2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
	public static void main(String[] args) {
		Person p = new Person("mark", "zhao", 28,new Person("mark1","zhao",1),new Person("mark2","zhao",1));
		//for 遍历的是Person的iterator方法
		for (Person person : p) {
			System.out.println(person.getFirstName());
		}
		List<Person> kids = new ArrayList<>(p.getChildren());
		Collections.reverse(kids);
		System.out.println(kids);
		System.out.println(MyCollections.reverse(kids));
	}
}
