package cn.zx.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CleanHistory
 */
public class CleanHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ÑÝÁ·Çå³ýcookie
		Cookie cookie = new Cookie("history", "");
		cookie.setMaxAge(0); //ÉèÖÃÁ¢¼´É¾³ý
		cookie.setPath("/Web_CookieDemo_02");
		response.addCookie(cookie);
		
		response.sendRedirect("product_list.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
