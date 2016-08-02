package com.tianbao54.rmi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.tianbao54.rmi.service.RMIService;
import com.tianbao54.rmi.service.impl.RMIServiceImpl;

@Configuration
@EnableWebMvc
@ComponentScan("com.tianbao54.rmi")
public class SpringConfiguration {

	@Autowired
	private RMIServiceImpl rmiService;

	@Bean
	public RmiServiceExporter registerService() {
		
		RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
		rmiServiceExporter.setServiceName("rimService");
		rmiServiceExporter.setService(rmiService);
		rmiServiceExporter.setServiceInterface(RMIService.class);
		rmiServiceExporter.setRegistryPort(1919);
		return rmiServiceExporter;
	}
}
