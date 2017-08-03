package com.dao;

import java.util.List;

import com.pojo.User;
import com.util.DBUtil;

public class UserDao {
	
	public static User findByUserName(String username, String password)
	{
		String sql = "SELECT userId, userName, passWord FROM userinfo WHERE userName = ? and passWord = ?";
		List<User> list = DBUtil.query(User.class, sql, username, password);
		if(!list.isEmpty())
		{
			return list.get(0);
		}
		
		return null;
	}

}
