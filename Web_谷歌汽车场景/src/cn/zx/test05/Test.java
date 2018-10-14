package cn.zx.test05;

import java.lang.reflect.Method;

public class Test {
	public static void main(String[] args) {
		// 获取谷歌Car googleCar.class字节码文件上所有的接口,googlecar其上可能实现了多个接口
		Class[] clazz = GoogleCar.class.getInterfaces();
		
		//由于当前案例中谷歌Car仅实现了一个接口ICar
		//以下代码相当于获取到了ICar.class字节码对象
		Class cla=clazz[0];
		//获取ICar.class字节码对象上所有的方法
		Method[] mds = cla.getMethods();
		for (Method method : mds) {
			System.out.println(method.getName());
		}
	}
}
