package cn.zx.test03;

public class MyCar extends GoogleCar{
	@Override
	public void start() {
		System.out.println("判断天气是否良好");
		System.out.println("判断路况是否良好");
		super.start();
	}
}
