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
	 * 根据classloader去获取工程下的资源    类加载器（JDBC）
	 */
	private void demo3() {
		try {
			// 1. 创建属性对象
			Properties properties = new Properties();
			
			/*
			 * ServletContext
			 * a路径--工程在tomcat里面的目录
			 * D:\tomcat\apache-tomcat-7.0.52\apache-tomcat-7.0.52\wtpwebapps\Demo03
			 * 
			 * ClassLoader 
			 * a路径： D:\tomcat\apache-tomcat-7.0.52\apache-tomcat-7.0.52\wtpwebapps\Demo03\WEB-INF\classes
			 * 
			 * 默认的lcassloader 的路径是上面这个路径，我们必须得回到Demo03这个目录下，才能进入file目录。如何回到上一级目录呢？
			 *  ../../  ---  D:\tomcat\apache-tomcat-7.0.52\apache-tomcat-7.0.52\wtpwebapps\Demo03
			 * ../../file/config.properties  --- D:\tomcat\apache-tomcat-7.0.52\apache-tomcat-7.0.52\wtpwebapps\Demo03\file\config.properties

			 * b路径： D:\tomcat\apache-tomcat-7.0.52\apache-tomcat-7.0.52\wtpwebapps\Demo03\file\config.properties
			 */
			
			//System.out.println(getClass().getClassLoader());
			
			//获取该java文件的class ，然后获取到加载这个class到虚拟机中的那个类加载器对象。
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("../../file/config.properties");
			properties.load(is);
			// 3. 获取name属性的值
			String name = properties.getProperty("name");
			System.out.println("第三种方法获取name=" + name);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据相对路径，直接获取流对象
	 */
	private void demo2() {
		try {
			// 获取ServletContext对象
			ServletContext context = getServletContext();

			// 1. 创建属性对象
			Properties properties = new Properties();

			// 获取web工程下的资源，转化成流对象。 前面隐藏当前工程的根目录。
			/*
			 * 相对路径 （有参照物） 相对谁?
			 * 
			 * 工程在tomcat里面的根目录。
			 * 
			 * a路径--工程在tomcat里面的目录
			 * D:\tomcat\apache-tomcat-7.0.52\apache-tomcat-7.0.52\wtpwebapps\Demo03 b路径---
			 * file\config.properties
			 * 
			 * D:\tomcat\apache-tomcat-7.0.52\apache-tomcat-7.0.52\wtpwebapps\Demo03\file\
			 * config.properties
			 * 
			 * 
			 * 绝对路径 (没有参照物)
			 * 
			 * D:\tomcat\apache-tomcat-7.0.52\apache-tomcat-7.0.52\wtpwebapps\Demo03\file\
			 * config.properties
			 * 
			 */
			InputStream is = context.getResourceAsStream("file/config.properties");
			properties.load(is);
			// 3. 获取name属性的值
			String name = properties.getProperty("name");
			System.out.println("第一种方法获取name=" + name);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 先获取路径，在获取流对象
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void demo1() throws FileNotFoundException, IOException {
		// 获取SrevletContext对象
		ServletContext context = getServletContext();
		// 获取给定的文件在服务器上面的绝对路径。
		String path = context.getRealPath("file/config.properties");
		System.out.println("path=" + path);

		// 1.创建属性对象
		Properties properties = new Properties();

		// 2.指定载入的数据源
		InputStream is = new FileInputStream(path);
		properties.load(is);

		// 3.获取属性的值
		String name = properties.getProperty("name");

		System.out.println("第一种方法获取name=" + name);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
