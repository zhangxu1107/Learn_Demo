package cn.zx.test04;


//װ����ģʽ
public class MyCar implements ICar{

	
	ICar car;
	
	public MyCar(ICar car) {
		this.car=car;
	}
	
	@Override
	public void start() {
		System.out.println("��������Ƿ�����");
		System.out.println("���·���Ƿ�ӵ��");
		car.start();
	}

	@Override
	public void run() {
		car.run();		
	}

	@Override
	public void stop() {
		car.stop();		
	}

}
