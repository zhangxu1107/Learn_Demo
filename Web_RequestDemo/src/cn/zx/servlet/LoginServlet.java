package cn.zx.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HttpServletRequest������������
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//����һ
		demo01(request);
		
		//������
		demo02(request);
	}

	private void demo02(HttpServletRequest request) throws UnsupportedEncodingException {
		//���˵����������������������ֱ��롣  get��ʽ�������У������� ---> get
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// post�������������봦��
		System.out.println("post : userName=" + username + "==password=" + password);
	}

	/**
	 * 	����get�����������������
	 * @throws UnsupportedEncodingException
	 */
	private void demo01(HttpServletRequest request) throws UnsupportedEncodingException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println("userName=" + username + "==password=" + password);

		// get������������ݣ���url��ַ���Ͼ��Ѿ����������ˣ���������ȡ���ľ������룬
		// tomcat�յ����������ݣ�getParameter Ĭ��ʹ��ISO-8859-1ȥ����

		// �������ֻص�ISO-8859-1��Ӧ���ֽ����� �� Ȼ���ٰ�utf-8��ƴ�ַ���
		username = new String(username.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println("userName=" + username + "==password=" + password);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("����һ��post����...");
		doGet(request, response);
	}

}
