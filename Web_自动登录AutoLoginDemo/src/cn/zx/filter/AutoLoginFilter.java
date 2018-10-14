package cn.zx.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import cn.zx.bean.UserBean;
import cn.zx.dao.UserDao;
import cn.zx.dao.impl.UserDaoImpl;
import cn.zx.util.CookieUtil;

/**
 * Servlet Filter implementation class AutoLoginFilter
 */
public class AutoLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AutoLoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			HttpServletRequest request = (HttpServletRequest) req;
			
			//���жϣ�����session�л���û���Ǹ�userBean.
			UserBean userBean = (UserBean) request.getSession().getAttribute("userBean");
			//���У���Ч��
			if(userBean != null){
				chain.doFilter(request, response);
			}else{
				//����sessionʧЧ�ˡ�
				
				//2. ��cookie��
				
				//1. �������ʱ���ȴ���������ȡ��cookie , ����cookie�кܶ��key-value
				Cookie[] cookies = request.getCookies();
				//2. ��һ�ѵ�cookie�����ҳ�������ǰ������������Ǹ�cookie
				Cookie cookie = CookieUtil.findCookie(cookies, "auto_login");
				
				//��һ����
				if(cookie  == null){
					chain.doFilter(request, response);
				}else{
					
					//���ǵ�һ�Ρ�
					
					String value = cookie.getValue();
					String username = value.split("#")[0];
					String password = value.split("#")[1];

					
					//��ɵ�¼
					UserBean user = new UserBean();
					user.setUsername(username);
					user.setPassword(password);

					UserDao dao = new UserDaoImpl();
					userBean = dao.login(user);
					
					//ʹ��session�����ֵ�����У�������һ��δ����ǰ�������á�
					request.getSession().setAttribute("userBean", userBean);
					
					chain.doFilter(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			chain.doFilter(req, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
