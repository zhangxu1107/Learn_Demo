package cn.zx.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo01
 */
public class ServletDemo01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ�ͻ����ύ������˵�method��Ӧ��ֵ
		String md = request.getParameter("method");
		// �������,��Ź���ִ�����֮��Ҫת����·��
		String path = null;

		// ͨ���ж�md�в�ͬ���������������ι���
		if ("addStu".equals(md)) {
			path = addStu(request, response);
		} else if ("delStu".equals(md)) {
			path = delStu(request, response);
		} else if ("checkStu".equals(md)) {
			path = checkStu(request, response);
		} else if ("".equals(md)) {

		}
		if (null != path) {
			// ����˵�ת��
			request.getRequestDispatcher(path).forward(request, response);
		}
	}
	
	protected String addStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("���ѧ��");
		return "/test.html";
		
	}
	protected String delStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ɾ��ѧ��");
		return "/test.html";
		
	}
	protected String checkStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("���ѧ��");
		response.getWriter().println("DDDDDD");
		return null;
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
