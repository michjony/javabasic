package com.michjony.basic.thinkingjava.generics.ex1;

import com.michjony.basic.thinkingjava.generics.Holder3;
import com.michjony.basic.thinkingjava.typeinfo.pets.Dog;
import com.michjony.basic.thinkingjava.typeinfo.pets.Mutt;
import com.michjony.basic.thinkingjava.typeinfo.pets.Pet;

public class EX1 {
	public static void main(String[] args) {
		Holder3<Pet> holder3 = new Holder3<>(new Pet("pet"));
		System.out.println(holder3.get());
		holder3.set(new Dog("dog"));
		System.out.println(holder3.get());
		holder3.set(new Mutt("mutt"));
		System.out.println(holder3.get());
	}
}
