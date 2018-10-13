package cn.zx.test02;

public class Test {
	public static void main(String[] args) {
		A a = new A();
		
		//这是多态的体现，
		
		/*
		 * 这个方法在1988年就定义了要收 printlistener 这个接口的类型。
		 * 在2018年的时候有一个类 B 实现了这个接口printlistener ，
		 * 所以现在可以传递B进来
		 */
		a.print(new B());
	}
}
