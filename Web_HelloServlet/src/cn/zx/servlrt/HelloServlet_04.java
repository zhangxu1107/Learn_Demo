package cn.zx.servlrt;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * ��servlet ������servlet����ʵ����ʱ����ǰ��
 */
public class HelloServlet_04 implements Servlet{

	
	/**
	 * servlet���ٵ�ʱ�򣬾ͻ�ִ�и÷���
	 * 
	 * 	1. ����Ŀ��tomcat�������Ƴ���
	 * 	2. �����ر�tomcat�ͻ�ִ�� shutdown.bat
	 */
	@Override
	public void destroy() {
		System.out.println("helloservlet04  destroy����������");
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

	
	//1�� 
	//�ڴ�����servlet��ʵ��ʱ����ִ�и÷�����
	//һ��servletֻ���ʼ��һ�Σ� init����ֻ��ִ��һ��
	//Ĭ��������� �� ���η��ʸ�servlet���Żᴴ��ʵ���� 
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("HelloServlet04 ��ʼ��...");
	}

	//2.
	/*
	 * 	ֻҪ�ͻ�������һ��������ô��ִ����������ˡ�
	 * �÷������Ա�ִ�кܶ�Ρ� һ�����󣬶�Ӧһ��service�����ĵ���
	 */
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("helloservlet04  service����������");
	}
	
	
}
