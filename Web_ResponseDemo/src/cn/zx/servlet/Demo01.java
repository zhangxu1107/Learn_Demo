package cn.zx.servlet;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HttpServletResponse������������
 */
public class Demo01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// demo01(response);
		// demo02(response);
		
		
		// ���ֽ������
		/*
		 * ������÷������˳�ȥ�����ģ��ڿͻ����ܹ�������ʾ��ֻҪȷ��һ�㡣
		 * 
		 * ��ȥ��ʱ���õı��� �� �� �ͻ��˿���������õı��� ��һ���ġ�
		 * 
		 * Ĭ�������getOutputStream ���ʹ�õ���UTF-8����� �� �����ָ������ı��룬�����ڻ�ȡbyte�����ʱ��ָ���� 
		 */

		// ������Ӧ������������html�ı������Ҹ�֪�������ʹ��UTF-8 �����롣
		response.setContentType("text/html;charset=UTF-8");

		// String��������棬 getBytes()����ʹ�õ������UTF-8�� ��tomcat��Ĭ�����û��ϵ�� tomcat iso-8859-1
		String csn = Charset.defaultCharset().name();

		System.out.println("Ĭ�ϵ�String�����getBytes����ʹ�õ�����ǣ� " + csn);

		// 1. ָ����������������ʹ�õ����
		//response.setHeader("Content-Type", "text/html;charset=UTF-8");

		// 2. ָ������������õ����
		response.getOutputStream().write("�Ұ�����..".getBytes("UTF-8"));
	}

	private void demo02(HttpServletResponse response) throws IOException {
		// ��Ӧ�������а�������---> ���롣 ���ַ������

		// ����д��ȥ�����֣�Ĭ��ʹ�õ���ISO-8859-1 �����ǿ���ָ��д��ȥ��ʱ��ʹ��ʲô����д
		// 1. ָ��������ͻ��˵�ʱ����Щ����ʹ��UTF-8����
		response.setCharacterEncoding("UTF-8");
		// 2. ֱ�ӹ涨�������������ݵ�ʱ��ʹ��ʲô����������
		response.setHeader("Content-Type", "text/html; charset=UTF-8");
		response.getWriter().write("�Ұ�����...");
	}

	private void demo01(HttpServletResponse response) throws IOException {
		// ���ַ����ķ�ʽд����
		// response.getWriter().write("hello response...");

		// ���ֽ����ķ�ʽд����
		response.getOutputStream().write("hello response2222...".getBytes());

		// ���õ�ǰ�������Ĵ���״̬��
		// response.setStatus("");

		// ����һ��ͷ
		// response.setHeader(name, value);

		// ������Ӧ���������ͣ��Լ����롣
		// response.setContentType(type);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
