package com.michjony.basic.thinkingjava.generics.ex8;

public class StoryCharacter {
	private static long counter = 0;
	private final long id = counter++;

	@Override
    public String toString() {
		return getClass().getSimpleName() + " " + id;
	}
}
