package cn.zx.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo_02 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.�������Զ���
		Properties properties = new Properties();
		
		//2.ָ�����������Դ
		/*
		 * �˴���������ȡweb�����µ���Դ������ͨ��FileInputStream д���ǲ�OK �ġ�
		 * ��Ϊ·�������ˡ�  ������Ե�·������ʵ�Ǹ���jre��ȷ���ġ� ������������һ��web���̣�
		 * jre �������tomcat������������������Ե�·���� tomcat�����binĿ¼
		 */
		InputStream is = new FileInputStream("classes/config.properties");
		properties.load(is);
		
		//3.��ȡ���Ե�ֵ
		String name = properties.getProperty("name");
		
		System.out.println("name=" + name);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
