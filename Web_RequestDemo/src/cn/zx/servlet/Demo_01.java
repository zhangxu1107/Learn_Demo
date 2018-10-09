package cn.zx.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo_01
 */
public class Demo_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 取出请求里面的所有头信息 ---- 得到一个枚举集合
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String name = (String) headerNames.nextElement();
			String value = request.getHeader(name);
			System.out.println(name + "=" + value);
		}

		System.out.println("-----------------------");

		// 2. 获取到的是客户端提交上来的数据
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		System.out.println("name=" + name);
		System.out.println("address=" + address);

		System.out.println("-----------------------");

		// 获取所有的参数，得到一个枚举集合
		// Enumeration<String> parameterNames = request.getParameterNames();

		// name=zhangsan&address=beijing

		// name=zhangsan&name=lisi&name=wangwu

		Map<String, String[]> map = request.getParameterMap();
		Set<String> keySet = map.keySet();
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			System.out.println("key=" + key + "--的值总数有：" + map.get(key).length);
			String value = map.get(key)[0];
			String value1 = map.get(key)[1];
			String value2 = map.get(key)[2];

			System.out.println(key + " ======= " + value + "=" + value1 + "=" + value2);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
