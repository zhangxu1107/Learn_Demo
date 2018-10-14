package cn.zx.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.zx.bean.UserBean;
import cn.zx.dao.UserDao;
import cn.zx.util.JDBCUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public UserBean login(UserBean user) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from t_user where username = ? and password = ?";
		UserBean query = runner.query(sql, new BeanHandler<UserBean>(UserBean.class) , user.getUsername() , user.getPassword());
		return query;
	}

}
