package com.tianbao54.springrest.authentication.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.tianbao54.springrest.authentication")
public class HelloWorldConfiguration {
	

}