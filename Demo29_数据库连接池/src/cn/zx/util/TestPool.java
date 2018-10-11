package cn.zx.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

public class TestPool {

	@Test
	public void testPool() {
		Connection conn = null;
		PreparedStatement ps = null;
		MyDataSource dataSource = new MyDataSource();
		try {
			conn = dataSource.getConnection();

			String sql = "insert into account values(null,'xilali',10)";
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//¹é»¹Á¬½Ó
			//conn.close();
			dataSource.addBack(conn);
			//JDBCUtil.release(conn, st, rs);
		}

	}

}
