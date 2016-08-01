package com.tianbao54.aop.dao.impl;

import org.springframework.stereotype.Repository;

import com.tianbao54.aop.dao.AOPDao;

@Repository("aopDao")
public class AOPDaoImpl implements AOPDao {

	@Override
	public String getUser (String username,String password) {
		
		if (null != username && null != password) {
			return "user [" + username + "] login successed";
		}
		return "login failed";
	}
}
