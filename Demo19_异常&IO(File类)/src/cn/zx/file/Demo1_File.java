package cn.zx.file;

import java.io.File;

@SuppressWarnings("unused")
public class Demo1_File {

	/**
	 * File(String pathname)������һ��·���õ�File����
	 * File(String parent, String child):����һ��Ŀ¼��һ�����ļ�/Ŀ¼�õ�File����
	 * File(File parent, String child):����һ����File�����һ�����ļ�/Ŀ¼�õ�File����
	 */
	public static void main(String[] args) {
		//demo1();
		//demo2();
		demo3();
	}

	private static void demo3() {   //File(File parent, String child):����һ����File�����һ�����ļ�/Ŀ¼�õ�File����
		File parent = new File("D:\\eclipse-workspace\\day19");
		String child = "xxx.txt";
		File file = new File(parent, child);
		System.out.println(file.exists());
	}

	private static void demo2() {    //File(String parent, String child):����һ��Ŀ¼��һ�����ļ�/Ŀ¼�õ�File����
		String parent = "D:\\eclipse-workspace\\day19";
		String child ="xxx.txt";
		File file = new File(parent,child);
		System.out.println(file.exists());
	}

	private static void demo1() {  //File(String pathname)������һ��·���õ�File����
		//FileInputStream fis = new FileInputStream("xxx.txt");
		File file = new File("D:\\eclipse-workspace\\day19\\xxx.txt");
		System.out.println(file.exists());
		
		File file2 = new File("xxx.txt");
		System.out.println(file2.exists());
		
		File file3 = new File("yyy.txt");
		System.out.println(file3.exists());
	}

}
