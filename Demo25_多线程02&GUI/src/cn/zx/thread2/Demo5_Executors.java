package cn.zx.thread2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo5_Executors {

	/**
	 * public static ExecutorService newFixedThreadPool(int nThreads)
	 * public static ExecutorService newSingleThreadExecutor()
	 * *�̳߳صĸ�����ʹ��
	 */
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(2);//�����̳߳�
		pool.submit(new MyRunnable());				//���̷߳Ž������ﲢִ��
		pool.submit(new MyRunnable());
		
		pool.shutdown();							//�ر��̳߳�
	}

}
