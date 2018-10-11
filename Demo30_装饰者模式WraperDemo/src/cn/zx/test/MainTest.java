package cn.zx.test;

public class MainTest {
	public static void main(String[] args) {
		/*Waiter waiter = new Waitress();
		waiter.service();*/
		
		
		
		WaitressWrap waitressWrap = new WaitressWrap(new Waitress());
		waitressWrap.service();
		
	}
}
