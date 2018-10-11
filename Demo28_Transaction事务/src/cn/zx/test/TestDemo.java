package cn.zx.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import cn.zx.jdbc.util.JDBCUtil;

public class TestDemo {
	@Test
	public void testTransaction() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConn();
			
			//���ӣ�����Ĭ�Ͼ����Զ��ύ�ġ� �ر��Զ��ύ��
			conn.setAutoCommit(false);
			
			String sql = "update account set money = money - ? where id = ?";
			ps = conn.prepareStatement(sql);
			
			//��Ǯ�� ��IDΪ1 ��100��Ǯ
			ps.setInt(1, 100);
			ps.setInt(2, 1);
			ps.executeUpdate();
			
			int a = 10 /0 ;
			
			//��Ǯ�� ��IDΪ2 ��100��Ǯ
			ps.setInt(1, -100);
			ps.setInt(2, 2);
			ps.executeUpdate();
			
			//�ɹ��� �ύ����
			conn.commit();
			
		} catch (SQLException e) {
			try {
				//�±䣺 �ع�����
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, ps, rs);
		}
	}

	/**
	 * �����쳣���Զ��ύ������������ʧ
	 */
	@Test
	public void demo_1() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConn();
			
			
			String sql = "update account set money = money - ? where id = ?";
			ps = conn.prepareStatement(sql);
			
			//��Ǯ�� ��IDΪ1 ��100��Ǯ
			ps.setInt(1, 100);
			ps.setInt(2, 1);
			ps.executeUpdate();
			
			//int a = 10 /0 ;
			String s = null;
			s.length();
			
			//��Ǯ�� ��IDΪ2 ��100��Ǯ
			ps.setInt(1, -100);
			ps.setInt(2, 2);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, ps, rs);
		}
	}
}
