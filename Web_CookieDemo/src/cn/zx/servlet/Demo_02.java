package cn.zx.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo_02
 */
public class Demo_02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//ȡ�ͻ��˷��͹�����cookie.
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getName()+" = "+cookie.getValue());
			}
		}
		
		//1. ��дcookie ���Ը��ͻ��˷��ض��cookie
		Cookie cookie = new Cookie("name", "����");
		response.addCookie(cookie);
		
		
		//2. ���cookie����Ч�ڡ�  Ĭ������� ��
		//�ر��������cookie��û���ˡ� ---> ���û������cookie����Ч�ڡ�
		//	expiry�� ��Ч ������㡣
		//��ֵ �� ��ʾ ��������ֹ���cookie����ʧЧ��
		//��ֵ�� �ر����������ôcookie��ʧЧ�� Ĭ��ֵ�� -1
		cookie.setMaxAge(60 * 60 * 24 * 7);
		//��ֵ�µ�ֵ
		//cookie.setValue(newValue);
				
		//����ָ��ֻ��������ָ�����������Ż���ϸ�cookie
		cookie.setDomain(".itheima.com");
				
		//ֻ�з��ʸ������µ�cookieDemo�����·����ַ�Ż��cookie
		cookie.setPath("/CookieDemo");
				
		response.addCookie(cookie);
		
		Cookie cookie2 = new Cookie("age", "23");
		response.addCookie(cookie2);
		
		
		response.getWriter().write("hello Cookie...");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
