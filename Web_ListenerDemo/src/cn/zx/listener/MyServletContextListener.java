package cn.zx.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener{

	//��ʼ����ʱ�����
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("servletContext ��ʼ����...");
	}

	//���ٵ�ʱ�����
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("servletContext ������...");
	}
	
	
}
