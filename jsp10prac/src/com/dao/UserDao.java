package com.dao;

import java.util.List;

import com.pojo.UserInfo;
import com.util.DBUtil;

public class UserDao {
	
	public static UserInfo findByUserName(String userName, String passWord)
	{
		String sql = "SELECT userId, userName, passWord FROM userinfo WHERE userName = ? and passWord = ?";
		List<UserInfo> list = DBUtil.query(UserInfo.class, sql, userName, passWord);
		if(!list.isEmpty())
		{
			return list.get(0);
		}
		return null;
	}
}
