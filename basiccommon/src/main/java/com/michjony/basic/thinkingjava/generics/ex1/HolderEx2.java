package com.michjony.basic.thinkingjava.generics.ex1;

public class HolderEx2<T> {

	private T x, y, z;

	public HolderEx2(T x, T y, T z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public T getX() {
		return x;
	}

	public void setX(T x) {
		this.x = x;
	}

	public T getY() {
		return y;
	}

	public void setY(T y) {
		this.y = y;
	}

	public T getZ() {
		return z;
	}

	public void setZ(T z) {
		this.z = z;
	}

	@Override
	public String toString() {
		return "HolderEx2 [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
	public static void main(String[] args) {
		Robot a = new Robot("robota");
		Robot b = new Robot("robotb");
		Robot c = new Robot("robotc");
		HolderEx2<Robot> holder = new HolderEx2<Robot>(a, b, c);
		System.out.println(holder);
	}
}

class Robot{
	
	private String name ;
	
	public Robot(String name){
		this.name = name;
	}
	@Override
	public String toString(){
		return name ;
	}
	
}