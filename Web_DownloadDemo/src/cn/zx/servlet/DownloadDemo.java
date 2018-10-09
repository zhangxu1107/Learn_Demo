package cn.zx.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadDemo
 */
public class DownloadDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. ��ȡҪ���ص��ļ����� aa.jpg --- inputStream
		String fileName = request.getParameter("filename");
		
		//����һ��Get�������fileName�����ġ�
		fileName = new String(fileName.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("fileName = " + fileName);
		
		/**
		 * ����ļ������ִ������ģ���ô��Ҫ������ļ������б��봦��
		 * �����IE����Chrome,ʹ��URLEncoding����
		 * �����Firefox,ʹ��base64����
		 */
		String clientType = request.getHeader("User-Agent");
		if(clientType.contains("FireFox")) {
			//�����Firefox,ʹ��base64����
			fileName = DownloadUtil.base64EncodeFileName(fileName);
		}else {
			//�����IE����Chrome,ʹ��URLEncoding����
			//�����ĵ����ֽ��б��봦��
			fileName = URLEncoder.encode(fileName,"UTF-8");
		}
		
		

		// 2. ��ȡ����ļ���tomcat����ľ���·����ַ
		String path = getServletContext().getRealPath("download/" + fileName);

		// ��������յ������Դ��ʱ�� �����صķ�ʽ�����û���������ֱ��չʾ��
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

		//response.setStatus(302);
		//response.setHeader(Location, "login_success.html");

		//
		//response.sendRedirect("login_success.html");

		// 3. ת����������
		InputStream is = new FileInputStream(path);
		OutputStream os = response.getOutputStream();

		int len = 0;
		byte[] buffer = new byte[1024];
		while ((len = is.read(buffer)) != -1) {
			os.write(buffer, 0, len);
		}

		os.close();
		is.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
