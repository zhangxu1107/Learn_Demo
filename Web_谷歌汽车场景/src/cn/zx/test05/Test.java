package cn.zx.test05;

import java.lang.reflect.Method;

public class Test {
	public static void main(String[] args) {
		// ��ȡ�ȸ�Car googleCar.class�ֽ����ļ������еĽӿ�,googlecar���Ͽ���ʵ���˶���ӿ�
		Class[] clazz = GoogleCar.class.getInterfaces();
		
		//���ڵ�ǰ�����йȸ�Car��ʵ����һ���ӿ�ICar
		//���´����൱�ڻ�ȡ����ICar.class�ֽ������
		Class cla=clazz[0];
		//��ȡICar.class�ֽ�����������еķ���
		Method[] mds = cla.getMethods();
		for (Method method : mds) {
			System.out.println(method.getName());
		}
	}
}
