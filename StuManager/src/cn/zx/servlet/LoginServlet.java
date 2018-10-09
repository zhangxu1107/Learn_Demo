package cn.zx.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zx.dao.StuDao;
import cn.zx.dao.UserDao;
import cn.zx.dao.impl.StuDaoImpl;
import cn.zx.dao.impl.UserDaoImpl;
import cn.zx.domain.Student;

/**
 * �������ڴ����¼��servlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// �ύ�������п��������ģ� ��ô����
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		// 1. ��ȡ�ͻ����ύ����Ϣ
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		// 2. ȥ����dao �� �����Ƿ������¼��
		UserDao dao = new UserDaoImpl();
		boolean isSuccess = dao.login(userName, password);

		// 3. ���dao�ķ��ؽ����������Ӧ
		if (isSuccess) {
			// response.getWriter().write("��¼�ɹ�.");

			// 1. ��ѯ�������е�ѧ����Ϣ��
			StuDao stuDao = new StuDaoImpl();
			List<Student> list = stuDao.findAll();

			// 2. �Ȱ�������ϴ浽�������С�
			request.getSession().setAttribute("list", list);

			// 2. �ض���
			response.sendRedirect("stu_list.jsp");

		} else {
			response.getWriter().write("�û��������������");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
