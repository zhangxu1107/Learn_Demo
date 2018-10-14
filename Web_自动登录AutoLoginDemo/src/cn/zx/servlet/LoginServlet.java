package cn.zx.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zx.bean.UserBean;
import cn.zx.dao.UserDao;
import cn.zx.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
			String autoLogin = request.getParameter("auto_login");
			UserBean user = new UserBean();
			user.setUsername(userName);
			user.setPassword(password);
			
			UserDao dao = new UserDaoImpl();
			UserBean userBean = dao.login(user);
			
			if(userBean != null){
				
				//ҳ���ύ������ʱ���Ƿ�ѡ�����Զ���¼
				if("on".equals(autoLogin)){
					
					//����cookie���ͻ���
					
					Cookie cookie = new Cookie("auto_login", userName+"#"+password);
					cookie.setMaxAge(60*60*24*7);//7����Ч��
					//cookie.setPath("/Web_�Զ���¼AutoLoginDemo");
					cookie.setPath(request.getContextPath());//�õ����ǵ�ǰӦ�õ�����
					response.addCookie(cookie);
					
				}
				
				
				//�ɹ��ˣ�������ҳ
				request.getSession().setAttribute("userBean", userBean);
				response.sendRedirect("index.jsp");
			}else{
				//���ɹ�...
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
