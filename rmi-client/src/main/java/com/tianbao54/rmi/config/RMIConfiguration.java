package com.tianbao54.rmi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import com.tianbao54.rmi.service.RMIService;

@Configuration
@ComponentScan("com.tianbao54.rmi")
public class RMIConfiguration {

	@Bean(name = "rmiServiceProxy")
	public RmiProxyFactoryBean rmiProxy() {
		RmiProxyFactoryBean rpfb = new RmiProxyFactoryBean();
		rpfb.setServiceUrl("rmi://localhost:1919/rimService");
		rpfb.setServiceInterface(RMIService.class);
		return rpfb;
	}
}
