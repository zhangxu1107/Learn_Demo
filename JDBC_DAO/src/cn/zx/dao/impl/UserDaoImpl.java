package cn.zx.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.zx.dao.UserDao;
import cn.zx.util.JDBCUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public void findAll() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// 1.获取连接对象
			conn = JDBCUtil.getConn();

			// 2.创建Statement对象
			st = conn.createStatement();

			String sql = "SELECT * FROM t_user";
			rs = st.executeQuery(sql);

			while (rs.next()) {
				String userName = rs.getString("username");
				String passWord = rs.getString("password");
				System.out.println("userName=" + userName + "-------passWord=" + passWord);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, st, rs);
		}

	}

	/*
	 * //Statement
	 * 
	 * @Override public void login(String username, String password) { Connection
	 * conn = null; Statement st = null; ResultSet rs = null; try { // 1.获取连接对象 conn
	 * = JDBCUtil.getConn();
	 * 
	 * // 2.创建Statement对象 st = conn.createStatement();
	 * 
	 * String sql =
	 * "SELECT * FROM t_user WHERE username='"+username+"'AND password='"+password+
	 * "'"; rs = st.executeQuery(sql);
	 * 
	 * if(rs.next()) { String userName = rs.getString("username"); String passWord =
	 * rs.getString("password"); System.out.println("userName=" + userName
	 * +"-------passWord=" + passWord); System.out.println("登录成功！"); }else {
	 * System.out.println("登录失败！"); } } catch (SQLException e) {
	 * e.printStackTrace(); } finally { JDBCUtil.release(conn, st, rs); }
	 * 
	 * }
	 */

	// ParpreStatement
	@Override
	public void login(String username, String password) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// 1.获取连接对象
			conn = JDBCUtil.getConn();

			// 2.创建Statement对象
			String sql = "SELECT * FROM t_user WHERE username= ? AND password= ? ";

			// 预先对sql语句执行语法的校验，？对应的内容，后面不管传递什么进来，都把它看成是字符串。 or select
			PreparedStatement ps = conn.prepareStatement(sql);
			// ? 对应的索引从 1 开始。
			ps.setString(1, username);
			ps.setString(2, password);

			rs = ps.executeQuery();

			if (rs.next()) {
				String userName = rs.getString("username");
				String passWord = rs.getString("password");
				System.out.println("userName=" + userName + "-------passWord=" + passWord);
				System.out.println("登录成功！");
			} else {
				System.out.println("登录失败！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, st, rs);
		}

	}

	@Override
	public void update(int id, String name) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "UPDATE t_user SET username=? WHERE id=?";
			ps = conn.prepareStatement(sql);

			// 给占位符赋值 从左到右数过来，1 代表第一个问号， 永远你是1开始。
			ps.setString(1, name);
			ps.setInt(2, id);

			int result = ps.executeUpdate();
			if (result > 0) {
				System.out.println("更新成功！");
			} else {
				System.out.println("更新失败！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, ps);
		}
	}

	@Override
	public void delete(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "DELETE FROM t_user WHERE id = ?";
			ps = conn.prepareStatement(sql);
			// 给占位符赋值 从左到右数过来，1 代表第一个问号， 永远你是1开始。
			ps.setInt(1, id);
			
			int result = ps.executeUpdate();
			if (result > 0) {
				System.out.println("删除成功！");
			} else {
				System.out.println("删除失败！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, ps);
		}

	}

	@Override
	public void insert(String userName, String passWord) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "INSERT INTO t_user VALUES(NULL , ? , ?)";
			ps = conn.prepareStatement(sql);

			// 给占位符赋值 从左到右数过来，1 代表第一个问号， 永远你是1开始。
			ps.setString(1, userName);
			ps.setString(2, passWord);

			int result = ps.executeUpdate();
			if (result > 0) {
				System.out.println("添加成功！");
			} else {
				System.out.println("添加失败！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, ps);
		}
	}

}
