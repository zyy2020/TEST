package com.wenjuan.dao.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import com.wenjuan.bean.User;
import com.wenjuan.dao.UserDao;
import net.sf.json.JSONArray;
public class UserTest {
	private static UserDao userDao;

	@BeforeClass
	public static void setUpBeforeClass() {
		userDao = new UserDaoImpl();
	}

	@Test
	public void add() throws SQLException {
		User user = new User("张三", "123", "female", new Date(), "/upload/user/1.jpg");
		userDao.insertUser(user);
	}
	@Test
	public void selectAllUsers() throws SQLException, ParseException {
		List<User> listUsers = userDao.selectAllUsers();
		SimpleDateFormat dt=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date parse=null;
		for (User list : listUsers) {
			 parse = dt.parse((list.getBirth().toString()));
			list.setBirth(parse);
		}
		JSONArray users = JSONArray.fromObject(listUsers);
		System.out.println((users.getJSONObject(0).get("birth")));

		
	}

	@Test
	public void selectUsersById() throws SQLException {
		User user = userDao.selectUserById(1);
		System.out.println(user);
	}

	@Test
	public void selectUserByNameAndPwd() throws SQLException {
		User user = userDao.selectUserByNameAndPwd("张三", "123");
		System.out.println(user);
	}

	@Test
	public void updateUser() throws SQLException {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2017);
		calendar.set(Calendar.MONTH, 7);
		calendar.set(Calendar.DATE, 5);
		java.util.Date date1 = calendar.getTime();
		User user = new User(1, "张三", "456", "male", date1, "/upload/user/6.jpg");
		int updateUser = userDao.updateUser(user);
		System.out.println(updateUser);
	}

	@Test
	public void deleteUserById() throws SQLException {
		int deleteUserById = userDao.deleteUserById(1);
		System.out.println(deleteUserById);
	}

	@Test
	public void deleteUserByNameAndPwd() throws SQLException {
		int deleteUserByNameAndPwd = userDao.deleteUserByNameAndPwd("张三", "123");
		System.out.println(deleteUserByNameAndPwd);
	}
}
