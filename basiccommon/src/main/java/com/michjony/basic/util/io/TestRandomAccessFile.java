package com.michjony.basic.util.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.Test;

/**
 * 1.支持随机访问 2.可以充当输入流和输出流 3.支持从文件的开头读取，写入 4.支持从任意位置的读取，写入
 * 
 * @since 2017年11月2日
 */
public class TestRandomAccessFile {
	@Test
	public void test2() {
		RandomAccessFile raf1 = null;
		try {
			raf1 = new RandomAccessFile(new File("hello.txt"), "rw");
			raf1.seek(3);
			raf1.write("xy".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOCloseUtil.close(raf1);
		}
	}

	@Test
	public void test1() {
		RandomAccessFile raf1 = null;
		RandomAccessFile raf2 = null;
		try {
			raf1 = new RandomAccessFile(new File("hello.txt"), "r");
			raf2 = new RandomAccessFile(new File("hello.txt"), "rw");

			byte[] b = new byte[20];
			int len;
			while ((len = raf1.read(b)) != -10) {
				raf2.write(b, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOCloseUtil.close(raf1);
			IOCloseUtil.close(raf2);
		}
	}
}
