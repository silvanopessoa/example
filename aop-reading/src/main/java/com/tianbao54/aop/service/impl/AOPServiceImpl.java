package com.tianbao54.aop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tianbao54.aop.dao.AOPDao;
import com.tianbao54.aop.service.AOPService;

@Service("aopService")
public class AOPServiceImpl implements AOPService{

	@Qualifier("aopDao")
	@Autowired
	private AOPDao aopDao;
	
	@Override
	public String userLogin (String username,String password) {
		return aopDao.getUser(username,password);
	}
}
