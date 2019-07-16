package com.michjony.basic.thinkingjava.serializable.v3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Person implements Serializable{
	   private static final long serialVersionUID = -8173271051581856364L;
	   public Person(String fn, String ln, int a)
	    {
	        this.firstName = fn; this.lastName = ln; this.age = a;
	    }
	
	    public String getFirstName() { return firstName; }
	    public String getLastName() { return lastName; }
	    public int getAge() { return age; }
	    public Person getSpouse() { return spouse; }
	
	    
	    public void setFirstName(String value) { firstName = value; }
	    public void setLastName(String value) { lastName = value; }
	    public void setAge(int value) { age = value; }
	    public void setSpouse(Person value) { spouse = value; }
	 
	    
	    @Override
        public String toString()
	    {
	        return "[Person: firstName=" + firstName + 
	            " lastName=" + lastName +
	            " age=" + age +
	            " spouse=" + spouse.getFirstName() +
	            "]";
	    }    
	 
	    private String firstName;
	    private String lastName;
	    private int age;
	    private Person spouse;
	    
	    
	    
	    private void readObject(ObjectInputStream stream) throws ClassNotFoundException, IOException{
	    	age = age << 2;
	    	stream.defaultReadObject();
	    }
	    
	    private void writeObject(ObjectOutputStream stream) throws IOException{
	    	stream.defaultWriteObject();
	    	//模糊化数据
	    	age = age << 2;
	    }
}
