package cn.zx.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zx.dao.UserDao;
import cn.zx.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class CheckUserNameServlet
 */
public class CheckUserNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			request.setCharacterEncoding("UTF-8");
			
			//1. ����Ƿ����
			String name = request.getParameter("name");
			System.out.println("name="+name);
			
			UserDao dao = new UserDaoImpl();
			boolean isExist = dao.checkUserName(name);
			
			//2.  ֪ͨҳ�棬�����л���û�С�
			if(isExist){
				response.getWriter().println(1);  //�����û���
			}else{
				response.getWriter().println(2); //�����ڸ��û���
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
