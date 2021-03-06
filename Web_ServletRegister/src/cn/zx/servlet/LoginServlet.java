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
		// 1. 获取数据
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println("userName=" + userName + "==password=" + password);
		// 2. 校验数据

		// 向客户端输出内容
		PrintWriter pw = response.getWriter();

		if ("admin".equals(userName) && "123".equals(password)) {
			System.out.println("登录成功");
            //pw.write("login success..");
			// 成功就跳转到login_success.html

			// 1. 成功的次数累加

			// 获取以前存的值 ， 然后在旧的值基础上 + 1
			Object obj = getServletContext().getAttribute("count");

			// 默认就是0次
			int totalCount = 0;
			if (obj != null) {
				totalCount = (Integer) obj;
			}

			System.out.println("已知登录成功的次数是：" + totalCount);

			// 给这个count赋新的值
			getServletContext().setAttribute("count", totalCount + 1);

			// 2. 跳转到成功的界面
			// 设置状态码? 重新定位 状态码
			response.setStatus(302);
			// 定位跳转的位置是哪一个页面。
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
