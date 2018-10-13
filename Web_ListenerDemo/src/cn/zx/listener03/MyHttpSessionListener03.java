package cn.zx.listener03;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class MyHttpSessionListener03 implements HttpSessionActivationListener {

	//�ۻ�
	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("session���ۻ���...");
	}

	//�
	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("session�����...");
	}

}
