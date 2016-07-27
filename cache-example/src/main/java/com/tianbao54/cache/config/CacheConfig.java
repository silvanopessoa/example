package com.tianbao54.cache.config;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.google.common.cache.CacheBuilder;
import com.google.common.util.concurrent.RateLimiter;

/**
 * @ClassName:  CacheConfig   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 张宇鹏  
 * @date:   2016年7月27日 下午2:16:35   
 */
@Configuration
@EnableWebMvc
@EnableCaching
@ComponentScan(value = {"com.tianbao54.cache"})
public class CacheConfig {

	@Bean(name = "threadPoolTaskExecutor")
	public ThreadPoolTaskExecutor poolTask () {
		ThreadPoolTaskExecutor task = new ThreadPoolTaskExecutor();
		task.setCorePoolSize(10);
		task.setKeepAliveSeconds(300);
		task.setMaxPoolSize(20);
		task.setQueueCapacity(200);
		return task;
	}
	
	@Bean(name = "rateLimiter")
	public RateLimiter rateLimiter () {
		RateLimiter limiter = RateLimiter.create(1);
		return limiter;
	}
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public CacheManager cacheManager () {
		
		SimpleCacheManager cacheManager = new SimpleCacheManager();
		GuavaCache register = new GuavaCache("register",CacheBuilder.newBuilder().expireAfterWrite(90, TimeUnit.SECONDS).build());
		GuavaCache registerCount = new GuavaCache("registerCount",CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.DAYS).build());
		GuavaCache modifypassword = new GuavaCache("modify",CacheBuilder.newBuilder().expireAfterWrite(90, TimeUnit.SECONDS).build());
		GuavaCache modifyCount = new GuavaCache("modifyCount",CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.DAYS).build());
		
		cacheManager.setCaches(Arrays.asList(register,registerCount,modifypassword,modifyCount));
		return cacheManager;
	}
}
