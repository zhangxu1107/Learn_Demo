package cn.zx.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zx.util.CookieUtil;

/**
 *	���Ӷ��� ��ʾ��Ʒ�����¼��
 * Servlet implementation class ProductInfoServlet
 */
public class ProductInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//��ȡ����ǰ�û�׼���������Ʒid
		String id = request.getParameter("id");
		
		Cookie[] cookies = request.getCookies();
		Cookie cookie = CookieUtil.findCookie(cookies, "history");
		
		//��һ�����
		if(cookie == null) {
			//1. ��Ӧ����cookie
			Cookie c = new Cookie("history", id);
			//������Ч��
			c.setMaxAge(60*60*24*7);
			//���÷���������̵�ʱ�򣬲Ŵ�cookie����
			c.setPath("/Web_CookieDemo_02");
			response.addCookie(c);
			//2. ��ת���������
			//response.sendRedirect("product_info.htm");
		}else {
			//�ڶ���
			//1. ��ȡ��ǰ��cookie,��Ϊ��ǰ��cookie�����������¼
			String ids = cookie.getValue();
			//2. �������������Ʒ����ǰ�������Ʒ���γ��µ�cookieֵ
			cookie.setValue(id + "#" + ids);
			//������Ч��
			cookie.setMaxAge(60*60*24*7);
			//���÷���������̵�ʱ�򣬲Ŵ�cookie����
			cookie.setPath("/Web_CookieDemo_02");
			response.addCookie(cookie);
		}
		//3.��ת
		response.sendRedirect("product_info.htm");
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
