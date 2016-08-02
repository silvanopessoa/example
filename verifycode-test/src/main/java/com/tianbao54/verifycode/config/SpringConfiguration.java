package com.tianbao54.verifycode.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;

@EnableWebMvc
@Configuration
@ComponentScan(value = {"com.tianbao54.verifycode"})
public class SpringConfiguration extends WebMvcConfigurerAdapter{
	
	
	
	@Bean(name = {"defaultKaptcha"})
	public DefaultKaptcha defaultKaptcha () throws IOException {
		DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
		FileInputStream fileInputStream = new FileInputStream(ResourceUtils.getFile("classpath:kaptcha.properties"));
		Properties properties = new Properties();
		properties.load(fileInputStream);
		Config config = new Config(properties);
		defaultKaptcha.setConfig(config);
		return defaultKaptcha;
	}
}