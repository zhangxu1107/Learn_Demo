package cn.zx.threadmethod;

/**
 * ��ȡ��ǰ�̵߳Ķ���
 * @author 10831
 *
 */
public class Demo2_CurrentThread {

	public static void main(String[] args) {
		new Thread() {
			public void run() {
				this.setName("����");
				System.out.println(getName() + "aaaaaaaa");
			}
		}.start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				//Thread.currentThread();   //��ȡ��ǰ����ִ�е��߳�
				System.out.println(Thread.currentThread().getName() + "...bb");
			}
		}).start();
		
		Thread.currentThread().setName("�������߳�");
		System.out.println(Thread.currentThread().getName());
	}
	
	
}
