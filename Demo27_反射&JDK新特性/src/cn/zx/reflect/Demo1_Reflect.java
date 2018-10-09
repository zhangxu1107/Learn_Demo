package cn.zx.reflect;

import cn.zx.bean.Person;

public class Demo1_Reflect {

	/**
	 * 
	 * @param args
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws ClassNotFoundException {
		Class clazz1 = Class.forName("cn.zx.bean.Person");
		Class clazz2 = Person.class;
		
		Person p = new Person();
		Class clazz3 = p.getClass();
		
		System.out.println(clazz1);
		System.out.println(clazz2);
		System.out.println(clazz3);
		
		System.out.println(clazz1 == clazz2);
		System.out.println(clazz1 == clazz3);
		System.out.println(clazz2 == clazz3);
	}

}
