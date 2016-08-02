package com.tianbao54.compress.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianbao54.compress.dao.CompressDao;

@Service
public class CompressService {

	@Autowired
	private CompressDao compressDao;
	
	public String getFile () throws IOException {
		
		return compressDao.getFile();
	}
}
