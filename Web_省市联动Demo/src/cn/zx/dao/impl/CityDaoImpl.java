package cn.zx.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.zx.bean.CityBean;
import cn.zx.dao.CityDao;
import cn.zx.util.JDBCUtil;

public class CityDaoImpl implements CityDao{

	@Override
	public List<CityBean> findCity(int pid) throws SQLException {

		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from city where pid = ?";
		return runner.query(sql, new BeanListHandler<CityBean>(CityBean.class) , pid);
	}

}
