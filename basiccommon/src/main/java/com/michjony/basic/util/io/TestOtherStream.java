package com.michjony.basic.util.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.junit.Test;

public class TestOtherStream {

	/**
	 * 标准输出流 System.out 标准输入流 System.in
	 */
	@Test
	public void test2() {
		BufferedReader br = null;
		try {
			InputStream is = System.in;
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String str;
			while (true) {
				System.out.println("输入字符串");
				str = br.readLine();
				if (str.equalsIgnoreCase("e") || str.equalsIgnoreCase("exit")) {
					System.out.println("退出");
					break;
				}
				System.out.println(str.toUpperCase());

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOCloseUtil.close(br);
		}

	}

	/**
	 * 转换流：InputStreamReader OutputStreamWriter 编码：字符串--》字节数组 解码：字节数组--》字符串
	 */
	@Test
	public void test1() {
		File file = new File("hello.txt");
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			// 解码
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			br = new BufferedReader(isr);
			String str;
			File file2 = new File("helloencode.txt");
			FileOutputStream fos = new FileOutputStream(file2);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			bw = new BufferedWriter(osw);
			while ((str = br.readLine()) != null) {
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOCloseUtil.close(br);
			IOCloseUtil.close(bw);
		}
	}
}
