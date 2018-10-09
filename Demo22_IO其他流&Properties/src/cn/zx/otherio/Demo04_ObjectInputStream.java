package cn.zx.otherio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import cn.zx.bean.Person;

public class Demo04_ObjectInputStream {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 * ObjectInputStream
	 * 对象输入流,反序列化
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException, ClassNotFoundException {
        //demo1();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("e.txt"));
		ArrayList<Person> list = (ArrayList<Person>) ois.readObject();		//将集合对象一次读取
		
		for (Person person : list) {
			System.out.println(person);
		}
		
		ois.close();
	}

	@SuppressWarnings("unused")
	private static void demo1() throws IOException, FileNotFoundException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("e.txt"));
		
		Person p1 = (Person) ois.readObject();
		Person p2 = (Person) ois.readObject();
		//Person p3 = (Person) ois.readObject();			//当文件读取到了末尾时出现EOFException
		
		System.out.println(p1);
		System.out.println(p2);
		//System.out.println(p3);
		
		ois.close();
	}

}
