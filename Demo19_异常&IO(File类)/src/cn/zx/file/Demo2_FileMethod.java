package cn.zx.file;

import java.io.File;
import java.io.IOException;

public class Demo2_FileMethod {

	/**
	 * * A:��������
			* public boolean createNewFile():�����ļ� ��������������ļ����Ͳ�������
			* public boolean mkdir():�����ļ��� ��������������ļ��У��Ͳ�������
			* public boolean mkdirs():�����ļ���,������ļ��в����ڣ�����㴴������
		* B:������ʾ
			* File��Ĵ�������
		
			* ע�����
				* ����㴴���ļ������ļ�������д�̷�·������ô��Ĭ������Ŀ·���¡�
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		demo1();
		File dir1 = new File("aaa");
		System.out.println(dir1.mkdirs());
		
		File dir2 = new File("bbb.txt");  //����д�ǿ��Ե�,�ļ���Ҳ�ǿ����к�׺��
		System.out.println(dir2.mkdirs());
		
		File dir3 = new File("ccc\\ddd");
		System.out.println(dir3.mkdirs()); 				//�����༶Ŀ¼
	}

	private static void demo1() throws IOException {
		File file = new File("yyy.txt"); 
		System.out.println(file.createNewFile()); //���û�оʹ���,����true
		
		File file2 = new File("zzz");
		System.out.println(file2.createNewFile());
	}

}
