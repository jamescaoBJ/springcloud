package com.ncme.springboot.auth.decision;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.ConfigAttribute;

/**
 * @author lyj
 *	
 */
public class LYJConfigAttribute implements ConfigAttribute{
	
	
	private static final long serialVersionUID = 9155663980275938220L;
	
	
	private final HttpServletRequest httpServletRequest;
	
	public  LYJConfigAttribute(HttpServletRequest httpServletRequest) {
		
		
		this.httpServletRequest = httpServletRequest;
		
	}

	@Override
	public String getAttribute() {
		// TODO Auto-generated method stub
		return null;
	}
	

    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }

}
