package com.tianbao54.aop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.tianbao54.aop.interceptor.AOPInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(value = {"com.tianbao54.aop"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringConfiguration extends WebMvcConfigurerAdapter {

	@Bean(name = "restTemplate")
	public RestTemplate restTemplate () {
		RestTemplate rs = new RestTemplate();
		return rs;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AOPInterceptor()).addPathPatterns("/aop/*");
	}
}