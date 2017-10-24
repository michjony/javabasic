package com.michjony.basic.util.io;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * @author Michael-jony
 * @since 2017年10月15日
 */
public class FileTest {
	@Test
	public void test1(){
		//当前文件目录下的文件的路径
		File file = new File("abc.txt");
		//访问文件名,文件路径 绝对路径，父路径
		System.out.println(file.getName());
		System.out.println(file.getPath());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getAbsoluteFile());
		System.out.println(file.getParent());
		File file1 = new File("abcback.txt");
		file.renameTo(file1);
	}
	@Test
	public void test2(){
		//当前文件目录下的文件的路径
		File file = new File("abcback.txt");
		//访问文件名,文件路径 绝对路径，父路径
		System.out.println(file.exists());
		System.out.println(file.canWrite());
		System.out.println(file.canRead());
		System.out.println(file.isFile());
		System.out.println(file.isDirectory());
		System.out.println(file.lastModified());
		System.out.println(file.length());
	}
	@Test
	public void test3() throws IOException{
		//当前文件目录下的文件的路径
		File file = new File("abcb.txt");
		if(!file.exists()){
			boolean createNewFile = file.createNewFile();
			System.out.println("创建文件:"+createNewFile);
		}
		//访问文件名,文件路径 绝对路径，父路径
		System.out.println(file.exists());
		System.out.println(file.delete());
		
		File file1 = new File("abc/abc.txt");
		if(!file1.exists()){
			boolean mkdirs = file1.mkdirs();
			System.out.println("创建 ： " + mkdirs);
		}
	}
}
