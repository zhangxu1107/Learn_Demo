package cn.zx.��������;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DogFactory df = new DogFactory();
		Dog d = (Dog) df.createAnimal();
		d.eat();
	}

}
