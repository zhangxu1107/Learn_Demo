package cn.zx.test01;

public class TestCar {
	public static void main(String[] args) {
		 ICar car=new GoogleCar();
		 car.start();
		 car.run();
		 car.stop();
	}
}
