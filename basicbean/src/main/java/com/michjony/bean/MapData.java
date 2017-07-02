package com.michjony.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("data")
public class MapData {
	@XStreamAlias("key")
	private String key;
	@XStreamAlias("value")
	private String Object;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getObject() {
		return Object;
	}
	public void setObject(String object) {
		Object = object;
	}
	
}
