package cn.zx.dao;

/**
 * ��dao�����˶��û���ķ��ʹ���
 */
public interface UserDao {
	/**
	 * ����򵥾ͷ���һ��Boolean���ͣ� �ɹ�����ʧ�ܼ��ɡ�
	 * 
	 * ���ǿ�����ʱ�򣬵�¼�ķ�����һ���ɹ�������Ӧ�÷��ظ��û��ĸ�����Ϣ
	 * 
	 * @param userName
	 * @param password
	 * 
	 * @return true : ��¼�ɹ��� false : ��¼ʧ�ܡ�
	 */
	boolean login(String userName , String password);
}
