package com.tianbao54.timer.example;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import com.tianbao54.timer.example.thread.MyThread;

@Component
@EnableScheduling
public class MyTimer {
	
	@Autowired
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;

	// 多少毫秒执行一次
	@Scheduled(fixedDelay = 5000)
	public void fixedDelayTask() {

		System.out.println(new Date() + " This runs in a fixed delay");

	}
	
	// 多少毫秒执行一次
	@Scheduled(fixedRate = 6000)
	public void fixedRateTask() {

		System.out.println(new Date() + " This runs in a fixed rate");

	}

	@Scheduled(fixedRate = 7000, initialDelay = 2000)
	public void fixedRateWithInitialDelayTask() {

		System.out.println(new Date() + " This runs in a fixed delay with a initial delay");

	}

	@Scheduled(cron = "10 * * * * *")
	public void cronTask() {
		threadPoolTaskExecutor.execute(new MyThread());
		System.out.println(new Date() + " This runs in a cron schedule");

	}
}