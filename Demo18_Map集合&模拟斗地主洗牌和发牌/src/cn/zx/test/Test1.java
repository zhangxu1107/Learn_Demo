package cn.zx.test;

import java.util.HashMap;
import java.util.Scanner;

public class Test1 {

	/**
	 * * A:������ʾ
	 * ����ͳ���ַ�����ÿ���ַ����ֵĴ���
	 * 
	 * ����:
	 * 1,����һ����Ҫ��ͳ���ַ����ַ���
	 * 2,���ַ���ת��Ϊ�ַ�����
	 * 3,����˫�м���,�洢�ַ������ַ��Լ��ַ����ֵĴ���
	 * 4,�����ַ������ȡÿһ���ַ�,�����ַ��洢��˫�м�����
	 * 5,�洢������Ҫ���ж�,��������в����������,�ͽ����ַ�������,ֵΪ1�洢,��������а��������,�ͽ�ֵ��1�洢
	 * 6,��ӡ˫�м��ϻ�ȡ�ַ����ֵĴ���
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.println("������һ���ַ�����");
        //1,����һ����Ҫ��ͳ���ַ����ַ���
        String s = sc.nextLine();
        //2,���ַ���ת��Ϊ�ַ�����
        char[] arr = s.toCharArray();
        //3,����˫�м���,�洢�ַ������ַ��Լ��ַ����ֵĴ���
        HashMap<Character, Integer> hm = new HashMap<>();
        //4,�����ַ������ȡÿһ���ַ�,�����ַ��洢��˫�м�����
        for (char c : arr) {
        	//5,�洢������Ҫ���ж�,��������в����������,�ͽ����ַ�������,ֵΪ1�洢,��������а��������,�ͽ�ֵ��1�洢
/*        	if(!hm.containsKey(c)) {	//��������������
        		hm.put(c, 1);      //�����ַ�������,ֵΪ1�洢
        	}else {
        		hm.put(c, hm.get(c) + 1);  //��������а��������,�ͽ�ֵ��1�洢
        	}*/
        	hm.put(c, !hm.containsKey(c) ? 1 : hm.get(c) + 1);
		}
      //6,��ӡ˫�м��ϻ�ȡ�ַ����ֵĴ���
        for (Character key : hm.keySet()) {         //hm.keySet()�������м��ļ���
        	System.out.println(key + "=" + hm.get(key));//hm.get(key)���ݼ���ȡֵ
		}
	}

}
