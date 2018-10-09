package cn.zx.threadmethod;

/**
 * 获取当前线程的对象
 * @author 10831
 *
 */
public class Demo2_CurrentThread {

	public static void main(String[] args) {
		new Thread() {
			public void run() {
				this.setName("张三");
				System.out.println(getName() + "aaaaaaaa");
			}
		}.start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				//Thread.currentThread();   //获取当前正在执行的线程
				System.out.println(Thread.currentThread().getName() + "...bb");
			}
		}).start();
		
		Thread.currentThread().setName("我是主线程");
		System.out.println(Thread.currentThread().getName());
	}
	
	
}
