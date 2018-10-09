package cn.zx.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3578436290277749381L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. ��ȡ����
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println("userName=" + userName + "==password=" + password);
		// 2. У������

		// ��ͻ����������
		PrintWriter pw = response.getWriter();

		if ("admin".equals(userName) && "123".equals(password)) {
			System.out.println("��¼�ɹ�");
            //pw.write("login success..");
			// �ɹ�����ת��login_success.html

			// 1. �ɹ��Ĵ����ۼ�

			// ��ȡ��ǰ���ֵ �� Ȼ���ھɵ�ֵ������ + 1
			Object obj = getServletContext().getAttribute("count");

			// Ĭ�Ͼ���0��
			int totalCount = 0;
			if (obj != null) {
				totalCount = (Integer) obj;
			}

			System.out.println("��֪��¼�ɹ��Ĵ����ǣ�" + totalCount);

			// �����count���µ�ֵ
			getServletContext().setAttribute("count", totalCount + 1);

			// 2. ��ת���ɹ��Ľ���
			// ����״̬��? ���¶�λ ״̬��
			response.setStatus(302);
			// ��λ��ת��λ������һ��ҳ�档
			response.setHeader("Location", "login_success.html");
		} else {
			pw.write("login failed..");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
