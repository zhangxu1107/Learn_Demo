package cn.zx.dao;

import java.sql.SQLException;

public interface UserDao {

	
	/**
	 * ���ڼ���û����Ƿ����
	 * @param username
	 * @return true : ���� ��false : ������
	 */
	boolean checkUserName(String username) throws SQLException;
}