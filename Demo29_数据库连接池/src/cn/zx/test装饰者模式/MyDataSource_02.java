package cn.zx.testװ����ģʽ;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import cn.zx.util.JDBCUtil;

/**
 * ����һ�����ݿ����ӳ�
 * һ��ʼ�������������10������ 
 * 	1. ��ʼ����10�����ӡ� 
 * 	2. ���ĳ���ͨ��getConnection��ȡ���� 
 * 	3. ����֮��ʹ��addBack �黹���ӡ�
 * 	4. ���ݡ� 
 * 
 * ���⣺ 
 * 
 * 		1. sun��˾������ݿ����ӳض����һ�׹淶�� 
 * 	
 * 	1. ��Ҫ�����ס addBack����
 * 
 * 	2. ������
 * 
 * 	3. �޷�����ӿڱ�̡� 
 * 
 * 		UserDao dao = new UserDaoImpl();
 * 		dao.insert();
 * 
 * 		DataSource dataSource = new MyDataSource();
 * 
 * 		��Ϊ�ӿ�����û�ж���addBack������ 
 * 
 * 	4. ��ô���?  	
 */
public class MyDataSource_02 implements DataSource{

	//����10������
	List<Connection> list = new ArrayList<Connection>();
	public MyDataSource_02() {
		
		for(int i = 0; i <10; i++) {
			Connection conn = JDBCUtil.getConn();
			list.add(conn);
		}
	}
	
	//�����ӳض��⹫���Ļ�ȡ���ӵķ���
	@Override
	public Connection getConnection() throws SQLException {
		//�������ӵ�ʱ���ȿ������������滹��û�С�
		if(list.size() == 0) {
			for(int i = 0; i<5 ; i++) {
				Connection conn = JDBCUtil.getConn();
				list.add(conn);
			}
		}
		
		//remove(0) ---> �Ƴ���һ���� �Ƴ����Ǽ����еĵ�һ����  �Ƴ����ǿ�ʼ���Ǹ�Ԫ��
		Connection conn = list.remove(0);
		
		//�ڰ���������׳�ȥ��ʱ�� �����������а�װ��
		Connection connection = new ConnectionWrap(conn, list);
		
		return connection;
	}
	
	/**
	 * ����֮�󣬼ǵù黹��
	 * @param conn
	 */
	public void addBack(Connection conn) {
		list.add(conn);
	}
	
	
	//-----------------------------------------------------
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
