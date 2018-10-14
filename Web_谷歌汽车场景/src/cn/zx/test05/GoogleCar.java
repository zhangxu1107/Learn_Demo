package cn.zx.test05;


//相当于mysql驱动包,谷歌汽车开发人员实现类
public final class GoogleCar implements ICar{

	public void fly(){}
	
	
	@Override
	public String start(int a,int b) {
		
		System.out.println("控制谷歌的汽车启动");
		//调用谷歌汽车提供的C语言函数
		
		return "start...."+a+" "+b;
	}

	@Override
	public void run() {
		System.out.println("控制谷歌的汽车运行");
		
	}

	@Override
	public void stop() {
		System.out.println("控制谷歌的汽车停止");
	}

}
