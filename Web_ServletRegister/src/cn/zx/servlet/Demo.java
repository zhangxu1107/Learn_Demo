package cn.zx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("来了一个请求..");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	void aa(){
		System.out.println("来了一个请求..");
		System.out.println("来了一个请求..");
		System.out.println("来了一个请求..");
		System.out.println("来了一个请求..");
		System.out.println("来了一个请求..");
		System.out.println("来了一个请求..");
		System.out.println("来了一个请求..");
		System.out.println("来了一个请求..");
		System.out.println("来了一个请求..");
		System.out.println("来了一个请求..");
		System.out.println("来了一个请求..");
	}
}
