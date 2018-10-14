package cn.zx.test03;

public class TestCar {
	public static void main(String[] args) {
		 ICar car=new MyCar();
		 car.start();
		 car.run();
		 car.stop();
	}
}
