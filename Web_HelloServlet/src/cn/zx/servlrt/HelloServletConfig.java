package cn.zx.servlrt;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class HelloServletConfig extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ServletConfig 可以获取servlet在配置的一些信息

		// 1. 得到servlet配置对象 专门用于在配置servlet的信息
		ServletConfig config = getServletConfig();

		// 获取到的是配置servlet里面servlet-name 的文本内容
		String servletName = config.getServletName();
		System.out.println("servletName=" + servletName);

		// 2、。 可以获取具体的某一个参数。
		String address = config.getInitParameter("address");
		System.out.println("address=" + address);

		System.out.println("----------------------------------");

		// 3.获取所有的参数名称
		Enumeration<String> names = config.getInitParameterNames();
		// 遍历取出所有的参数名称
		while (names.hasMoreElements()) {
			String key = (String) names.nextElement();
			String value = config.getInitParameter(key);
			System.out.println("key===" + key + "   value=" + value);

		}
	}

	// 来了post请求，就让它去执行doGet方法
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
