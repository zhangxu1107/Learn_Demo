package cn.zx.commoncrud;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import cn.zx.domain.Account;
import cn.zx.util.JDBCUtil;
import cn.zx.util.JDBCUtil2;


public class CommonCRUDUtil {
	
//	new ArrayList<>()
//	new CommonCRUDUtil<List<Account>>();
	
	class A implements ResultSetHandler<Account>{

		@Override
		public Account handle(ResultSet rs) {
			try {
				Account account  = new Account();
				if(rs.next()){
					String name = rs.getString("name");
					int money = rs.getInt("money");
					
					account.setName02(name);
					account.setMoney(money);
				}
				return account;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			return null;
		}

	/*@Override
	public Object handle(ResultSet rs) {
		return null;
	}*/

		/*@Override
		public void handle(ResultSet rs) {
			
			try {
				while(rs.next()){
					String name = rs.getString("name");
					int money = rs.getInt("money");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		*/
	}
	
	@Test
	public void testQuery(){
		
/*		query("select * from account where id = ?" ,new ResultSetHandler(){
			
			@Override
			public void handle(ResultSet rs) {
				
			}
			
		} , 3);
*/		
		
		Account account = query("select * from account where id = ?" ,new A() , 3);
		
//		System.out.println(account.toString());
		
		
		
		
	}

//	ResultSetHandler handler = new A()
	
	//select * from aa;
	//select * from aa werhe id = ?
	//select * from aa where name = ? and gender =?
	public <T> T query(String sql , ResultSetHandler<T> handler, Object ...args ){
		Connection conn = null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil2.getConn();
			ps = conn.prepareStatement(sql);
			//获取到有几个问号，占位符
			ParameterMetaData metaData  = ps.getParameterMetaData();
			int count = metaData.getParameterCount();
			for (int i = 0; i < count; i++) {
				//因为不知道是什么类型的数据，所以都使用setObject来对待。
				ps.setObject(i+1, args[i]);
			}
			
			
			
			//执行查询工作， 然后得到结果集
			ResultSet rs = ps.executeQuery();
			
			//把结果集丢给调用者，让它去封装数据 ，返回封装数据
			T t =  (T) handler.handle(rs);
			 
			return t;
			//问题一： 这里的数据获取，以及封装成上面对象返回。不知道。 因为调用的地方需要的数据不同。
			/*while(rs.next()){
				rs.getInt("id");
				rs.getString("name");
//				。。。
			}*/
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, ps);
		}
		return null;
	}
	
	
	
	//----------------------------------------------------------------

	@Test
	public void testUpdate(){
//		update("insert into account values(null , ?,?)" , "aa",10);
		
//		update("delete from account where id = ?" ,14);
		
//		update("update account set money = ? where id = ?" , 9 ,8,19,10,10,10);
		update02("update account set money = ? where id = ?" , 800 ,6,19,10,10,10);
	}
	
	//select * from bb;
	
	//通用的增删改功能
	
	/**
	 * 以参数个数为准
	 * @param sql 需要操作的sql语句
	 * @param args  可变参数， 有几个占位符，就写几个参数进来。
	 */
	public void update(String sql ,Object ... args) {
		Connection conn = null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil2.getConn();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				//因为不知道是什么类型的数据，所以都使用setObject来对待。
				ps.setObject(i+1, args[i]);
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, ps);
		}
	}
	
	/**
	 * 打算以问号个数为准
	 * @param sql 需要操作的sql语句
	 * @param args  可变参数， 有几个占位符，就写几个参数进来。
	 */
	public void update02(String sql ,Object ... args) {
		Connection conn = null;
		PreparedStatement ps=null;
		try {
			conn = JDBCUtil2.getConn();
			ps = conn.prepareStatement(sql);
			//元数据
			//获取到有几个问号，占位符
			ParameterMetaData metaData  = ps.getParameterMetaData();
			int count = metaData.getParameterCount();
			
			for (int i = 0; i < count; i++) {
				//因为不知道是什么类型的数据，所以都使用setObject来对待。
				ps.setObject(i+1, args[i]);
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, ps);
		}
	}
}
