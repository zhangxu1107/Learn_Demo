package cn.zx.commoncrud;

import java.sql.ResultSet;

public interface ResultSetHandler<T> {

	/**
	 * ���������ݷ�װ�Ĺ��� �淶�� 
	 * @param <T>
	 * @param rs
	 */
	 T handle(ResultSet rs);
	
}
