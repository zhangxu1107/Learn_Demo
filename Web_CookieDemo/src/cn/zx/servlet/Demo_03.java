package cn.zx.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zx.util.CookieUtil;

/**
 * Servlet implementation class Demo_03
 *	 ����һ ��ʾ������ʵ�ʱ�䡣
 */
public class Demo_03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		
		if("admin".equals(userName) && "123".equals(passWord)) {
			//��ȡcookie  last-name --- >
			Cookie[] cookies = request.getCookies();
			
			//�����������ҳ�������Ҫ��cookie
			Cookie cookie = CookieUtil.findCookie(cookies, "last");
			
			//�ǵ�һ�ε�¼��û��cookie
			if(cookie==null) {
				Cookie c = new Cookie("last", System.currentTimeMillis() + "");
				c.setMaxAge(60 * 60); //һ��Сʱ
				response.addCookie(c);
				response.getWriter().write("��ӭ����" + userName);
			}else {
				//1. ȥ��ǰ��cookie�ڶ��ε�¼����cookie
				long lastVisitTime = Long.parseLong(cookie.getValue());
				//2. ��������棬
				response.getWriter().write("��ӭ����" + userName + ",�ϴε�¼ʱ���ǣ�" + new Date(lastVisitTime));
				//3. ���õ�¼��ʱ��
				cookie.setValue(System.currentTimeMillis() + "");
				response.addCookie(cookie);
			}	
		}else {
			response.getWriter().write("��¼ʧ�ܣ�");			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
