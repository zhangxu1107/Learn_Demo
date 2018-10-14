package cn.zx.test05;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

//动态代理解决装饰者模式遇到的问题
public class TestCar {
	public static void main(String[] args) {
		
		//1param: 固定值: 告诉虚拟机用哪个字节码加载器加载内存中创建出的字节码文件
		//2param: 告诉虚拟机内存中正在被创建的字节码文件中应该有哪些方法
		//3param: 告诉虚拟机正在被创建的字节码上的各个方法如何处理
		ICar car=(ICar)Proxy.newProxyInstance(TestCar.class.getClassLoader(), GoogleCar.class.getInterfaces(),new InvocationHandler() {
			
			//method:代表正在执行的方法
			//args:代表正在执行的方法中的参数
			//Object:代表方法执行完毕之后的返回值
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				//经过测试得知:method代表当前正在执行的每个方法
				//System.out.println(method.getName());
				//执行当前的方法
				//method.invoke(new GoogleCar(), args);
				
				
				//代表每个方法执行完毕之后返回对象
				Object obj=null;
				
				if(method.getName().equalsIgnoreCase("start")){
					System.out.println("检查天气是否良好");

					//打印args中的内容
					System.out.println(Arrays.toString(args));
					
					obj=method.invoke(new GoogleCar(), args);
					System.out.println("检查路况是否拥堵");
					
				}else{
					obj=method.invoke(new GoogleCar(), args);	
				}
				return obj;
			}
		});
		
		String cc=car.start(1,4);
		System.out.println(cc);
		car.run();
		car.stop();
		
	}
}


class MyCC implements InvocationHandler{

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}
	
}