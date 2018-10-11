package cn.zx.dbcp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

import cn.zx.util.JDBCUtil;

public class Demo_DBCP {
	@Test
	public void testDBCP_01() {

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			
			// 1. ��������Դ����
			BasicDataSource dataSource = new BasicDataSource();
			// ������ʲô���͵����ݿ⣬ ���ʵ����ĸ����ݿ� �� �û����� ���롣��
			//jdbc:mysql://localhost/bank ��Э�飺��Э�� ://����/���ݿ�
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql://localhost/bank");
			dataSource.setUsername("root");
			dataSource.setPassword("zhangxu000");
			
			
			//2. �õ����Ӷ���
			conn = dataSource.getConnection();
			String sql = "insert into account values(null , ? , ?)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, "admin");
			ps.setInt(2, 1999);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, ps);
		}
	}
}
