package cn.zx.c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.zx.util.JDBCUtil;

public class Demo_C3P0 {
	
	@Test
	public void testC3P0() {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//1. ����datasource
//			ComboPooledDataSource dataSource = new ComboPooledDataSource("oracle");
			
			//Ĭ�ϻ��� xml �е� default-config ��֧�� 
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			System.out.println(dataSource.hashCode() );
			ComboPooledDataSource dataSource2 = new ComboPooledDataSource();
			System.out.println(dataSource2.hashCode()+"-------");
			//2. �����������ݵ���Ϣ
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			
			//������---> ȥ��ǰ�Ĵ��� ---> jdbc���ĵ�
			dataSource.setJdbcUrl("jdbc:mysql://localhost/bank");
			dataSource.setUser("root");
			dataSource.setPassword("zhangxu000");
			
			//2. �õ����Ӷ���
			conn = dataSource.getConnection();
			String sql = "insert into account values(null , ? , ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "admi234n");
			ps.setInt(2, 103200);
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, ps);
		}
	}
}
