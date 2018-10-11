package cn.zx.jdbc.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {

	static String driverClass = null;
	static String url = null;
	static String name = null;
	static String password = null;

	static {

		try {
			// 1.����һ���������ö���
			Properties properties = new Properties();
			InputStream is = new FileInputStream("jdbc.properties");
			
			//ʹ�����������ȥ��ȡsrc���µ���Դ�ļ��� ������servlet
			//InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
			
			// ����������
			properties.load(is);
			
			//��ȡ����
			driverClass = properties.getProperty("driverClass");
			url = properties.getProperty("url");
			name = properties.getProperty("name");
			password = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * *��ȡ���Ӷ���
	 * 
	 * @return
	 */
	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(driverClass);
			// ��̬����� ---> ������ˣ���ִ�С� java.sql.DriverManager.registerDriver(new Driver());
			// DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			// DriverManager.getConnection("jdbc:mysql://localhost/test?user=monty&password=greatsqldb");
			// 2. �������� ����һ�� Э�� + ���ʵ����ݿ� �� �������� �û��� �� �������� ���롣
			conn = DriverManager.getConnection(url, name, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * *�ͷ���Դ
	 * 
	 * @param conn
	 * @param st
	 * @param rs
	 */
	public static void release(Connection conn, Statement st, ResultSet rs) {
		closeRs(rs);
		closeSt(st);
		closeConn(conn);
	}

	public static void release(Connection conn, Statement st) { //����
		closeSt(st);
		closeConn(conn);
	}
	
	private static void closeRs(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs = null;
		}
	}

	private static void closeSt(Statement st) {
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			st = null;
		}
	}

	private static void closeConn(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}

}
