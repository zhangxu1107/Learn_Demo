package cn.zx.dao;

import java.sql.SQLException;

import cn.zx.bean.UserBean;

public interface UserDao {

	
	/**
	 * ִ�е�¼�����ҷ��ظ��û���������Ϣ
	 * @param user ִ�е�¼���û���Ϣ
	 * @return 
	 */
	UserBean login(UserBean user) throws SQLException;
}