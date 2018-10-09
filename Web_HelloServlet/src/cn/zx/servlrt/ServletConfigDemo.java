package cn.zx.servlrt;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigDemo extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1. ��ȡ��servlet���õĲ�����
		ServletConfig config = getServletConfig();
		String number = config.getInitParameter("number");

		if (number == null) {
			throw new IllegalArgumentException("servlet�����õ�ʱ��һ��Ҫдnumber�����������");
		} else {
			System.out.println("number....");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
