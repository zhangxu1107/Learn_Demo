package cn.zx.test01;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestAnnotation {
	
	
	//����ע��ĺ�����:������ǰ�ķ�������д����ķ���
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	@Test
	public void test01() {
		//����ע��ĺ�����:���Ʊ���������������Ϣ
		@SuppressWarnings("unused")
		int i;
		
		//����ע��ĺ�����:���Ʊ���������������Ϣ(����б���δʹ��,δ��ѭ���͸�ʽ���󲻱�����)
		@SuppressWarnings({ "rawtypes", "unused" })
		List a = new ArrayList<>();
	}
	
	//����ע��ĺ�����:�������µķ����ǹ�ʱ�ķ���,��������ʹ��
	@Deprecated
	public void test02() {
		
	}
	
	//����ע��ĺ�����:�����ǰ������ִ��ʱ�䳬��1��,�ᱨ��
	@Test(timeout=1000)
	public void test03() {
		try {
			Thread.sleep(1100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("DDDDDDDDDDDDD");
	}
}
