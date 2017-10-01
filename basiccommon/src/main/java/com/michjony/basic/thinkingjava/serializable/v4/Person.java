package com.michjony.basic.thinkingjava.serializable.v4;

import java.io.Serializable;

public class Person implements Serializable{
	
	/**  */
	private static final long serialVersionUID = -8277774311041408484L;

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
	public Person getSpouse() {
		return spouse;
	}
	public void setSpouse(Person spouse) {
		this.spouse = spouse;
	}
	private String firstName;
	private String lastName;
	private int age;
	private Person spouse;

	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", spouse=" + spouse.getFirstName()
				+ "]";
	}
	
}

class PersonProxy implements Serializable{
	private static final long serialVersionUID = 4178782349628003963L;
	public PersonProxy(Person orig){
		data = orig.getFirstName() + "," + orig.getLastName() + "," + orig.getAge();
		if(orig.getSpouse()!=null){
			Person spouse = orig.getSpouse();
			data = data + "," + spouse.getFirstName() + "," + spouse.getLastName()+","+spouse.getAge();
		}
	}
	
	public String data ;
	//一个类被重构成另一种类型后的版本可以提供一个 readResolve 方法，以便静默地将被序列化的对象转换成新类型
	private Object readResolve(){
		String[] pieces = data.split(",");
		Person result = new Person(pieces[0],pieces[1],Integer.parseInt(pieces[2]));
		if(pieces.length>3){
			result.setSpouse(new Person(pieces[3],pieces[4],Integer.parseInt(pieces[5])));
		}	
		return result;
	}
}
