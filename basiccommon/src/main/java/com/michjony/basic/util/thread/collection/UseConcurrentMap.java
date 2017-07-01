package com.michjony.basic.util.thread.collection;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class UseConcurrentMap {
	//使用segment分段存储map 可支持16个 segment片段
	public static void main(String[] args) {
		ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
		map.put("k1", "a");
		map.put("k2", "b");
		map.put("k3", "c");
		map.putIfAbsent("k3", "k3");
		
		Iterator<Entry<String, Object>> iterator = map.entrySet().iterator();
		
		while (iterator.hasNext()) {
			Map.Entry<String, Object> entry = (Map.Entry<String, Object>) iterator.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}
