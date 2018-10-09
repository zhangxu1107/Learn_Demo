package cn.zx.otherio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

@SuppressWarnings("unchecked")
public class Demo10_Properties {

	/**
	 * @param args
	 * Properties��Hashtable������
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		demo1();
		demo2();
		Properties prop = new Properties();
		prop.load(new FileInputStream("config.properties"));		//���ļ��ϵļ�ֵ�Զ�ȡ��������
		prop.setProperty("tel", "18912345678");
		prop.store(new FileOutputStream("config.properties"), null);//�ڶ��������Ƕ��б����������,���Ը�ֵ,Ҳ���Ը�null
		System.out.println(prop);
	}

	private static void demo2() {
		Properties prop = new Properties();
		prop.setProperty("name", "����");
		prop.setProperty("tel", "18912345678");
		
		System.out.println(prop);
		Enumeration<String> en = (Enumeration<String>) prop.propertyNames();
		while(en.hasMoreElements()) {
			String key = en.nextElement();				//��ȡProperties�е�ÿһ����
			String value = prop.getProperty(key);		//���ݼ���ȡֵ
			System.out.println(key + "="+ value);
		}
	}

	private static void demo1() {
		Properties prop = new Properties();
		prop.put("abc", 123);
		System.out.println(prop);
	}

}
