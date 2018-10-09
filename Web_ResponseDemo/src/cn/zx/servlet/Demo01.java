package cn.zx.servlet;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HttpServletResponse中文乱码问题
 */
public class Demo01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// demo01(response);
		// demo02(response);
		
		
		// 以字节流输出
		/*
		 * 如果想让服务器端出去的中文，在客户端能够正常显示。只要确保一点。
		 * 
		 * 出去的时候用的编码 ， 和 客户端看这份数据用的编码 是一样的。
		 * 
		 * 默认情况下getOutputStream 输出使用的是UTF-8的码表 。 如果想指定具体的编码，可以在获取byte数组的时候，指定。 
		 */

		// 设置响应的数据类型是html文本，并且告知浏览器，使用UTF-8 来编码。
		response.setContentType("text/html;charset=UTF-8");

		// String这个类里面， getBytes()方法使用的码表，是UTF-8， 跟tomcat的默认码表没关系。 tomcat iso-8859-1
		String csn = Charset.defaultCharset().name();

		System.out.println("默认的String里面的getBytes方法使用的码表是： " + csn);

		// 1. 指定浏览器看这份数据使用的码表
		//response.setHeader("Content-Type", "text/html;charset=UTF-8");

		// 2. 指定输出的中文用的码表
		response.getOutputStream().write("我爱张旭..".getBytes("UTF-8"));
	}

	private void demo02(HttpServletResponse response) throws IOException {
		// 响应的数据中包含中文---> 乱码。 以字符流输出

		// 这里写出去的文字，默认使用的是ISO-8859-1 ，我们可以指定写出去的时候，使用什么编码写
		// 1. 指定输出到客户端的时候，这些文字使用UTF-8编码
		response.setCharacterEncoding("UTF-8");
		// 2. 直接规定浏览器看这份数据的时候，使用什么编码来看。
		response.setHeader("Content-Type", "text/html; charset=UTF-8");
		response.getWriter().write("我爱张旭...");
	}

	private void demo01(HttpServletResponse response) throws IOException {
		// 以字符流的方式写数据
		// response.getWriter().write("hello response...");

		// 以字节流的方式写数据
		response.getOutputStream().write("hello response2222...".getBytes());

		// 设置当前这个请求的处理状态码
		// response.setStatus("");

		// 设置一个头
		// response.setHeader(name, value);

		// 设置响应的内容类型，以及编码。
		// response.setContentType(type);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
