package cn.zx.test03;


//�൱��mysql������,�ȸ�����������Աʵ����
public class GoogleCar implements ICar{

	@Override
	public void start() {
		
		System.out.println("���ƹȸ����������");
		//���ùȸ������ṩ��C���Ժ���
	}

	@Override
	public void run() {
		System.out.println("���ƹȸ����������");
		
	}

	@Override
	public void stop() {
		System.out.println("���ƹȸ������ֹͣ");
	}

}
