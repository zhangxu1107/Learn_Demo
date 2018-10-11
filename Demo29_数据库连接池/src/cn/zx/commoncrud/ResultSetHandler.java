package cn.zx.commoncrud;

import java.sql.ResultSet;

public interface ResultSetHandler<T> {

	/**
	 * 定义了数据封装的规则。 规范。 
	 * @param <T>
	 * @param rs
	 */
	 T handle(ResultSet rs);
	
}
