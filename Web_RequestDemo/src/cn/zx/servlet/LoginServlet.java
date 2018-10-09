package cn.zx.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HttpServletRequest中文乱码问题
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//方法一
		demo01(request);
		
		//方法二
		demo02(request);
	}

	private void demo02(HttpServletRequest request) throws UnsupportedEncodingException {
		//这个说的是设置请求体里面的文字编码。  get方式，用这行，有用吗？ ---> get
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// post过来的数据乱码处理：
		System.out.println("post : userName=" + username + "==password=" + password);
	}

	/**
	 * 	处理get请求过来的数据乱码
	 * @throws UnsupportedEncodingException
	 */
	private void demo01(HttpServletRequest request) throws UnsupportedEncodingException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println("userName=" + username + "==password=" + password);

		// get请求过来的数据，在url地址栏上就已经经过编码了，所以我们取到的就是乱码，
		// tomcat收到了这批数据，getParameter 默认使用ISO-8859-1去解码

		// 先让文字回到ISO-8859-1对应的字节数组 ， 然后再按utf-8组拼字符串
		username = new String(username.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println("userName=" + username + "==password=" + password);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("来了一个post请求...");
		doGet(request, response);
	}

}
