package cn.zx.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.zx.bean.StudentBean;
import cn.zx.dao.StudentDao;
import cn.zx.util.JDBCUtil;

public class StudentDaoImpl implements StudentDao{

	@Override
	public List<StudentBean> findWords(String word) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from t_stu where sname like ?  limit ?";
		return runner.query(sql, new BeanListHandler<StudentBean>(StudentBean.class) , word+"%" , 5);
	}

}
