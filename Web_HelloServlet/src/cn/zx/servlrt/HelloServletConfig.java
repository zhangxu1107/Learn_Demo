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
		// ServletConfig ���Ի�ȡservlet�����õ�һЩ��Ϣ

		// 1. �õ�servlet���ö��� ר������������servlet����Ϣ
		ServletConfig config = getServletConfig();

		// ��ȡ����������servlet����servlet-name ���ı�����
		String servletName = config.getServletName();
		System.out.println("servletName=" + servletName);

		// 2���� ���Ի�ȡ�����ĳһ��������
		String address = config.getInitParameter("address");
		System.out.println("address=" + address);

		System.out.println("----------------------------------");

		// 3.��ȡ���еĲ�������
		Enumeration<String> names = config.getInitParameterNames();
		// ����ȡ�����еĲ�������
		while (names.hasMoreElements()) {
			String key = (String) names.nextElement();
			String value = config.getInitParameter(key);
			System.out.println("key===" + key + "   value=" + value);

		}
	}

	// ����post���󣬾�����ȥִ��doGet����
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
