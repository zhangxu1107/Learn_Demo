package cn.zx.test02;

public class A {
	
	/**
	 * ������ǰ��java����ʹ�õĴ��롣
	 * ���Ǽ������A������������ϸ�����80�� ��д�õ�A�࣬ ������� �ڲ��ǲ���ֱ��new B()
	 * 1. ����ֱ��new B
	 * 
	 * 2. ҳ���ܴ���B��ʵ��������
	 * 
	 * �����ڶ������������ʱ�򣬲���δ��д����B �࣬ ����C�࣬����D�࣬ �˼�Ϊ��ͨ�á�
	 * ���Զ�����һ�ֽӿڣ�ֻҪ��δ������Щ�࣬ʵ������ӿڡ� Ȼ����������Ĳ���д �ӿ����ͼ��ɡ�
	 */
	
/*	public void print() {
		for (int i = 0; i < 10; i++) {
			System.out.println("ѭ������--" + i);
			if (i == 5) {
				System.out.println("ѭ������5�ˣ���֪ͨB �ˡ�");
				B b = new B();
				b.printFive();
			}
		}
	}
*/
	
	public void print(PrintListener listener){
		for (int i = 0; i < 10; i++) {
			System.out.println("����1988��Ϳ�ʼ��ӡ�������ˡ���ѭ������--"+i);
			if(i == 5){
				System.out.println("ѭ������5�ˣ���֪ͨB �ˡ�");
				listener.print();
				/*B b = new B();
				b.printFive();*/
			}
		}
	}
}
