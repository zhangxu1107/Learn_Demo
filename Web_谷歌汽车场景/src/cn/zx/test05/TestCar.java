package cn.zx.test05;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

//��̬������װ����ģʽ����������
public class TestCar {
	public static void main(String[] args) {
		
		//1param: �̶�ֵ: ������������ĸ��ֽ�������������ڴ��д��������ֽ����ļ�
		//2param: ����������ڴ������ڱ��������ֽ����ļ���Ӧ������Щ����
		//3param: ������������ڱ��������ֽ����ϵĸ���������δ���
		ICar car=(ICar)Proxy.newProxyInstance(TestCar.class.getClassLoader(), GoogleCar.class.getInterfaces(),new InvocationHandler() {
			
			//method:��������ִ�еķ���
			//args:��������ִ�еķ����еĲ���
			//Object:������ִ�����֮��ķ���ֵ
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				//�������Ե�֪:method����ǰ����ִ�е�ÿ������
				//System.out.println(method.getName());
				//ִ�е�ǰ�ķ���
				//method.invoke(new GoogleCar(), args);
				
				
				//����ÿ������ִ�����֮�󷵻ض���
				Object obj=null;
				
				if(method.getName().equalsIgnoreCase("start")){
					System.out.println("��������Ƿ�����");

					//��ӡargs�е�����
					System.out.println(Arrays.toString(args));
					
					obj=method.invoke(new GoogleCar(), args);
					System.out.println("���·���Ƿ�ӵ��");
					
				}else{
					obj=method.invoke(new GoogleCar(), args);	
				}
				return obj;
			}
		});
		
		String cc=car.start(1,4);
		System.out.println(cc);
		car.run();
		car.stop();
		
	}
}


class MyCC implements InvocationHandler{

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}
	
}