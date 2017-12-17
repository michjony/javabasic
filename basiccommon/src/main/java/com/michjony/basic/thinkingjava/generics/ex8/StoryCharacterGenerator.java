package com.michjony.basic.thinkingjava.generics.ex8;

import java.util.Iterator;
import java.util.Random;

import com.michjony.basic.util.Generator;

public class StoryCharacterGenerator implements Generator<StoryCharacter>, Iterable<StoryCharacter> {

	private int size = 0;
	
	private Random rand = new Random(47);
	
	public StoryCharacterGenerator(){}
	
	public StoryCharacterGenerator(int size) {
		this.size = size;
	}

	@SuppressWarnings("rawtypes")
	private Class[] types = { DarthVader.class, JabbaTheHut.class, LukeSkywalker.class, Yoda.class };

	@Override
	public StoryCharacter next() {
		try {
			return (StoryCharacter) types[rand.nextInt(types.length)].newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Iterator<StoryCharacter> iterator() {
		return new Iterator<StoryCharacter>() {
			int count = size;

			@Override
			public boolean hasNext() {
				return count > 0;
			}

			@Override
			public StoryCharacter next() {
				count--;
				return StoryCharacterGenerator.this.next();
			}

		};
	}

	
	public static void main(String[] args) {
		StoryCharacterGenerator gen = new StoryCharacterGenerator(5);
		for (int i = 0; i < 5; i++) {
			System.out.println(gen.next());
		}
		for(StoryCharacter s : new StoryCharacterGenerator(5)){
			System.out.println(s); 
		}
	}
}
