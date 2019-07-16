package com.michjony.basic.thinkingjava.serializable.v1;

/**
 * 
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * @author Michael-jony
 * @since 2017年10月1日
 */
public class Person   implements java.io.Serializable{
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
}
