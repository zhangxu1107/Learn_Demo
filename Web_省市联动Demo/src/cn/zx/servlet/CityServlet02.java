package cn.zx.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;

import cn.zx.bean.CityBean;
import cn.zx.dao.CityDao;
import cn.zx.dao.impl.CityDaoImpl;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class CityServlet
 */
public class CityServlet02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//1. ��ȡ����
			int pid = Integer.parseInt(request.getParameter("pid"));
			
			//2 �ҳ����еĳ���
			CityDao dao = new CityDaoImpl();
			List<CityBean> list = dao.findCity(pid);
			
			//3. ��list ---> json����
			//JSONArray ---> ������� �� ����  [ ]
			//JSONObject ---> ��ɼ򵥵�����  { name : zhangsan , age:18}
			
			JSONArray jsonArray = JSONArray.fromObject(list);
			String json = jsonArray.toString();
			
			
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(json);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
