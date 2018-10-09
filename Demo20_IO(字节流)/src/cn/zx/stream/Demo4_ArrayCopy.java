package cn.zx.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@SuppressWarnings("unused")
public class Demo4_ArrayCopy {

	/**
	 * @param args
	 * �����ֿ���
	 * ����С����
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//demo1();
		//demo2();
		FileInputStream fis = new FileInputStream("npp.exe");
		FileOutputStream fos = new FileOutputStream("yyy.exe");
		
		byte[] arr = new byte[1024 * 8];
		int len;
		while((len = fis.read(arr)) != -1) {  		//������Ǽ�arr,���صľͲ��Ƕ�ȡ���ֽڸ���,�����ֽڵ����ֵ
			fos.write(arr,0,len);
		}
		
		fis.close();
		fos.close();
	}

	private static void demo2() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("xxx.txt");
		FileOutputStream fos = new FileOutputStream("yyy.txt");
		
		byte[] arr = new byte[2];
		int len;
		while((len = fis.read(arr)) != -1) {
			fos.write(arr,0,len);
		}
		
		fis.close();
		fos.close();
	}

	private static void demo1() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("xxx.txt");
		byte[] arr = new byte[2];
		int a = fis.read(arr);						//���ļ��ϵ��ֽڶ�ȡ���ֽ�������
		
		System.out.println(a); 		                //��������Ч�ֽڸ���
		for (byte b : arr) {						//��һ�λ�ȡ���ļ��ϵ�a��b
			System.out.println(b);
		}
		System.out.println("-----------------------");
		
		int c = fis.read(arr);
		System.out.println(c); 		                //��������Ч�ֽڸ���
		for (byte b : arr) {						//��һ�λ�ȡ���ļ��ϵ�a��b
			System.out.println(b);
		}
		
		fis.close();
	}

}
