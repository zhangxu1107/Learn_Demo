package cn.zx.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyRequestListener implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("servletrequest ������");
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("servletrequest ��ʼ����");
	}

}
