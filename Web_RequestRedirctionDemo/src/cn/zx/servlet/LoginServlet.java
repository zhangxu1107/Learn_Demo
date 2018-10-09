package cn.zx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		
		if("admin".equals(userName) && "123".equals(passWord)) {
			//response.getWriter().write("登录成功！");
			/*
			//早期的写法
			response.setStatus(302);
			response.setHeader("Location", "login_success.html");
			*/
			
			//重定向写法
			response.sendRedirect("login_success.html");
			
			//请求转发的写法：
			//request.getRequestDispatcher("login_success.html").forward(request, response);
		}else {
			response.getWriter().write("登录失败！");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
