package cn.zx.dao;

import java.sql.SQLException;
import java.util.List;

import cn.zx.bean.StudentBean;

public interface StudentDao {
	/**
	 * 用于检测用户名是否存在
	 * @param username
	 * @return true : 存在 ，false : 不存在
	 * a
	 * abc
	 * admin
	 * aaa
	 */
	List<StudentBean> findWords(String word) throws SQLException;
}
