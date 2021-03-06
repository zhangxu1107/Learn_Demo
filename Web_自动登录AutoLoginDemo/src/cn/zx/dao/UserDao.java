package cn.zx.dao;

import java.sql.SQLException;

import cn.zx.bean.UserBean;

public interface UserDao {

	
	/**
	 * 执行登录，并且返回该用户的所有信息
	 * @param user 执行登录的用户信息
	 * @return 
	 */
	UserBean login(UserBean user) throws SQLException;
}