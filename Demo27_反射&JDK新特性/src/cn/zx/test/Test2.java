package cn.zx.test;

import java.io.BufferedReader;
import java.io.FileReader;

public class Test2 {

	/**
	 * * ��֪һ���࣬�������£� 
	 * package cn.itcast.heima;
	 * 		public class DemoClass {
				public void run() {
					System.out.println("welcome to heima!");
				}
			}
	 * (1) дһ��Properties��ʽ�������ļ�����������������ơ� 
	 * (2) дһ�����򣬶�ȡ���Properties�����ļ����������������Ʋ���������࣬�÷���ķ�ʽ����run������
	 * @throws Exception 
	 */
	@SuppressWarnings({ "rawtypes", "resource" })
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("xxx.properties"));	//��������������xxx.properties
		Class clazz = Class.forName(br.readLine());									//��ȡ�����ļ�������,��ȡ�ֽ������
		
		DemoClass dc = (DemoClass) clazz.newInstance();								//ͨ���ֽ�����󴴽�����
		dc.run();
	}

}