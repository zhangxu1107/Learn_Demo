package cn.zx.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@SuppressWarnings("unused")
public class Demo3_Copy {

	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// demo1();
		// demo2();
		// �ڶ��ֿ���,���Ƽ�ʹ��,��Ϊ�п��ܻᵼ���ڴ����
		FileInputStream fis = new FileInputStream("npp.exe");    // ��������������,����npp.exe
		FileOutputStream fos = new FileOutputStream("copy.exe"); // �������������,����copy.exe
		int len = fis.available();
		System.out.println(len);              //�ļ���С
		
		byte[] arr = new byte[fis.available()];					//�������ļ�һ����С���ֽ�����
		fis.read(arr);											//���ļ��ϵ��ֽڶ�ȡ���ڴ���
		fos.write(arr);											//���ֽ������е��ֽ�����д���ļ���
		
		fis.close();                                            // �����ͷ���Դ
		fos.close();
	}

	private static void demo2() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("npp.exe");    // ��������������,����npp.exe
		FileOutputStream fos = new FileOutputStream("copy.exe"); // �������������,����copy.exe
		int b;
		while ((b = fis.read()) != -1) { // �ڲ��ϵĶ�ȡÿһ���ֽ�
			fos.write(b);                // ��ÿһ���ֽ�д��
		}

		fis.close(); // �����ͷ���Դ
		fos.close();
	}

	private static void demo1() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("����.jpg"); // ��������������,��������.jpg
		FileOutputStream fos = new FileOutputStream("copy.jpg"); // �������������,����copy.jpg

		int b;
		while ((b = fis.read()) != -1) { // �ڲ��ϵĶ�ȡÿһ���ֽ�
			fos.write(b); // ��ÿһ���ֽ�д��
		}

		fis.close(); // �����ͷ���Դ
		fos.close();
	}

}
