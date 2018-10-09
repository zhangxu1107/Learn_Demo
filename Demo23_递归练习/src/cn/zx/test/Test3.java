package cn.zx.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test3 {

	/**
	 * ����:3,�Ӽ��̽��������ļ���·��,������һ���ļ�����(��������)��������һ���ļ�����
	 * 
	 * ������һ���ļ�����(��������)��������һ���ļ�����
	 * ����:
	 * 1,��Ŀ���ļ����д���ԭ�ļ���
	 * 2,��ȡԭ�ļ��������е��ļ����ļ���,�洢��File������
	 * 3,��������
	 * 4,������ļ�����io����д
	 * 5,������ļ��о͵ݹ����
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File src = Test1.getDir();
		File dest = Test1.getDir();
		if(src.equals(dest)) {
			System.out.println("Ŀ���ļ�����Դ�ļ��е����ļ���");
		}else {
			copy(src,dest);
		}
	}

	/*
	 * ������һ���ļ�����(��������)��������һ���ļ�����
	 * 1,����ֵ����void
	 * 2,�����б�File src,File dest
	 */
	public static void copy(File src, File dest) throws IOException{
		//1,��Ŀ���ļ����д���ԭ�ļ���
		File newDir = new File(dest,src.getName());
		newDir.mkdir();
		
		//2,��ȡԭ�ļ��������е��ļ����ļ���,�洢��File������
		File[] subFiles = src.listFiles();
		
		//3,��������
		for (File subFile : subFiles) {
			//4,������ļ�����io����д
			if(subFile.isFile()) {
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(subFile));
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(newDir,subFile.getName())));
				
				int b;
				while((b = bis.read()) != -1) {
					bos.write(b);
				}
				
				bis.close();
				bos.close();
			//5,������ļ��о͵ݹ����
			}else {
				copy(subFile,newDir);
			}
		}
	}
}
