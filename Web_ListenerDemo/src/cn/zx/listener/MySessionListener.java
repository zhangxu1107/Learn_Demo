package cn.zx.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("����session��");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("����session��");
	}

}
