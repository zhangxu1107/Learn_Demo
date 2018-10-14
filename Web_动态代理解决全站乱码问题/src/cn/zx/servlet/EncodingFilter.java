package cn.zx.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncodingFilter implements Filter {

    public EncodingFilter() {
    }

	public void destroy() {
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}
	
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//将request对象转换为HttpServletRequest
		final HttpServletRequest req=(HttpServletRequest)request;
		//让JDK在内存中生成代理对象:增强了req对象上的getParameter(name);API
		HttpServletRequest myReq=(HttpServletRequest)Proxy.newProxyInstance(EncodingFilter.class.getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				
				Object obj=null;
				
				if(method.getName().equalsIgnoreCase("getParameter")){
					//获取本次请求方式
					String md=req.getMethod();
					if("get".equalsIgnoreCase(md)){
						//get方式的请求
						//调用req对象上的getParameter方法
						String v=(String)method.invoke(req, args);
						//转码
						String vv=new String(v.getBytes("iso-8859-1"),"utf-8");
						return vv;
						
					}else{
						//post方式的请求
						req.setCharacterEncoding("utf-8");
						obj=method.invoke(req, args);
					}
					
					
				}else{
					obj=method.invoke(req, args);
				}
				return obj;
			}
		});
		//打印代理对象哈希码
		System.out.println(myReq.hashCode());
		//将代理对象放行
		chain.doFilter(myReq, response);
	}



}
