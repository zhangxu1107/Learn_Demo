package cn.zx.test02;

/**
 * 2018年写
 * @author 10831
 *
 */
public class B implements PrintListener{
	public void printFive(){
		System.out.println("A已经循环到了5， 所以B的这个方法将被调用");
	}

	@Override
	public void print() {
		System.out.println("2018年。。。A已经循环到了5， 所以B的这个方法将被调用");
	}
}
