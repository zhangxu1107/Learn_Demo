package cn.zx.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 	��չ��ﳵ
 * Servlet implementation class ClearCartServlet
 */
public class ClearCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//1.ǿ�Ƹɵ��Ự�������ŵ��κ����ݶ�û����
		session.invalidate();
		
		//2.��session���Ƴ�ĳһ������
		//session.removeAttribute("cart");
		
		//��ת�ع��ﳵ
		response.sendRedirect("cart.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
