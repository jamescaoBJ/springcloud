package com.ncme.zuul.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class ErrorFilter extends ZuulFilter {

	Logger log = LoggerFactory.getLogger(ErrorFilter.class);
	
	private static final String ERROR_STATUS_CODE_KEY = "error.status_code";
	
	public static final String DEFAULT_ERR_MSG = "系统繁忙,请稍后再试";
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		
		RequestContext ctx = RequestContext.getCurrentContext();  
		  
        log.info("进入异常过滤器");  
  
        System.out.println(ctx.getResponseBody());  
  
        ctx.setResponseBody("出现异常");  
  
        return null;
	}
	

	@Override
	public String filterType() {
		//异常过滤器 
		return "error";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
