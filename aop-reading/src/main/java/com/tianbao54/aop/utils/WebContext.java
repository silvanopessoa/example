package com.tianbao54.aop.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName:  SessionContext   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 张宇鹏  
 * @date:   2016年8月1日 下午4:32:53   
 */
public class WebContext {

	private static ThreadLocal<HttpServletRequest> requestThread = new ThreadLocal<HttpServletRequest>();
	private static ThreadLocal<HttpServletResponse> responseThread = new ThreadLocal<HttpServletResponse>();

	public static HttpServletRequest getRequest() {
		return requestThread.get();
	}

	public static void setRequest(HttpServletRequest request) {
		requestThread.set(request);
	}

	public static HttpServletResponse getResponse() {
		return  responseThread.get();
	}

	public static void setResponse(HttpServletResponse response) {
		responseThread.set(response);
	}

	public static HttpSession getSession() {
		return requestThread.get().getSession();
	}
}
