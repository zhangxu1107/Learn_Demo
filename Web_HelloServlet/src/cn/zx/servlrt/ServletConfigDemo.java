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

		// 1. 获取该servlet配置的参数。
		ServletConfig config = getServletConfig();
		String number = config.getInitParameter("number");

		if (number == null) {
			throw new IllegalArgumentException("servlet在配置的时候，一定要写number这个参数。。");
		} else {
			System.out.println("number....");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
