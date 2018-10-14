package cn.zx.test04;

public class TestCar {
	public static void main(String[] args) {
		 ICar car=new MyCar(new GoogleCar());
		 car.start();
		 car.run();
		 car.stop();
	}
}
