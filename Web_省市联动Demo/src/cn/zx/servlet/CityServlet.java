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

/**
 * Servlet implementation class CityServlet
 */
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//1. ��ȡ����
			int pid = Integer.parseInt(request.getParameter("pid"));
			
			//2 �ҳ����еĳ���
			CityDao cityDao = new CityDaoImpl();
			List<CityBean> cityList = cityDao.findCity(pid);
			
			//3. �������ݡ��ֶ�ƴ  ---> XStream  ת�� bean����� xml
			XStream xStream = new XStream();
			
			//���id��������
			//xStream.useAttributeFor(CityBean.class, "id");
			//���ñ���
			xStream.alias("city", CityBean.class);
			//ת��һ�������xml�ַ���
			String xml = xStream.toXML(cityList);
			
			//��������
			response.setContentType("text/xml;charset=utf-8");
			response.getWriter().write(xml);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
