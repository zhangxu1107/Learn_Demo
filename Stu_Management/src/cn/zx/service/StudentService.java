package cn.zx.service;

import java.sql.SQLException;
import java.util.List;

import cn.zx.bean.Student;

/**
 * 这是学生的业务处理规则
 * @author 10831
 *
 */
public interface StudentService {
	/**
	 * 查询所有学生
	 * @return
	 */
	List<Student> findAll() throws SQLException;
	
	/**
	 * 根据ID查询单个学生对象
	 * @param sid
	 * @return
	 * @throws SQLException
	 */
	Student findStudentById(int sid)  throws SQLException ;
	
	/**
	 * 添加学生
	 * @param student 需要添加到数据库的学生对象
	 * @throws SQLException
	 */
	void insert(Student student) throws SQLException ;
	
	/**
	 * 根据id删除学生
	 * @param sid
	 * @throws SQLException
	 */
	void delete(int sid) throws SQLException ;
	
	/**
	 * 更新学生信息
	 * @param student 需要更新的学生数据
	 * @throws SQLException
	 */
	void update (Student student )throws SQLException ;
}
