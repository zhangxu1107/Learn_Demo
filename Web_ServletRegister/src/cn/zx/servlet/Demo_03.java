package cn.zx.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo_03 extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		demo1();

		demo2();

		demo3();
	}

	/**
	 * ����classloaderȥ��ȡ�����µ���Դ    ���������JDBC��
	 */
	private void demo3() {
		try {
			// 1. �������Զ���
			Properties properties = new Properties();
			
			/*
			 * ServletContext
			 * a·��--������tomcat�����Ŀ¼
			 * D:\tomcat\apache-tomcat-7.0.52\apache-tomcat-7.0.52\wtpwebapps\Demo03
			 * 
			 * ClassLoader 
			 * a·���� D:\tomcat\apache-tomcat-7.0.52\apache-tomcat-7.0.52\wtpwebapps\Demo03\WEB-INF\classes
			 * 
			 * Ĭ�ϵ�lcassloader ��·�����������·�������Ǳ���ûص�Demo03���Ŀ¼�£����ܽ���fileĿ¼����λص���һ��Ŀ¼�أ�
			 *  ../../  ---  D:\tomcat\apache-tomcat-7.0.52\apache-tomcat-7.0.52\wtpwebapps\Demo03
			 * ../../file/config.properties  --- D:\tomcat\apache-tomcat-7.0.52\apache-tomcat-7.0.52\wtpwebapps\Demo03\file\config.properties

			 * b·���� D:\tomcat\apache-tomcat-7.0.52\apache-tomcat-7.0.52\wtpwebapps\Demo03\file\config.properties
			 */
			
			//System.out.println(getClass().getClassLoader());
			
			//��ȡ��java�ļ���class ��Ȼ���ȡ���������class��������е��Ǹ������������
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("../../file/config.properties");
			properties.load(is);
			// 3. ��ȡname���Ե�ֵ
			String name = properties.getProperty("name");
			System.out.println("�����ַ�����ȡname=" + name);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �������·����ֱ�ӻ�ȡ������
	 */
	private void demo2() {
		try {
			// ��ȡServletContext����
			ServletContext context = getServletContext();

			// 1. �������Զ���
			Properties properties = new Properties();

			// ��ȡweb�����µ���Դ��ת���������� ǰ�����ص�ǰ���̵ĸ�Ŀ¼��
			/*
			 * ���·�� ���в���� ���˭?
			 * 
			 * ������tomcat����ĸ�Ŀ¼��
			 * 
			 * a·��--������tomcat�����Ŀ¼
			 * D:\tomcat\apache-tomcat-7.0.52\apache-tomcat-7.0.52\wtpwebapps\Demo03 b·��---
			 * file\config.properties
			 * 
			 * D:\tomcat\apache-tomcat-7.0.52\apache-tomcat-7.0.52\wtpwebapps\Demo03\file\
			 * config.properties
			 * 
			 * 
			 * ����·�� (û�в�����)
			 * 
			 * D:\tomcat\apache-tomcat-7.0.52\apache-tomcat-7.0.52\wtpwebapps\Demo03\file\
			 * config.properties
			 * 
			 */
			InputStream is = context.getResourceAsStream("file/config.properties");
			properties.load(is);
			// 3. ��ȡname���Ե�ֵ
			String name = properties.getProperty("name");
			System.out.println("��һ�ַ�����ȡname=" + name);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �Ȼ�ȡ·�����ڻ�ȡ������
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void demo1() throws FileNotFoundException, IOException {
		// ��ȡSrevletContext����
		ServletContext context = getServletContext();
		// ��ȡ�������ļ��ڷ���������ľ���·����
		String path = context.getRealPath("file/config.properties");
		System.out.println("path=" + path);

		// 1.�������Զ���
		Properties properties = new Properties();

		// 2.ָ�����������Դ
		InputStream is = new FileInputStream(path);
		properties.load(is);

		// 3.��ȡ���Ե�ֵ
		String name = properties.getProperty("name");

		System.out.println("��һ�ַ�����ȡname=" + name);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
