package cn.zx.dao;

import java.sql.SQLException;
import java.util.List;

import cn.zx.bean.StudentBean;

public interface StudentDao {
	/**
	 * ���ڼ���û����Ƿ����
	 * @param username
	 * @return true : ���� ��false : ������
	 * a
	 * abc
	 * admin
	 * aaa
	 */
	List<StudentBean> findWords(String word) throws SQLException;
}
