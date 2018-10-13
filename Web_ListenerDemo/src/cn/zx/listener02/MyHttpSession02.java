package cn.zx.listener02;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MyHttpSession02 implements HttpSessionAttributeListener{

//	removeAttribute
//	setAttribute("name" ,aa )
//	setAttribute("name" , bb)
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("MyHttpSession02属性被添加进来了");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("MyHttpSession02属性被移除了");
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("MyHttpSession02属性被替换了");
	}

}
