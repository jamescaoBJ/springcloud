/**
 * LYJAccessDecisionManager.java
 * com.ncme.springboot.footstone.security.decision
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年10月30日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.ncme.springboot.auth.decision;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import com.ncme.springboot.auth.configuration.properties.JwtProperties;

/**
 * ClassName:LYJAccessDecisionManager
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年10月30日	下午3:18:30
 *
 * @see 	 
 *  
 */
@Service
public class LYJAccessDecisionManager implements AccessDecisionManager {
	@Autowired
	JwtProperties jwtProperties;
	/**
	 * @see org.springframework.security.access.AccessDecisionManager#decide(org.springframework.security.core.Authentication, java.lang.Object, java.util.Collection)
	 */
	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        
        if(matchers("/",request) || matchers("/*.html",request) || matchers("/favicon.ico", request) || matchers("/**/*.css", request) || matchers("/**/*.js", request) 
        		 || matchers(jwtProperties.getPath(), request)){
        	
        	
        	
        	return;
        	
        }else{
        	
        	for(GrantedAuthority grant : authentication.getAuthorities()){
        		
        		if(grant instanceof LYJGrantedAuthority){
        			
        			String url = ((LYJGrantedAuthority)grant).getAuthority();
        			
        			if(matchers(url, request)){
        				
        				return;
        			}
        		}
        		
        	}
        }
        
      throw new AccessDeniedException("You do not have permission !");

	}

	/**
	 * @see org.springframework.security.access.AccessDecisionManager#supports(org.springframework.security.access.ConfigAttribute)
	 */
	@Override
	public boolean supports(ConfigAttribute attribute) {
		
		return true;
		
	}

	/**
	 * @see org.springframework.security.access.AccessDecisionManager#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		
		return true;
		
	}
	
	
    /**
     * @param url
     * @param request
     * @return
     */
    private boolean matchers(String url, HttpServletRequest request) {
    	
        AntPathRequestMatcher matcher = new AntPathRequestMatcher(url);
        if (matcher.matches(request)) {
            return true;
        }
        return false;
    }

}
