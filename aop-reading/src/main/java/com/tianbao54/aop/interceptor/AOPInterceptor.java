package com.tianbao54.aop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.tianbao54.aop.utils.WebContext;

/**
 * @ClassName:  AOPInterceptor   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 张宇鹏  
 * @date:   2016年8月1日 下午4:35:43   
 */
public class AOPInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.getSession().setAttribute("status", "server is running..");
		WebContext.setRequest(request);
		WebContext.setResponse(response);
		
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}
}