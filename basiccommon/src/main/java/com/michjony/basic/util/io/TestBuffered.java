package com.michjony.basic.util.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class TestBuffered {
	
	@Test
	public void testBufferedReader(){
		File file1 = new File("property.txt");
		File file2 = new File("property.txt123.txt");
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new FileReader(file1));
			bw = new BufferedWriter(new FileWriter(file2));
			String line ;
			int len ;
			while((line=br.readLine())!=null){
				bw.write(line);
				bw.newLine();
				bw.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOCloseUtil.close(br);
			IOCloseUtil.close(bw);
		}
	}
	
	
	public void copyFile(String src,String dest){
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		//提供读入和写出的文件
		try {
			File file1 = new File(src);
			File file2 = new File(dest);
			//2先创建相应的节点流 FileInputStream FileOutputStream
			FileInputStream fis = new FileInputStream(file1);
			FileOutputStream fos = new FileOutputStream(file2);
			//将创建的节点流作为形参传递给缓冲流的构造器中
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			//具体的操作
			byte[] b = new byte[1024];
			int len ;
			while((len = bis.read(b))!=-1){
				bos.write(b, 0, len);
			}
			bos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOCloseUtil.close(bis);
			IOCloseUtil.close(bos);
		}
	}
	
	//BufferedStream
	@Test
	public void testBufferedInputOutputStream() {
		copyFile("复习.wmv","复习2.wmv");
	}

}
