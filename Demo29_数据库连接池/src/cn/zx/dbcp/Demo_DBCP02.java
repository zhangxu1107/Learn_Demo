package cn.zx.dbcp;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import cn.zx.util.JDBCUtil;

/**
 *	 使用配置文件
 * @author 10831
 *
 */
public class Demo_DBCP02 {
	@Test
	public void testDBCP02() {
		/*
		 * BasicDataSource dataSource = new BasicDataSource(); //不知道这行能不能实现。
		 * dataSource.setConnectionProperties("dbcpconfig.properties");
		 */

		// ResourceBundle bundler = ResourceBundle.getBundle(baseName);

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			BasicDataSourceFactory factory = new BasicDataSourceFactory();
			Properties properties = new Properties();

			//InputStream is = new FileInputStream("src//dbcpconfig.properties");
			InputStream is = getClass().getClassLoader().getResourceAsStream("dbcpconfig.properties");
			properties.load(is);
			DataSource dataSource = factory.createDataSource(properties);

			// 2. 得到连接对象
			conn = dataSource.getConnection();
			String sql = "insert into account values(null , ? , ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "liangchaowei22");
			ps.setInt(2, 200);

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, ps);
		}
	}
}
