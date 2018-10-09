package cn.zx.file;

import java.io.File;

@SuppressWarnings("unused")
public class Demo1_File {

	/**
	 * File(String pathname)：根据一个路径得到File对象
	 * File(String parent, String child):根据一个目录和一个子文件/目录得到File对象
	 * File(File parent, String child):根据一个父File对象和一个子文件/目录得到File对象
	 */
	public static void main(String[] args) {
		//demo1();
		//demo2();
		demo3();
	}

	private static void demo3() {   //File(File parent, String child):根据一个父File对象和一个子文件/目录得到File对象
		File parent = new File("D:\\eclipse-workspace\\day19");
		String child = "xxx.txt";
		File file = new File(parent, child);
		System.out.println(file.exists());
	}

	private static void demo2() {    //File(String parent, String child):根据一个目录和一个子文件/目录得到File对象
		String parent = "D:\\eclipse-workspace\\day19";
		String child ="xxx.txt";
		File file = new File(parent,child);
		System.out.println(file.exists());
	}

	private static void demo1() {  //File(String pathname)：根据一个路径得到File对象
		//FileInputStream fis = new FileInputStream("xxx.txt");
		File file = new File("D:\\eclipse-workspace\\day19\\xxx.txt");
		System.out.println(file.exists());
		
		File file2 = new File("xxx.txt");
		System.out.println(file2.exists());
		
		File file3 = new File("yyy.txt");
		System.out.println(file3.exists());
	}

}
