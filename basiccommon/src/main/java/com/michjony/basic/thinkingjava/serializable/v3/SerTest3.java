package com.michjony.basic.thinkingjava.serializable.v3;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

import com.michjony.basic.thinkingjava.serializable.v3.Person;

public class SerTest3 {
	// 执行toDisk时没有Gender字段
	@Test
	public void serializeToDisk() {
		try {
			Person ted = new Person("Ted", "Neward", 39);
			Person charl = new Person("Charlotte", "Neward", 38);

			ted.setSpouse(charl);
			charl.setSpouse(ted);

			FileOutputStream fos = new FileOutputStream("tempdata.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(ted);
			oos.close();
		} catch (Exception ex) {
			fail("Exception thrown during test: " + ex.toString());
		}
	}

	//执行反序列化是有Gender字段  类的属性发生变化，依然可以被反序列化  （serialVersionUID字段不变）
	@Test
	public void serializeFromDisk() {
		try {
			FileInputStream fis = new FileInputStream("tempdata.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			com.michjony.basic.thinkingjava.serializable.v3.Person ted = (com.michjony.basic.thinkingjava.serializable.v3.Person) ois
					.readObject();
			ois.close();
			System.out.println(ted);
			assertEquals(ted.getFirstName(), "Ted");
			assertEquals(ted.getSpouse().getFirstName(), "Charlotte");

			// Clean up the file
			//new File("tempdata.ser").delete();
		} catch (Exception ex) {
			fail("Exception thrown during test: " + ex.toString());
		}
	}
}
