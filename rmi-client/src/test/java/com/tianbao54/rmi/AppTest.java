package com.tianbao54.rmi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tianbao54.rmi.config.RMIConfiguration;
import com.tianbao54.rmi.service.RMIService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RMIConfiguration.class})
public class AppTest {
	
	@Autowired
	@Qualifier("rmiServiceProxy")
	private RMIService rmiService;
	
	@Test
	public void testRMI () {
		String hello = rmiService.fromRemote("hello");
		System.out.println(hello);
	}
}
