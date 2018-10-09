package cn.zx.test;

import java.io.File;

public class Test4 {

	/**
	 * ����:4,�Ӽ��̽���һ���ļ���·��,���ļ����е������ļ��Լ��ļ��е����ְ��㼶��ӡ, ����:
	 * ���ļ����е������ļ��Լ��ļ��е����ְ��㼶��ӡ
	 * ����:
	 * 1,��ȡ�����ļ����ļ���,���ص�File����
	 * 2,��������
	 * 3,�������ļ������ļ���,����Ҫֱ�Ӵ�ӡ
	 * 4,������ļ���,�ݹ����
	 * 	day07
	 * 		day08
	 * 			xxx.jpg
	 * 			yyy.txt
	 * 		Demo1_Consturctor.class
	 * 		Demo1_Consturctor.java
	 * 	Demo1_Student.class
	 * 	Demo1_Student.java
	 */
	public static void main(String[] args) {
		File dir = Test1.getDir();				//��ȡ�ļ���·��
		printLev(dir,0);
	}

	public static void printLev(File dir,int lev) {
		//1,���ļ����е������ļ��Լ��ļ��е����ְ��㼶��ӡ
		File[] subFiles = dir.listFiles();
		//2,��������
		for (File subFile : subFiles) {
			for(int i = 0; i <= lev; i++) {
				System.out.print("\t");
			}
			//3,�������ļ������ļ���,����Ҫֱ�Ӵ�ӡ
			System.out.println(subFile);
			//4,������ļ���,�ݹ����
			if(subFile.isDirectory()) {
				//printLev(subFile,lev + 1);
				printLev(subFile,++lev);
			}
		}
	}

}