package cn.zx.test02;

public class Test {
	public static void main(String[] args) {
		A a = new A();
		
		//���Ƕ�̬�����֣�
		
		/*
		 * ���������1988��Ͷ�����Ҫ�� printlistener ����ӿڵ����͡�
		 * ��2018���ʱ����һ���� B ʵ��������ӿ�printlistener ��
		 * �������ڿ��Դ���B����
		 */
		a.print(new B());
	}
}
