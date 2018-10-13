package cn.zx.bean;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Bean01  implements HttpSessionBindingListener{
	private String name ;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("Bean01对象被绑定进来了");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("Bean01对象被解除绑定");
	}
}
