package cn.zx.test;

import java.util.ArrayList;
import java.util.Collections;

public class Test2 {

	/**
	 * * A:������ʾ
	 * ģ�⶷����ϴ�ƺͷ��ƣ���û������
	 * 
	 * ����:
	 * 1,��һ���˿�,��ʵ�����Լ�����һ�����϶���,���˿��ƴ洢��ȥ
	 * 2,ϴ��
	 * 3,����
	 * 4,����
	 */
	public static void main(String[] args) {
		//1,��һ���˿�,��ʵ�����Լ�����һ�����϶���,���˿��ƴ洢��ȥ
        String[] num = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] color = {"����","����","��Ƭ","÷��"};
        ArrayList<String> poker = new ArrayList<>();
        
        //ƴ�ӻ�ɫ������
        for (String s1 : color) {
			for (String s2 : num) {
				poker.add(s1.concat(s2));		//concat���������ַ���
			}
		}
        poker.add("����");
        poker.add("С��");
        System.out.println("ȫ���ƣ�" + poker);
        
        //2,ϴ��
      	Collections.shuffle(poker);
      	
        //3,����
      	ArrayList<String> gaojin = new ArrayList<>();
      	ArrayList<String> longwu = new ArrayList<>();
      	ArrayList<String> me = new ArrayList<>();
		ArrayList<String> dipai = new ArrayList<>();  //����
      	for(int i = 0; i<poker.size(); i++) {
      		if(i >= poker.size() - 3) {
      			dipai.add(poker.get(i));  //�����ŵ��ƴ洢�ڵ��Ƽ�����
      		}else if (i % 3 == 0) {
				gaojin.add(poker.get(i));
			}else if (i % 3 == 1) {
				longwu.add(poker.get(i));
			}else {
				me.add(poker.get(i));
			}
      	}
      	
        //4,����
      	System.out.println("�߽����ƣ�" + gaojin);
		System.out.println("������ƣ�" + longwu);
		System.out.println("�ҵ��ƣ�" + me);
		System.out.println("���ƣ�" + dipai);

	}

}
