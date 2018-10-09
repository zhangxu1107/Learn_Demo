package cn.zx.¼òµ¥¹¤³§;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
/*		Dog d = AnimalFactory.createDog();
		d.eat();*/
		
		Dog d = (Dog) AnimalFactory.createAnimal("dog");
		d.eat();
		
		Cat c = (Cat) AnimalFactory.createAnimal("cat");
		c.eat();
	}

}
