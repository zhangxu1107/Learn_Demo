package cn.zx.test;

/**
 * 1988��д
 * @author 10831
 *
 */
public class A {
	public void print() {
		for (int i = 0; i < 10; i++) {
			System.out.println("ѭ������--" + i);
			if (i == 5) {
				System.out.println("ѭ������5�ˣ���֪ͨB �ˡ�");
				B b = new B();
				b.printFive();
			}
		}
	}
}
