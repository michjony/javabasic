package com.michjony.basic.util.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

import org.junit.Test;


public class TestOtherStream {

	/**
	 * 数据流
	 */
	@Test
	public void dataInputStream(){
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream(new File("data.txt")));
//使用这种读取是乱码
//			byte[] b = new byte[20];
//			int len ;
//			while((len = dis.read(b))!=-1){
//				System.out.println(new String(b,0,len));
//			}
			String readUTF = dis.readUTF();
			System.out.println(readUTF);
			boolean readBoolean = dis.readBoolean();
			System.out.println(readBoolean);
			long readLong = dis.readLong();
			System.out.println(readLong);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 数据流
	 * 处理基本数据类型，String,字节数组的数据
	 * DataInputStream DataOutputStream
	 */
	@Test
	public void dataOutputStream(){
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("data.txt");
			DataOutputStream dos =new DataOutputStream(fos);
			dos.writeUTF("i love code");
			dos.writeBoolean(true);
			dos.writeLong(156333333);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOCloseUtil.close(fos);
		}
	}
	
	/**
	 * 打印流
	 */
	@Test
	public void printStreamWriter(){
		FileOutputStream fos = null; 
		try {
			fos = new FileOutputStream(new File("print.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//创建打印输出流，设置自动刷新模式（写入换行符或字节'\n'时都刷新输出缓冲区）
		PrintStream ps = new PrintStream(fos,true);
		if(ps !=null){
			//将标准输出流切换成文件
			System.setOut(ps);
		}
		for (int i = 0; i < 255; i++) {
			System.out.print((char)i);
			if(i%50==0){
				System.out.println();
			}
		}
		ps.close();
	}
	
	
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
