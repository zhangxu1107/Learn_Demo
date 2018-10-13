package cn.zx.dao;

import java.sql.SQLException;
import java.util.List;

import cn.zx.bean.CityBean;

public interface CityDao {
	List<CityBean> findCity(int pid)  throws SQLException ;
}
