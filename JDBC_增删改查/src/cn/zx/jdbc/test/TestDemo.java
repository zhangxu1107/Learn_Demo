package cn.zx.jdbc.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import cn.zx.jdbc.util.JDBCUtil;

/**
 * *使用junit执行单元测试
 * 
 * @author 10831
 *
 */
public class TestDemo {
	
	@Test
	public void testQuery() {
		// 查询
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// 1.获取连接对象
			conn = JDBCUtil.getConn();

			// 2.根据连接对象，得到statement
			st = conn.createStatement();

			// 3.执行sql语句，返回ResultSet
			String sql = "SELECT * FROM t_stu";
			rs = st.executeQuery(sql);

			// 4.遍历结果集
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				System.out.println("id=" + id + "...name=" + name + "...age=" + age);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, st, rs);
		}
	}
	
	@Test
	public void testInsert() {
		// 插入
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// 1.获取连接对象
			conn = JDBCUtil.getConn();

			// 2.根据连接对象，得到statement
			st = conn.createStatement();

			// 3.执行添加sql语句
			String sql = "INSERT INTO t_stu VALUES(null,'奥巴马' ,96)";
			int resullt = st.executeUpdate(sql);
			// 影响的行数，如果大于0表明操作成功，否则操作失败
			if(resullt > 0) {
				System.out.println("添加成功！");
			}else {
				System.out.println("添加失败！");
			}
			//查询一下插入结果
			sql = "SELECT * FROM t_stu";
			rs = st.executeQuery(sql);

			// 4.遍历结果集
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				System.out.println("id=" + id + "...name=" + name + "...age=" + age);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, st, rs);
		}
	}
	
	@Test
	public void testDelete() {
		// 插入
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// 1.获取连接对象
			conn = JDBCUtil.getConn();

			// 2.根据连接对象，得到statement
			st = conn.createStatement();

			// 3.执行删除sql语句
			String sql = "DELETE FROM t_stu WHERE name='奥巴马'";
			int resullt = st.executeUpdate(sql);
			// 影响的行数，如果大于0表明操作成功，否则操作失败
			if(resullt > 0) {
				System.out.println("删除成功！");
			}else {
				System.out.println("删除失败！");
			}
			//查询一下删除结果
			sql = "SELECT * FROM t_stu";
			rs = st.executeQuery(sql);

			// 4.遍历结果集
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				System.out.println("id=" + id + "...name=" + name + "...age=" + age);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, st, rs);
		}
	}
	
	@Test
	public void testUpdate() {
		// 插入
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// 1.获取连接对象
			conn = JDBCUtil.getConn();

			// 2.根据连接对象，得到statement
			st = conn.createStatement();

			// 3.执行删除sql语句
			String sql = "UPDATE t_stu SET age=88 WHERE name='刘六'";
			int resullt = st.executeUpdate(sql);
			// 影响的行数，如果大于0表明操作成功，否则操作失败
			if(resullt > 0) {
				System.out.println("更新成功！");
			}else {
				System.out.println("更新失败！");
			}
			//查询一下更新结果
			sql = "SELECT * FROM t_stu";
			rs = st.executeQuery(sql);

			// 4.遍历结果集
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				System.out.println("id=" + id + "...name=" + name + "...age=" + age);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, st, rs);
		}
	}
}
