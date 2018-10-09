package cn.zx.file;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Demo5_FileMethod {

	/**
	 * * A:��ȡ����
		* public String getAbsolutePath()����ȡ����·��
		* public String getPath():��ȡ·��
		* public String getName():��ȡ����
		* public long length():��ȡ���ȡ��ֽ���
		* public long lastModified():��ȡ���һ�ε��޸�ʱ�䣬����ֵ
		* public String[] list():��ȡָ��Ŀ¼�µ������ļ������ļ��е���������
		* public File[] listFiles():��ȡָ��Ŀ¼�µ������ļ������ļ��е�File���� 
	 */
	public static void main(String[] args) {
		demo1();
		File dir = new File("D:\\eclipse-workspace\\day19");
		String[] arr = dir.list();  		//��Ϊ�˻�ȡ�ļ���
		for (String string : arr) {
			System.out.println(string);
		}
		
		System.out.println("-------------------------------------------");
		
		File[] subFiles = dir.listFiles(); 	 //��ȡ�ļ�����
		for (File file : subFiles) {
			System.out.println(file);
		}
	}

	private static void demo1() {
		File file1 = new File("ccc.txt");  
		File file2 = new File("D:\\eclipse-workspace\\day19\\ccc.txt");
		System.out.println(file1.getAbsolutePath());  		//��ȡ����·��
        System.out.println(file2.getAbsolutePath());
        
        System.out.println("-------------------------------------------");
        
        System.out.println(file1.getPath());		//��ȡ���췽���д���·��
        System.out.println(file2.getPath()); 
        
        System.out.println("-------------------------------------------");
        
        System.out.println(file1.getName());		//��ȡ�ļ������ļ��е�����
        System.out.println(file2.getName());
        
        System.out.println("-------------------------------------------");
        
        System.out.println(file1.length());
        
        System.out.println("-------------------------------------------");
        
        Date d = new Date(file1.lastModified());	//�ļ�������޸�ʱ��
        System.out.println(d);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
		System.out.println(sdf.format(d));
		System.out.println("-------------------------------------------");
	}

}
