package cn.zx.servlrt;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 该servlet 用于让servlet创建实例的时机提前。
 */
public class HelloServlet_04 implements Servlet{

	
	/**
	 * servlet销毁的时候，就会执行该方法
	 * 
	 * 	1. 该项目从tomcat的里面移除。
	 * 	2. 正常关闭tomcat就会执行 shutdown.bat
	 */
	@Override
	public void destroy() {
		System.out.println("helloservlet04  destroy方法调用了");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	
	//1、 
	//在创建该servlet的实例时，就执行该方法。
	//一个servlet只会初始化一次， init方法只会执行一次
	//默认情况下是 ： 初次访问该servlet，才会创建实例。 
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("HelloServlet04 初始化...");
	}

	//2.
	/*
	 * 	只要客户端来了一个请求，那么就执行这个方法了。
	 * 该方法可以被执行很多次。 一次请求，对应一次service方法的调用
	 */
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("helloservlet04  service方法调用了");
	}
	
	
}
