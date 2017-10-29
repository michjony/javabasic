package com.michjony.basic.util.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class TestFileReaderWriter {

	//FileReader FileWriter 可以实现文件的复制  对于非文本文件，只能使用字节流
	@Test
	public void testFileReaderWriter(){
		//1.输入流对应的文件src必须存在
		FileReader fr = null;
		FileWriter fw = null;
		try {
		File src = new File("hello2.txt");
		File dest = new File("hello2dest.txt");
			fr = new FileReader(src);
			fw = new FileWriter(dest);
			char[] c = new char[4];
			int len ;
			while((len = fr.read(c))!=-1){
				fw.write(c, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			IOCloseUtil.close(fr);
			IOCloseUtil.close(fw);
		}
	}
	
	
	@Test
	public void testFileReader() {
		FileReader fr = null;
		try {
			File file = new File("hello2.txt");
			fr = new FileReader(file);
			char[] c = new char[1000];
			int len;
			while ((len = fr.read(c)) != -1) {
				String str = new String(c, 0, len);
				System.out.print(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOCloseUtil.close(fr);
		}
	}
}
