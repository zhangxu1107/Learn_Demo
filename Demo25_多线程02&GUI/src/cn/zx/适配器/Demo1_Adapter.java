package cn.zx.������;

public class Demo1_Adapter {

	/**
	 * @param args
	 * ���������ģʽ
	 * ³����
	 */
	public static void main(String[] args) {
		³���� lzs = new ³����();
		lzs.ϰ��();
		lzs.�();
	}

}

interface ���� {
	public void ����();
	public void �();
	public void ײ��();
	public void ϰ��();
}

abstract class ����� implements ���� {		//�����ɳ����ԭ����,�����������ഴ���������,��Ϊ����Ҳû������,�������ǿյ�

	@Override
	public void ����() {
	}

	@Override
	public void �() {
	}

	@Override
	public void ײ��() {
	}

	@Override
	public void ϰ��() {
	}
	
}

class ³���� extends ����� {
	public void ϰ��() {
		System.out.println("���δ�����");
		System.out.println("ȭ�������");
		System.out.println("����Ұ����");
		System.out.println("......");
	}
	
	public void �() {
		System.out.println("���Ӳ���");
	}
}