package cn.zx.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo_01
 * Cookie�ļ�ʹ��
 */
public class Demo_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Cookie�ļ�ʹ��
		
		//cookie���͸��ͻ��ˣ����ұ����ڿͻ����ϵ�һ��С����
		
		response.setContentType("text/html;charset=UTF-8");
		
		/*
		 *��������Ҫʲô�͸�ʲô������
		 *
		 * ��������ļ����ַ�
		 * 1.ֱ��new
		 * 2.����ģʽ|�ṩ��̬����
		 * 3.����ģʽ���� stu
		 * StuFactory StuBuilder
		 */
		
		Cookie cookie = new Cookie("aa", "bb");
		
		//����Ӧ�����һ��cookie
		response.addCookie(cookie);
		
		response.getWriter().write("����ɹ��ˡ�������");
		
		//��ȡ�ͻ��˴�������cookie
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
