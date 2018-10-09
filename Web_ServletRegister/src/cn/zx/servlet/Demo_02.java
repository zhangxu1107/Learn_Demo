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
		//1.创建属性对象
		Properties properties = new Properties();
		
		//2.指定载入的数据源
		/*
		 * 此处，如果想获取web工程下的资源，用普通的FileInputStream 写法是不OK 的。
		 * 因为路径不对了。  这里相对的路径，其实是根据jre来确定的。 但是我们这是一个web工程，
		 * jre 后面会由tomcat管理，所以这里真正相对的路径是 tomcat里面的bin目录
		 */
		InputStream is = new FileInputStream("classes/config.properties");
		properties.load(is);
		
		//3.获取属性的值
		String name = properties.getProperty("name");
		
		System.out.println("name=" + name);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
