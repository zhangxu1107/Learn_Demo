package cn.zx.¶¯Ì¬´úÀí;

import java.lang.reflect.Proxy;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserImp ui = new UserImp();
		ui.add();
		ui.delete();
		
		System.out.println("-------------------------------");
		/*
		 * public static Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,
		 * InvocationHandler h)
		 */
		MyInvocationHandler m = new MyInvocationHandler(ui);
		User u = (User)Proxy.newProxyInstance(ui.getClass().getClassLoader(), ui.getClass().getInterfaces(), m);
		u.add();
		u.delete();
		System.out.println("-------------------------------");
		StudentImp si = new StudentImp();
		si.login();
		si.submit();
		
		System.out.println("-------------------------------");
		MyInvocationHandler m1 = new MyInvocationHandler(si);
		Student s = (Student)Proxy.newProxyInstance(si.getClass().getClassLoader(), si.getClass().getInterfaces(), m1);
		
		s.login();
		s.submit();
	}

}
