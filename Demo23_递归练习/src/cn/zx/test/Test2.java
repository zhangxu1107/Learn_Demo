package cn.zx.test;

import java.io.File;

public class Test2 {

	/**
	 * ����:2,�Ӽ��̽���һ���ļ���·��,ɾ�����ļ���
	 * 
	 * ɾ�����ļ���
	 * ����:
	 * 1,��ȡ���ļ����µ����е��ļ����ļ���
	 * 2,��������
	 * 3,�ж����ļ�ֱ��ɾ��
	 * 4,������ļ���,�ݹ����
	 * 5,ѭ��������,�ѿ��ļ���ɾ��
	 */
	public static void main(String[] args) {
		File dir = Test1.getDir();      		//��ȡ�ļ���·��
		deleteFile(dir);
	}

	/*
	 * ɾ�����ļ���
	 * 1,����ֵ���� void
	 * 2,�����б�File dir
	 */
	public static void deleteFile(File dir) {	
		//1,��ȡ���ļ����µ����е��ļ����ļ���
		File[] subFiles = dir.listFiles();		
		//2,��������
		for (File subFile : subFiles) {
			//3,�ж����ļ�ֱ��ɾ��
			if(subFile.isFile()) {
				subFile.delete();
			//4,������ļ���,�ݹ����
			}else {
				deleteFile(subFile);			
			}
		}
		//5,ѭ��������,�ѿ��ļ���ɾ��
		dir.delete();
	}
}
