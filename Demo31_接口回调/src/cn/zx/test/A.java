package cn.zx.test;

/**
 * 1988年写
 * @author 10831
 *
 */
public class A {
	public void print() {
		for (int i = 0; i < 10; i++) {
			System.out.println("循环到了--" + i);
			if (i == 5) {
				System.out.println("循环到了5了，该通知B 了。");
				B b = new B();
				b.printFive();
			}
		}
	}
}
