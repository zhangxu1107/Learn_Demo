package cn.zx.reflect;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Demo2_Reflect {

	/**
	 * * 反射（Class.forName()读取配置文件举例）
	 * * 榨汁机(Juicer)榨汁的案例
	 * * 分别有水果(Fruit)苹果(Apple)香蕉(Banana)桔子(Orange)榨汁(squeeze)
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@SuppressWarnings({ "resource", "rawtypes" })
	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		/*
		//没有用反射，只在说多态
		Juicer j = new Juicer();		//创建榨汁机
		j.run(new Apple());        //向榨汁机中放入苹果
		//j.run(new Orange());    //Apple a = new Orange(); 类型不匹配
		
		//在榨汁机类中添加run方法可以接收橘子
		j.run(new Orange());
		*/
		
		//用反射和配置
		Juicer j = new Juicer();		//创建榨汁机
		BufferedReader br = new BufferedReader(new FileReader("config.properties"));
		Class clazz = Class.forName(br.readLine());	//获取该类的字节码文件
		Fruit f = (Fruit) clazz.newInstance();		//创建实例对象,,父类引用指向子类对象，水果的引用指向了苹果对象
		j.run(f);
	}

}

interface Fruit{
	public void squeeze();
}

class Apple implements Fruit {
	public void squeeze() {
		System.out.println("榨出一杯苹果汁");
	}
}

class Orange  implements Fruit {
	public void squeeze() {
		System.out.println("榨出一杯橘子汁儿");
	}
}

class Juicer{
/*	public void run(Apple a) {
		a.squeeze();
	}
	
	public void run(Orange o) {
		o.squeeze();
	}*/
	
	//改进后代码
	public void run(Fruit f) {
		f.squeeze();
	}
}