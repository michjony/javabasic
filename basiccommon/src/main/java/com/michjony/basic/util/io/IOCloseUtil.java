package com.michjony.basic.util.io;

public class IOCloseUtil {

	public static void close(AutoCloseable t) {
		if (t != null) {
			try {
				t.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static <T extends AutoCloseable> void closeAuto(T t) {
		if (t == null) {
			return;
		}
		try {
			t.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
