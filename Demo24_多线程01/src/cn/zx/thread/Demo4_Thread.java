package cn.zx.thread;

/**
 * �����Ȳ���ʵ���̵߳����ַ�ʽ
 * @author 10831
 *
 */
public class Demo4_Thread {

	public static void main(String[] args) {
		new Thread() {										//1,�̳�Thread��
			public void run() {								//2,��дrun����
				for(int i = 0; i < 1000; i++) {				//3,��Ҫִ�еĴ���д��run������
					System.out.println("aaaaaaaaaaaaaa");
				}
			}
		}.start();											//4,�����߳�
		
		new Thread(new Runnable() {							//1,��Runnable��������󴫵ݸ�Thread�Ĺ��췽��
			public void run() {								//2,��дrun����
				for(int i = 0; i < 1000; i++) {				//3,��Ҫִ�еĴ���д��run������
					System.out.println("bb");
				}
			}
		}).start();	
	}

}
