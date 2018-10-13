package cn.zx.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.zx.dao.UserDao;
import cn.zx.util.JDBCUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public boolean checkUserName(String username) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		
		String sql = "select count(*) from t_user where username =?";
		
		
		runner.query(sql, new  ScalarHandler(), username);
		
		Long result = (Long) runner.query(sql, new  ScalarHandler(), username); 
		return result > 0 ;
	}

}
