package cn.zx.dao;

import java.util.List;

import cn.zx.domain.Student;

public interface StuDao {

	/**
	 * ��ѯ�������е�ѧ����Ϣ
	 * @return List����
	 */
	List<Student> findAll();
}
