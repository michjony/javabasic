package com.michjony.basic.thinkingjava.generics;

import com.michjony.basic.util.FiveTuple;
import com.michjony.basic.util.FourTuple;
import com.michjony.basic.util.SixTuple;
import com.michjony.basic.util.ThreeTuple;
import com.michjony.basic.util.TwoTuple;

/**
 * 元组测试类
 */
public class TupleTest {

	public static void main(String[] args) {
		TwoTuple<String,Integer> ttsi = f();
		System.out.println(ttsi);
		System.out.println(g());
		System.out.println(h());
		System.out.println(k());
		System.out.println(ex3());
	}
	static TwoTuple<String,Integer> f(){
		return new TwoTuple<String, Integer>("hi",47);
	}
	
	static ThreeTuple<Amphibian,String,Integer> g(){
		return new ThreeTuple<Amphibian, String, Integer>(new Amphibian(),"hi",47);
	}
	
	static FourTuple<Amphibian,Vehicle,String,Integer> h(){
		return new FourTuple<Amphibian,Vehicle,String,Integer>(new Amphibian(),new Vehicle(),"hi",47);
	}
	
	static FiveTuple<Amphibian,Vehicle,String,Integer,Double> k(){
		return new FiveTuple<Amphibian,Vehicle,String,Integer,Double>(new Amphibian(),new Vehicle(),"hi",47,12.1);
	}
	
	static SixTuple<Amphibian,Vehicle,String,Integer,Double,Long> ex3(){
		return new SixTuple<Amphibian,Vehicle,String,Integer,Double,Long>(new Amphibian(),new Vehicle(),"hi",47,12.1,12L);
	}
}

class Amphibian{

	@Override
	public String toString() {
		return "Amphibian";
	}
	
}
class Vehicle{
	@Override
	public String toString() {
		return "Vehicle";
	}
}
