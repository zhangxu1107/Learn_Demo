package cn.zx.test;

import java.util.Scanner;

import org.junit.Test;

import cn.zx.dao.UserDao;
import cn.zx.dao.impl.UserDaoImpl;

public class TestUserDaoImpl {
	
	@Test
	public void testFindAll() {
		
		UserDao userDao = new UserDaoImpl(); //父类引用指向子类对象
		userDao.findAll();
	}
	
	@SuppressWarnings("resource")
	@Test
	public void testLogin() {
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入用户名：");
			String userName = sc.nextLine();
			System.out.println("请输入密码：");
			String passWord = sc.nextLine();
			UserDao userDao = new UserDaoImpl(); 
			userDao.login(userName,passWord);
		}	
	}
	
	@Test
	public void testInsert() {
		UserDao userDao = new UserDaoImpl(); 
		userDao.insert("aobama", "222222");
	}
	
	@Test
	public void testDelete() {
		UserDao userDao = new UserDaoImpl(); 
		userDao.delete(3);
	}
	
	@Test
	public void testUpdate() {
		UserDao userDao = new UserDaoImpl(); 
		userDao.update(2, "zhangxu");
	}
}
