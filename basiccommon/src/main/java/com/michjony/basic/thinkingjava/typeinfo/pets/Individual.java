package com.michjony.basic.thinkingjava.typeinfo.pets;

public class Individual {
	private String name;

	public Individual(String name) {
		this.name = name;

	}
	public Individual() {}
	int id(){
		return 1;
	}
	@Override
	public String toString(){
		return name;
	}
	
}
