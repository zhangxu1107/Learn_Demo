package cn.zx.test;

import java.io.File;
import java.io.FilenameFilter;

public class Test3 {

	/**
	 * @param args
	 * * A:������ʾ
	 * �����ж�D��Ŀ¼���Ƿ��к�׺��Ϊ.jpg���ļ�������У���������ļ�����
	 */
	public static void main(String[] args) {
		demo1();
		File dir = new File("D:\\");
		String[] arr = dir.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				//System.out.println(dir);
				//System.out.println(name);
				File file = new File(dir,name); 
				return file.isFile() && file.getName().endsWith(".jpg");
			}
		});
		for (String string : arr) {
			System.out.println(string);
		}
		
	}

	private static void demo1() {
		File dir = new File("D:\\");
		
        String[] arr = dir.list();	//��ȡD�������е��ļ����ļ���
        for (String string : arr) {
			if(string.endsWith(".jpg")) {
				System.out.println(string);
			}
		}
        
        File[] subFiles = dir.listFiles();	//��ȡe�������е��ļ����ļ��ж���
        for (File subfile : subFiles) {
			if(subfile.isFile() && subfile.getName().endsWith(".jpg")) {
				System.out.println(subfile);
			}
		}
	}

}
