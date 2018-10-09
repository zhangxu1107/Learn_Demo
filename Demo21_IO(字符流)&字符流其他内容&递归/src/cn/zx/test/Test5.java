package cn.zx.test;

import java.io.File;
import java.util.Scanner;

@SuppressWarnings("resource")
public class Test5 {

	/**
	 * ����:�Ӽ����������һ���ļ���·��,��ӡ�����ļ��������е�.java�ļ���
	 * 
	 * ����: �Ӽ��̽���һ���ļ���·�� 
	 * 1,���¼����ǲ�����,������ʾ
	 *  2,���¼������ļ�·��,������ʾ 
	 *  3,������ļ���·��,ֱ�ӷ���
	 * 
	 * ��ӡ�����ļ��������е�.java�ļ��� 
	 * 1,��ȡ�����ļ���·���µ����е��ļ����ļ���,�洢��File������
	 *  2,��������,��ÿһ���ļ����ļ������ж�
	 * 3,������ļ�,���Һ�׺��.java��,�ʹ�ӡ 
	 * 4,������ļ���,�͵ݹ����
	 */
	public static void main(String[] args) {
		File dir = getDir();
		printJavaFile(dir);
	}

	/*
	 * ��ȡ����¼����ļ���·�� 1,����ֵ����File 2,����Ҫ�в���
	 */
	public static File getDir() {
		Scanner sc = new Scanner(System.in); // ��������¼�����

		while (true) {
			System.out.println("������һ���ļ���·��:");
			String line = sc.nextLine(); // ������¼����ļ���·���洢
			File dir = new File(line); // ��װ��File����
			if (!dir.exists()) {
				System.out.println("��¼����ļ���·��������,������¼�룡");
			} else if (dir.isFile()) {
				System.out.println("��¼������ļ�·��,������¼���ļ���·����");
			} else {
				System.out.println("û��.java�ļ���");
				return dir;
			}
		}

	}

	/*
	 * ��ȡ�ļ���·���µ���.java�ļ� 1,����ֵ���� void 2,�����б�File dir
	 */
	public static void printJavaFile(File dir) {
		// 1,��ȡ�����ļ���·���µ����е��ļ����ļ���,�洢��File������
		File[] subFiles = dir.listFiles();
		// 2,��������,��ÿһ���ļ����ļ������ж�
		for (File subFile : subFiles) {
			// 3,������ļ�,���Һ�׺��.java��,�ʹ�ӡ
			if (subFile.isFile() && subFile.getName().endsWith(".java")) {
				System.out.println(subFile);
				// 4,������ļ���,�͵ݹ����
			} else if (subFile.isDirectory()) {
				printJavaFile(subFile);
			}
		}
	}

}
