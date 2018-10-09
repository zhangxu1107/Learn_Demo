package cn.zx.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zx.util.CookieUtil;

/**
 *	例子二： 显示商品浏览记录。
 * Servlet implementation class ProductInfoServlet
 */
public class ProductInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取到当前用户准备浏览的商品id
		String id = request.getParameter("id");
		
		Cookie[] cookies = request.getCookies();
		Cookie cookie = CookieUtil.findCookie(cookies, "history");
		
		//第一次浏览
		if(cookie == null) {
			//1. 响应返回cookie
			Cookie c = new Cookie("history", id);
			//设置有效期
			c.setMaxAge(60*60*24*7);
			//设置访问这个工程的时候，才带cookie过来
			c.setPath("/Web_CookieDemo_02");
			response.addCookie(c);
			//2. 跳转到具体界面
			//response.sendRedirect("product_info.htm");
		}else {
			//第二次
			//1. 获取以前的cookie,因为以前的cookie包含了浏览记录
			String ids = cookie.getValue();
			//2. 让现在浏览的商品和以前浏览的商品，形成新的cookie值
			cookie.setValue(id + "#" + ids);
			//设置有效期
			cookie.setMaxAge(60*60*24*7);
			//设置访问这个工程的时候，才带cookie过来
			cookie.setPath("/Web_CookieDemo_02");
			response.addCookie(cookie);
		}
		//3.跳转
		response.sendRedirect("product_info.htm");
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
