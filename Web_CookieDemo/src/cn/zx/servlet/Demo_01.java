package cn.zx.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo_01
 * Cookie的简单使用
 */
public class Demo_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Cookie的简单使用
		
		//cookie发送给客户端，并且保存在客户端上的一份小数据
		
		response.setContentType("text/html;charset=UTF-8");
		
		/*
		 *方法参数要什么就给什么。对象
		 *
		 * 创建对象的几种手法
		 * 1.直接new
		 * 2.单例模式|提供静态方法
		 * 3.工厂模式构建 stu
		 * StuFactory StuBuilder
		 */
		
		Cookie cookie = new Cookie("aa", "bb");
		
		//给响应，添加一个cookie
		response.addCookie(cookie);
		
		response.getWriter().write("请求成功了。。。。");
		
		//获取客户端带过来的cookie
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (Cookie c : cookies) {
				String cookieName = c.getName();
				String cookieValue = c.getValue();
				
				System.out.println(cookieName + "=" + cookieValue);
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
