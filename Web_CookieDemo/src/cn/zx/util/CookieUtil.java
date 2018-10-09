package cn.zx.util;

import javax.servlet.http.Cookie;

public class CookieUtil {
	
	/**
	 * 	��һ��cookie�������ҵ�����������Ҫ��cookie����
	 * @param cookies
	 * @param name
	 * @return
	 */
	public static Cookie findCookie(Cookie[] cookies , String name) {
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if(name.equals(cookie.getName())) {
					return cookie;
				}
			}
		}
		
		return null;
	}
}
