package com.michjony.basic.util.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/**
 * 流的分类： 输入输出流 IO体系 抽象基类 节点流（文件流） InputStream FileInputStream OutputStream
 * FileOutputStream Reader FileReader Writer FileWriter
 * 
 * @author Michael-jony
 * @since 2017年10月15日
 */
public class FileStreamTest {

	/**
	 * 从硬盘中存在的一个文件中，读取内容到程序中，使用FileInputStream <B>方法名称：</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void testfileStream() throws FileNotFoundException {
		// 创建file对象
		File file = new File("hello.txt");
		// 创建FileInputStream对象
		FileInputStream fis = new FileInputStream(file);
		// 3调用FileInputStream的方法，实现file文件的读取
		try {
			/*
			 * read():读取文件的一个字节
			 */
			int a;
			while ((a = fis.read()) != -1) {
				System.out.print((char) a);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testfileStream2() {
		FileInputStream fis = null;
		try {
			File file = new File("hello.txt");
			fis = new FileInputStream(file);
			int len;
			// 读取到的数据要写入的数组
			byte[] b = new byte[20];
			// len返回读取了几个字节
			while ((len = fis.read(b)) != -1) {
				// for (int i = 0; i < len; i++) {
				// System.out.print((char)b[i]);
				// }
				String str = new String(b, 0, len);
				System.out.print(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOCloseUtil.close(fis);
		}
	}

	@Test
	public void testFileOutputStream() {
		//创建一个file对象，表明要写入的文件位置，
		//输出的物理文件可以不存在，当执行过程中，如果不存在，会自动创建，如果存在，会覆盖。
		File file = new File("hello2.txt");
		//创建一个FileOutputStream的对象，将file的对象作为形参传递给FileOutputStream的构造器中
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			fos.write(new String("hello 1024").getBytes());
		} catch (FileNotFoundException e ) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		finally {
			IOCloseUtil.close(fos);
		}
	}
	
	//从硬盘读取一个文件，写入到另一个位置，相当于文件的复制
	@Test
	public void testFileInputOutStream(){
		copyFile("a.JPG","b.JPG");
	}
	
	
	public static void copyFile(String src,String dest){
		//提供读取，写出的文件
		File file1 = new File(src);
		File file2 = new File(dest);
		//提供相应的流
		FileInputStream  fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			//实现文件的复制
			int len;
			byte[] b = new byte[20];
			while((len = fis.read(b))!=-1){
				fos.write(b,0,len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			IOCloseUtil.close(fis);
			IOCloseUtil.close(fos);
		}
	}
}
