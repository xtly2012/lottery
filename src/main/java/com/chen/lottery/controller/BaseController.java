package com.chen.lottery.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

public abstract class BaseController {
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception exception, HttpServletRequest request) {
		return "/view/error/error.jsp";
	}
}
