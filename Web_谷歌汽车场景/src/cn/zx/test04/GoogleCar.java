package cn.zx.test04;


//�൱��mysql������,�ȸ�����������Աʵ����
public final class GoogleCar implements ICar{

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
