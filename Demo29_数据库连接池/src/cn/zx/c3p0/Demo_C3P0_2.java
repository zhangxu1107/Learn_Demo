package cn.zx.c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.zx.util.JDBCUtil;

public class Demo_C3P0_2 {
	
	@Test
	public void testC3P0() {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			
			//��new��һ������
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			
			//2. �õ����Ӷ���
			conn = dataSource.getConnection();
			String sql = "insert into account values(null , ? , ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "wangwu2");
			ps.setInt(2, 2600);
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, ps);
		}
	}
}
