package cn.zx.test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

@SuppressWarnings("resource")
public class Test2 {

	/**
	 * ����¼��һ��int���͵�����,����������Ʊ�����ʽ
	 * ���¼�����������,������ʾ,¼�����������������¼��һ������BigInteger
	 * ���¼�����С��,������ʾ,¼�����С��,������¼��һ������
	 * ���¼����������ַ�,������ʾ,¼����ǷǷ��ַ�,������¼��һ������
	 * 
	 * ����:
	 * 1,��������¼�����
	 * 2,������¼��Ľ���洢��String���͵��ַ�����,�洢int����������в�����������ֱ�ӱ���,�޷����к����ж�
	 * 3,����¼��Ľ��ת����int���͵�����,����ȷ�Ļ��Ǵ����
	 * 4,��ȷ��ֱ��ת��
	 * 5,�����Ҫ���ж�Ӧ�ж�
	 */
	public static void main(String[] args) {
		//1,��������¼�����
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ������:");
			
		while(true) {
			//2,������¼��Ľ���洢��String���͵��ַ�����,�洢int����������в�����������ֱ�ӱ���,�޷����к����ж�
			String line = sc.nextLine();       //������¼��Ľ���洢��line��
			try {
				//3,����¼��Ľ��ת����int���͵�����,����ȷ�Ļ��Ǵ����
				int num = Integer.parseInt(line);               //���ַ���ת��Ϊ����
				System.out.println(num + "�Ķ�����Ϊ��" + Integer.toBinaryString(num));//������ת��Ϊ������
				break;			//����ѭ��
			} catch (Exception e) {
				try {
					new BigInteger(line);
					System.out.println("¼�����,��¼�����һ����������,����������һ������:");
				} catch (Exception e2) {     //alt + shif + z (try catch��ݼ�)
					try {
						new BigDecimal(line);
						System.out.println("¼�����,��¼�����һ��С��,����������һ������:");
					} catch (Exception e3) {
						System.out.println("¼�����,��¼����ǷǷ��ַ�,����������һ������:");
					}
				}
				
			}
		}
		
		
		
		
	}

}
