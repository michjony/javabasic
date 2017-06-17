package com.michjony.basic.thinkingjava.reuse;

public class Detergent extends Cleanser{
	
	public static void main(String[] args) {
		Detergent dete = new Detergent();
		dete.scrub();
		dete.append(" dete apply ");
	}
	
	@Override
	public void scrub(){
		append("subclass scrub() ");
		super.scrub();
	}
	
	public void foam(){
		append(" foam() "); 
	}
	
}

class Cleanser{
	private String s = "Cleanser " ;
	
	public void append(String s){
		this.s +=s;
		System.out.println(this.s);
	}
	public void dilute(){
		append(" dilute() ");
		
	}
	public void apply(){
		append(" apply() "); 
	
	}
	
	public void scrub(){
		append(" scrub() "); 
		
	}
	public String toString(){
		return s;
	}
	public static void main(String[] args) {
		Cleanser cleanser = new Cleanser();
		cleanser.append("append");
		cleanser.dilute();
		cleanser.apply();
		cleanser.scrub();
	}
	
	
}