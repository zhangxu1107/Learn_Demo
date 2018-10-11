package cn.zx.test装饰者模式;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import cn.zx.util.JDBCUtil;

public class TestPool_02 {

	@Test
	public void testPool() {
		Connection conn = null;
		PreparedStatement ps = null;
		MyDataSource_02 dataSource = new MyDataSource_02();
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
			//归还连接
			//conn.close();
			//dataSource.addBack(conn);
			JDBCUtil.release(conn, ps);
		}

	}

}
