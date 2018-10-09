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

		//取客户端发送过来的cookie.
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getName()+" = "+cookie.getValue());
			}
		}
		
		//1. 先写cookie 可以给客户端返回多个cookie
		Cookie cookie = new Cookie("name", "张三");
		response.addCookie(cookie);
		
		
		//2. 这个cookie的有效期。  默认情况下 ，
		//关闭浏览器后，cookie就没有了。 ---> 针对没有设置cookie的有效期。
		//	expiry： 有效 以秒计算。
		//正值 ： 表示 在这个数字过后，cookie将会失效。
		//负值： 关闭浏览器，那么cookie就失效， 默认值是 -1
		cookie.setMaxAge(60 * 60 * 24 * 7);
		//赋值新的值
		//cookie.setValue(newValue);
				
		//用于指定只有请求了指定的域名，才会带上该cookie
		cookie.setDomain(".itheima.com");
				
		//只有访问该域名下的cookieDemo的这个路径地址才会带cookie
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
