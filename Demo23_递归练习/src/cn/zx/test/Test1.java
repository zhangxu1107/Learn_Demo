package cn.zx.test;

import java.io.File;
import java.util.Scanner;

public class Test1 {

	/**
	 * @param args
	 * ����:1,�Ӽ��̽���һ���ļ���·��,ͳ�Ƹ��ļ��д�С
	 * 
	 * �Ӽ��̽���һ���ļ���·��
	 * 1,��������¼�����
	 * 2,����һ������ѭ��
	 * 3,������¼��Ľ���洢����װ��File����
	 * 4,��File�����ж�
	 * 5,���ļ���·�����󷵻�
	 * 
	 * ͳ�Ƹ��ļ��д�С 
	 * 1,����һ����ͱ���
	 * 2,��ȡ���ļ��������е��ļ����ļ���listFiles();
	 * 3,��������
	 * 4,�ж����ļ��ͼ����С���ۼ�
	 * 5,�ж����ļ���,�ݹ����
	 */
	public static void main(String[] args) {
		//File dir = new File("D:\\11");
		//System.out.println(dir.length());				//ֱ�ӻ�ȡ�ļ��еĽ����0
		
		File dir = getDir();
		System.out.println(getFileLength(dir));
	}

	/*
	 * �Ӽ��̽���һ���ļ���·��
	 * 1,����ֵ����File
	 * 2,�����б���
	 */
	@SuppressWarnings("resource")
	public static File getDir() {
		//1,��������¼�����
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ���ļ���·��:");
		//2,����һ������ѭ��
		while(true) {
			//3,������¼��Ľ���洢����װ��File����
			String line = sc.nextLine();
			File dir = new File(line);
			//4,��File�����ж�
			if(!dir.exists()) {
				System.out.println("��¼����ļ���·��������,������һ���ļ���·��:");
			}else if (dir.isFile()) {
				System.out.println("��¼������ļ�·��,������һ���ļ���·��:");
			}else {
				//5,���ļ���·�����󷵻�
				return dir;
			}
		}
	}
	
	/*
	 * ͳ�Ƹ��ļ��д�С 
	 * 1,����ֵ����long
	 * 2,�����б�File dir
	 */
	public static long getFileLength(File dir) {	//D:\11
		//1,����һ����ͱ���
				long len = 0;
				//2,��ȡ���ļ��������е��ļ����ļ���listFiles();
				File[] subFiles = dir.listFiles();	//day07 Demo1_Student.class Demo1_Student.java
				//3,��������
				for (File subFile : subFiles) {
					//4,�ж����ļ��ͼ����С���ۼ�
					if(subFile.isFile()) {
						len = len + subFile.length();
					//5,�ж����ļ���,�ݹ����
					}else {
						len = len + getFileLength(subFile);
					}
				}
				return len;
	}
}
