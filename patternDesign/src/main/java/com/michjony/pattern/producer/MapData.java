package com.michjony.pattern.producer;

public class MapData {
	private int data;
	private String code ;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public MapData(){}
	
	public MapData(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "MapData [data=" + data + "]";
	}
}
