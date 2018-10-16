package cn.zx.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BaseServlet
 */
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("service.....");
		
		// ��ȡ�ͻ����ύ������˵�method��Ӧ��ֵ
		String md = request.getParameter("method");

		// �������,��Ź���ִ�����֮��Ҫת����·��
		String path = null;

		// ��ȡ����ǰ�ֽ������(ServletDemo02.class���ڴ��ж���)
		Class clazz = this.getClass();
		try {
			// ��ȡclazz������Ϊmd����
			Method method = clazz.getMethod(md, HttpServletRequest.class, HttpServletResponse.class);
			if (null != method) {
				// �����ҵ��ķ���
				path = (String) method.invoke(this, request, response);
			}
			if (null != path) {
				// ����˵�ת��
				request.getRequestDispatcher(path).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
