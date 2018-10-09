package cn.zx.reflect;

import java.lang.reflect.Constructor;

import cn.zx.bean.Person;

public class Demo3_Constructor {

	/**
	 * Class���newInstance()������ʹ�ø����޲εĹ��캯����������, ���һ����û���޲εĹ��캯��,
	 * �Ͳ�������������,���Ե���Class���getConstructor
	 * (String.class,int.class)������ȡһ��ָ���Ĺ��캯��Ȼ���ٵ���Constructor���newInstance
	 * ("����",20)������������
	 * @throws Exception 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("cn.zx.bean.Person");
		//Person p = (Person) clazz.newInstance();				ͨ���޲͹��촴������
		//System.out.println(p);
		Constructor c = clazz.getConstructor(String.class,int.class);	//��ȡ�вι���
		Person p = (Person) c.newInstance("����",23);						//ͨ���вι��촴������
		System.out.println(p);
	}

}