package com.tianbao54.cache.timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import com.google.common.util.concurrent.RateLimiter;
import com.tianbao54.cache.thread.MyThread;

@Component
@EnableScheduling
public class MyTimer {
	
	@Autowired
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;
	@Autowired
	private RateLimiter rateLimiter;

	// 多少毫秒执行一次
	@Scheduled(fixedDelay = 100)
	public void fixedDelayTask() {
		// 可以限制每秒起一个线程
		// 也可以用来限制流量， byte[] package
		// rateLimiter.acquire(package.length);
		rateLimiter.acquire();
		threadPoolTaskExecutor.execute(new MyThread());
	}
}