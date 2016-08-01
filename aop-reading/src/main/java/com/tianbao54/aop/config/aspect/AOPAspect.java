package com.tianbao54.aop.config.aspect;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.tianbao54.aop.utils.WebContext;

@Aspect
@Component
public class AOPAspect {
	
	private final Logger logger = Logger.getLogger("aoptest");

	@Before(value="execution(* com.tianbao54.aop.service.*.*(..))")
    public void beforeService(JoinPoint joinPoint){
		HttpSession session = WebContext.getSession();
        logger.debug("user [" + joinPoint.getArgs()[0] + "] has logined and the server status is :[" + session.getAttribute("status") + "]");
    }
}
