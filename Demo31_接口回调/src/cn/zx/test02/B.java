package cn.zx.test02;

/**
 * 2018��д
 * @author 10831
 *
 */
public class B implements PrintListener{
	public void printFive(){
		System.out.println("A�Ѿ�ѭ������5�� ����B�����������������");
	}

	@Override
	public void print() {
		System.out.println("2018�ꡣ����A�Ѿ�ѭ������5�� ����B�����������������");
	}
}
