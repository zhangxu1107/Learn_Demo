package cn.zx.exception;

import java.io.FileInputStream;

public class Demo4_Exception {

	/**
	 * * A:�������쳣���������쳣������
		* Java�е��쳣����Ϊ�����ࣺ����ʱ�쳣������ʱ�쳣��
		* ���е�RuntimeException�༰�������ʵ������Ϊ����ʱ�쳣���������쳣���Ǳ���ʱ�쳣
		
		* ����ʱ�쳣
			* Java���������ʾ�����������ͻᷢ�������޷�ͨ������
		* ����ʱ�쳣
			* ������ʾ����Ҳ���Ժͱ���ʱ�쳣һ������
	* B:������ʾ
		* �������쳣���������쳣������
	����ʱ�쳣Ҳ����δ������쳣(��ʦ�Լ������)
		δ�����:����ĳЩ�����ʱ��Ҫ��ĳЩ׼��
		����ʱ�쳣:�ڱ���ĳ�������ʱ��,�п��ܻ����������������鷢��,�����ļ��Ҳ���,�������쳣�ͱ����ڱ����ʱ����
		������������ͨ����
		
		����ʱ�쳣:���ǳ���Ա�����ô���,��Ҫ�����޸Ĵ���
	 */
	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("xxx.txt");
		} catch (Exception e) {
			
		}

	}

}
