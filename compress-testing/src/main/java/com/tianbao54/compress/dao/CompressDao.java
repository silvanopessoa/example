package com.tianbao54.compress.dao;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

@Repository
public class CompressDao {

	public String getFile () throws IOException {
		
		FileInputStream fis = new FileInputStream(ResourceUtils.getFile("classpath:summary.txt"));
		byte[] bytes = new byte[fis.available()];
		fis.read(bytes);
		
		fis.close();
		return new String(bytes);
	}
}
