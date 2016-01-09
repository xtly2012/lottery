package com.chen.lottery.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LotteryInterceptor extends HandlerInterceptorAdapter {
	
	/**
	 * This implementation always returns {@code true}.
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		
		return true;
	}
}
