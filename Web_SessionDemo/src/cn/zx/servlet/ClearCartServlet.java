package cn.zx.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 	清空购物车
 * Servlet implementation class ClearCartServlet
 */
public class ClearCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//1.强制干掉会话，里面存放的任何数据都没有了
		session.invalidate();
		
		//2.从session中移除某一个数据
		//session.removeAttribute("cart");
		
		//跳转回购物车
		response.sendRedirect("cart.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
