package cn.zx.thread;

public class Demo1_Thread {

	/**
	 * @param args
	 * ֤��jvm�Ƕ��̵߳�
	 */
	public static void main(String[] args) {
		for(int i = 0; i < 100000; i++) {
			new Demo();
		}
		
		for(int i = 0; i < 10000; i++) {
			System.out.println("�������̵߳�ִ�д���");
		}
	}

}

class Demo {

	@Override
	public void finalize() {
		System.out.println("��������ɨ��");
	}
	
}