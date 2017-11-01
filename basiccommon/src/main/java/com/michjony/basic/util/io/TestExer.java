package com.michjony.basic.util.io;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class TestExer {
	
	//利用字符流复制test.txt
	@Test
	public void test4(){
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new FileReader(new File("test.txt")));
			bw = new BufferedWriter(new FileWriter(new File("test4.txt")));
			char[] c = new char[20]; 
			int len ;
			while((len=br.read(c))!=-1){
				bw.write(c, 0, len);
			}
			bw.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			IOCloseUtil.close(br);
			IOCloseUtil.close(bw);
		}
	}
	
	//使用字符流实现内容的读入
	@Test
	public void test3(){
		String str ;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("test.txt"));
			while((str = br.readLine())!=null){
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOCloseUtil.close(br);
		}
	}
	
	//使用字符流实现内容的输出
	@Test
	public void test2(){
		BufferedWriter bw  = null;
		try {
			bw = new BufferedWriter(new FileWriter("test2.txt"));
			String str = "加州的森林大火仍在肆虐，不仅烧毁了无数房屋，人员伤亡也极其惨重，已经有超过 6800 户人家遭殃。更糟糕的是，有不少文化资料也在这场大火中化为乌有，79 年前惠普公司创业之初的档案资料便是其中之一。　"
					+ "1938 年，比尔·休利特（William Hewlett）和戴维·帕卡德（David Packard）拿着 538 美元，在美国加州帕罗奥多市艾迪森大街 376 号的车库里，创办了惠普公司。　硅谷著名的「车库创业」文化即起源于此，这个车库也被誉为「硅谷的发源地」。";
			bw.write(str);
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			IOCloseUtil.close(bw);
		}
	}
	
	
	// 使用字节流实现内容的输出
	@Test
	public void test1() {
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(new File("test.txt")));
			String str = "加州的森林大火仍在肆虐，不仅烧毁了无数房屋，人员伤亡也极其惨重，已经有超过 6800 户人家遭殃。更糟糕的是，有不少文化资料也在这场大火中化为乌有，79 年前惠普公司创业之初的档案资料便是其中之一。　"
					+ "1938 年，比尔·休利特（William Hewlett）和戴维·帕卡德（David Packard）拿着 538 美元，在美国加州帕罗奥多市艾迪森大街 376 号的车库里，创办了惠普公司。　硅谷著名的「车库创业」文化即起源于此，这个车库也被誉为「硅谷的发源地」。";
			bos.write(str.getBytes());
			bos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			IOCloseUtil.close(bos);
		}
	}
}
