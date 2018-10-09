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

		// 1. 获取要下载的文件名字 aa.jpg --- inputStream
		String fileName = request.getParameter("filename");
		
		//来了一个Get请求，这个fileName有中文。
		fileName = new String(fileName.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("fileName = " + fileName);
		
		/**
		 * 如果文件的名字带有中文，那么需要对这个文件名进行编码处理
		 * 如果是IE或者Chrome,使用URLEncoding编码
		 * 如果是Firefox,使用base64编码
		 */
		String clientType = request.getHeader("User-Agent");
		if(clientType.contains("FireFox")) {
			//如果是Firefox,使用base64编码
			fileName = DownloadUtil.base64EncodeFileName(fileName);
		}else {
			//如果是IE或者Chrome,使用URLEncoding编码
			//对中文的名字进行编码处理
			fileName = URLEncoder.encode(fileName,"UTF-8");
		}
		
		

		// 2. 获取这个文件在tomcat里面的绝对路径地址
		String path = getServletContext().getRealPath("download/" + fileName);

		// 让浏览器收到这份资源的时候， 以下载的方式提醒用户，而不是直接展示。
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

		//response.setStatus(302);
		//response.setHeader(Location, "login_success.html");

		//
		//response.sendRedirect("login_success.html");

		// 3. 转化成输入流
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
