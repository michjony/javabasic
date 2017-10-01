package com.michjony.basic.thinkingjava.j5things2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Person implements Iterable<Person>{

	private String firstName;
	private String lastName;
	private int age;
	private List<Person> children = new ArrayList<Person>();
	
	public Person(String firstName, String lastName, int age,Person ...kids) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		for (Person person : kids) {
			this.children.add(person);
		}
	}

	public List<Person> getChildren() {
		return children;
	}

	public void setChildren(List<Person> children) {
		this.children = children;
	}

	@Override
	public Iterator<Person> iterator() {
		return children.iterator();
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", children=" + children
				+ "]";
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
