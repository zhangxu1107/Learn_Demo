package cn.zx.test;

public class Test5 {

	/**
	 * * ��������
	* ���µô���Ԫ1202��˵�𣬻�˵��һλ��������꣬����쳲�������
	* ������һ�������������һ����Ȥ�����⣺����һ�Ըճ�����С��һ���º���ܳ��ɴ��ã��ٹ�һ���¾�������һ��С�ã����Ҵ˺�ÿ���¶���һ��С�ã�һ����û�з���������
	* �ʣ�һ�Ըճ��������ӣ�һ���ڷ�ֳ�ɶ��ٶ�����?
	* 1 1 2 3 5 8 13 21
	* 1 = fun(1)
	* 1 = fun(2)
	* 2 = fun(1) + fun(2)
	* 3 = fun(2) + fun(3)
	 */
	public static void main(String[] args) {
		demo1();
		System.out.println(fun(8));
	}

	private static void demo1() {
		//����������������
		int[] arr = new int[8];
		//�����е�һ��Ԫ�غ͵ڶ���Ԫ�ض�Ϊ1
		arr[0] = 1;
		arr[1] = 1;
		//�������������Ԫ�ظ�ֵ
		for(int i = 2; i < arr.length; i++) {
			arr[i] = arr[i - 2] + arr[i - 1];
		}
		//��λ�ȡ���һ����
		System.out.println(arr[arr.length - 1]);
	}


	/*
	 * �õݹ���쳲���������
	 */
	public static int fun(int num) {
		if(num == 1 || num == 2) {
			return 1;
		}else {
			return fun(num - 2) + fun(num - 1);
		}
	}
}
