package com.ncme.zuul.filter;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PreFilter extends ZuulFilter {

	Logger log = LoggerFactory.getLogger(PreFilter.class);
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {

		RequestContext ctx = RequestContext.getCurrentContext();  
        HttpServletRequest request = ctx.getRequest();  
  
        log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString()); 
        //获取传来的参数accessToken  
        //Object accessToken = request.getParameter("accessToken"); 
       
        //if(accessToken == null) { 
        List<String> path = new ArrayList<String>();
        path.add("/springboot/mooc/getCatalog");
        if(!path.contains(request.getRequestURI())) {  
            log.warn("非法路径");  
            //过滤该请求，不往下级服务去转发请求，到此结束  
            ctx.setSendZuulResponse(false);  
            ctx.setResponseStatusCode(401);  
            ctx.setResponseBody("{\"result\":\"没有权限访问!\"}");  
            ctx.getResponse().setContentType("text/html;charset=UTF-8");  
            return null;  
        }  
        //如果有token，则进行路由转发  
        log.info("access token ok");  
        //这里return的值没有意义，zuul框架没有使用该返回值  
        return null;  
	}

	@Override
	public String filterType() {
		return "pre";

	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
