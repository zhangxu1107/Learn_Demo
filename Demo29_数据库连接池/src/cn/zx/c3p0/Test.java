package cn.zx.c3p0;

import java.sql.Connection;
import java.sql.SQLException;


import cn.zx.util.JDBCUtil2;

/**
 * 	使用c3p0改造的util
 * @author 10831
 *
 */
public class Test {

	public static void main(String[] args) {
		
		try {
			Connection conn = JDBCUtil2.getConn();
			
			
			conn.prepareStatement(null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
