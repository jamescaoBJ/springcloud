package com.ncme.springboot.auth.decision;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

@Service
public class LYJFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {
	
	
	@Autowired
	private FilterInvocationSecurityMetadataSource securityMetadataSource;
	
	
    @Autowired
    public void setLYJAccessDecisionManager(LYJAccessDecisionManager lyjAccessDecisionManager) {
        super.setAccessDecisionManager(lyjAccessDecisionManager);
    }

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		 FilterInvocation filterInvocation = new FilterInvocation(request, response, chain);
		 
	     InterceptorStatusToken token = super.beforeInvocation(filterInvocation);
	     try {
	    	 
	    	 filterInvocation.getChain().doFilter(filterInvocation.getRequest(), filterInvocation.getResponse());
	     } finally {
	            super.afterInvocation(token, null);
	     }
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getSecureObjectClass() {
		return FilterInvocation.class;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		// TODO Auto-generated method stub
		return this.securityMetadataSource;
	}

}
