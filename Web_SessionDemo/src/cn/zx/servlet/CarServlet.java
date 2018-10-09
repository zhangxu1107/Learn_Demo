package cn.zx.servlet;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	�������� �򵥹��ﳵ�� 
 * Servlet implementation class CarServlet
 */
public class CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		// 1. ��ȡҪ��ӵ����ﳵ����Ʒid
		int id = Integer.parseInt(request.getParameter("id"));
		String[] names = { "iphone7", "С��6", "��Ϊ9", "����Note8", "����14", "oppor9", "vivox7" };
		// ȡ��id��Ӧ����Ʒ����
		String name = names[id];

		// 2. ��ȡ���ﳵ��Ŷ�����session Map<String , Integer> iphoen7 3
		// ��һ��map�����ŵ�session����ȥ�����ұ�ֻ֤��һ�Ρ�
		Map<String, Integer> map = (Map<String, Integer>) request.getSession().getAttribute("cart");
		// session����û�д�Ź��κζ�����
		if (map == null) {
			map = new LinkedHashMap<String, Integer>();
			request.getSession().setAttribute("cart", map);
		}

		// 3. �жϹ��ﳵ������û�и���Ʒ
		if (map.containsKey(name)) {
			//��ԭ����ֵ������  + 1 
			map.put(name, map.get(name) + 1);
		} else {
			//û�й��������Ʒ����ǰ����Ϊ1 ��
			map.put(name, 1);
		}
		
		//4. ������档����ת��
		response.getWriter().write("<a href='product_list.jsp'><h3>��������</h3></a><br>");
		response.getWriter().write("<a href='cart.jsp'><h3>ȥ���ﳵ����</h3></a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
