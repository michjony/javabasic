package com.michjony.basic.util.lambda;

public interface PersonFactory<P extends Person> {
	P create(String firstName,String lastName);
}
