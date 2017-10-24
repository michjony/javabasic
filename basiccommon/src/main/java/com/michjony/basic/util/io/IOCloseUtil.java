package com.michjony.basic.util.io;

public class IOCloseUtil{

	public static void close(AutoCloseable t){
		if(t!=null){
			try {
				t.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
