package cn.zx.thread;

/**
 * ���߳�ʵ�ֵķ�ʽ1
 * 
 * @author 10831
 *
 */
public class Demo2_Thread {

	public static void main(String[] args) {
		MyThread mt = new MyThread(); // 4,����Thread����������
		mt.start(); // 5,�����߳�

		for (int i = 0; i < 1000; i++) {
			System.out.println("bb");
		}
	}

}

class MyThread extends Thread { // 1,�̳�Thread
	public void run() { // 2,��дrun����
		for (int i = 0; i < 1000; i++) { // 3,��Ҫִ�еĴ���д��run������
			System.out.println("aaaaaaaaaaaa");
		}
	}
}