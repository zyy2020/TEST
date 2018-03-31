package com.wenjuan.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.wenjuan.dao.UserDao;
import com.wenjuan.dao.impl.UserDaoImpl;
import com.wenjuan.bean.User;
import com.wenjuan.service.UserService;

public class UserServiceImpl implements UserService {
   private UserDao userDao=new UserDaoImpl();
	@Override
	public List<User> selectAllUsers() throws SQLException {
		
		return userDao.selectAllUsers();
	}

	@Override
	public User login(String name, String pwd) throws SQLException {
		
			
		return userDao.selectUserByNameAndPwd(name, pwd);
	}

	@Override
	public boolean regist(User user) throws SQLException {
		if(userDao.insertUser(user)>0)
		   return true;
		return false;
	}

	@Override
	public User selectById(int id) throws SQLException {
		
		return userDao.selectUserById(id);
	}

	@Override
	public List<User> findPageNumUser(int pageNum) throws SQLException {
		
		return userDao.findPageNumUser(pageNum);
	}

	@Override
	public long selectCount() throws SQLException {
		
		return userDao.selectCount()%6==0?userDao.selectCount()/6:(userDao.selectCount()/6+1);
	}

	@Override
	public int modifyUser(User user) throws SQLException {
		userDao.updateUser(user);
		return 0;
	}

	@Override
	public int deleteUser(int id) throws SQLException {
		return userDao.deleteUserById(id);
	}

}
