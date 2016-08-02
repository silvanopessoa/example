package com.tianbao54.rmi.service.impl;

import org.springframework.stereotype.Service;

import com.tianbao54.rmi.service.RMIService;

@Service("rmiService")
public class RMIServiceImpl implements RMIService {

	@Override
	public String fromRemote(String... args) {
		StringBuilder sb = new StringBuilder();
		
		for (String str : args) {
			sb.append(str).append(",");
		}
		
		return "from remote server:[" + sb.toString() + "]";
	}
}
