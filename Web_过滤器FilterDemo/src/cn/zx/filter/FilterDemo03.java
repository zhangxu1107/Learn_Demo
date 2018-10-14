package cn.zx.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/*")
public class FilterDemo03 implements Filter {

    public FilterDemo03() {
        // TODO Auto-generated constructor stub
    }
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("来到了 过滤器 filter03 before");
		chain.doFilter(request, response);
		System.out.println("来到了 过滤器 filter03  after");
	}

	@Override
	public void destroy() {
		
	}


}
