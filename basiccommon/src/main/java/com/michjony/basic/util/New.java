package com.michjony.basic.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class New {
	public static <K, V> Map<K, V> newMap() {
		return new HashMap<K, V>();
	}
	
	public static <V> List<V> newList(){
		return new ArrayList<>();
	}
	public static void main(String[] args) {
		Map<String,List<String>> map = newMap();
	}
}
