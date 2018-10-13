package cn.zx.listener03;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class MyHttpSessionListener03 implements HttpSessionActivationListener {

	//钝化
	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("session被钝化了...");
	}

	//活化
	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("session被活化了...");
	}

}
