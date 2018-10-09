package cn.zx.reflect;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Demo2_Reflect {

	/**
	 * * ���䣨Class.forName()��ȡ�����ļ�������
	 * * ե֭��(Juicer)ե֭�İ���
	 * * �ֱ���ˮ��(Fruit)ƻ��(Apple)�㽶(Banana)����(Orange)ե֭(squeeze)
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@SuppressWarnings({ "resource", "rawtypes" })
	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		/*
		//û���÷��䣬ֻ��˵��̬
		Juicer j = new Juicer();		//����ե֭��
		j.run(new Apple());        //��ե֭���з���ƻ��
		//j.run(new Orange());    //Apple a = new Orange(); ���Ͳ�ƥ��
		
		//��ե֭���������run�������Խ�������
		j.run(new Orange());
		*/
		
		//�÷��������
		Juicer j = new Juicer();		//����ե֭��
		BufferedReader br = new BufferedReader(new FileReader("config.properties"));
		Class clazz = Class.forName(br.readLine());	//��ȡ������ֽ����ļ�
		Fruit f = (Fruit) clazz.newInstance();		//����ʵ������,,��������ָ���������ˮ��������ָ����ƻ������
		j.run(f);
	}

}

interface Fruit{
	public void squeeze();
}

class Apple implements Fruit {
	public void squeeze() {
		System.out.println("ե��һ��ƻ��֭");
	}
}

class Orange  implements Fruit {
	public void squeeze() {
		System.out.println("ե��һ������֭��");
	}
}

class Juicer{
/*	public void run(Apple a) {
		a.squeeze();
	}
	
	public void run(Orange o) {
		o.squeeze();
	}*/
	
	//�Ľ������
	public void run(Fruit f) {
		f.squeeze();
	}
}