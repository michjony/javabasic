package com.michjony.basic.thinkingjava.serializable.v2;

import java.io.Serializable;

public class Person implements Serializable{
	   private static final long serialVersionUID = -8173271051581856364L;
	   public Person(String fn, String ln, int a,Gender g)
	    {
	        this.firstName = fn; this.lastName = ln; this.age = a; this.gender = g;
	    }
	   public Person(String fn, String ln, int a)
	    {
	        this.firstName = fn; this.lastName = ln; this.age = a;
	    }
	    public String getFirstName() { return firstName; }
	    public String getLastName() { return lastName; }
	    public int getAge() { return age; }
	    public Person getSpouse() { return spouse; }
	    public Gender getGender() { return gender; }
	    
	    public void setFirstName(String value) { firstName = value; }
	    public void setLastName(String value) { lastName = value; }
	    public void setAge(int value) { age = value; }
	    public void setSpouse(Person value) { spouse = value; }
	    public void setGender(Gender value) { gender = value; }
	    
	    public String toString()
	    {
	        return "[Person: firstName=" + firstName + 
	            " lastName=" + lastName +
	            " gender=" + gender +
	            " age=" + age +
	            " spouse=" + spouse.getFirstName() +
	            "]";
	    }    
	 
	    private String firstName;
	    private String lastName;
	    private int age;
	    private Person spouse;
	    private Gender gender;
}

enum Gender
{
    MALE, FEMALE;
}
