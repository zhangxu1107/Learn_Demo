package cn.zx.test06;

public class TestClassLoader {
	public static void main(String[] args) {
		
		//��ȡString��ļ�����
		ClassLoader classLoader = String.class.getClassLoader();
		System.out.println(classLoader);
		//����String.class ,int.class���ֽ����ļ���ҪƵ���ı������ڴ�,�ٶȱ����,�ײ�������������ʵ��c c++
		
		//��ȡext(extendtion)���µ�ĳ������ֽ��������   ExtClassLoader:��չ�������
		ClassLoader classLoader2 = sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader();
		System.out.println(classLoader2);
	
		//Ӧ����:����Աʵ�ֵ����е��඼����Ӧ����
		//��ȡӦ��������� AppClassLoader
		ClassLoader classLoader3 = TestClassLoader.class.getClassLoader();
		System.out.println(classLoader3);
	}
}
