package com.michjony.basic.util.annotation.database;
@DBTable(name="member")
public class Member {
	
	@SQLString(30)
	String firstName;
	@SQLString(30)
	String lastName;

}
