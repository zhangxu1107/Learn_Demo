package cn.zx.test05;


//�൱��mysql������,�ȸ�����������Աʵ����
public final class GoogleCar implements ICar{

	public void fly(){}
	
	
	@Override
	public String start(int a,int b) {
		
		System.out.println("���ƹȸ����������");
		//���ùȸ������ṩ��C���Ժ���
		
		return "start...."+a+" "+b;
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
