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
			//response.getWriter().write("��¼�ɹ���");
			/*
			//���ڵ�д��
			response.setStatus(302);
			response.setHeader("Location", "login_success.html");
			*/
			
			//�ض���д��
			response.sendRedirect("login_success.html");
			
			//����ת����д����
			//request.getRequestDispatcher("login_success.html").forward(request, response);
		}else {
			response.getWriter().write("��¼ʧ�ܣ�");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
