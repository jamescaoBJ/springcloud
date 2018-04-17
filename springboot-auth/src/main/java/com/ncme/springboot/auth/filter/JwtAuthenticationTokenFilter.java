/**
 * JwtAuthenticationTokenFilter.java
 * com.ncme.springboot.configuration.security.filter
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年10月26日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.ncme.springboot.auth.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ncme.springboot.auth.configuration.properties.JwtProperties;
import com.ncme.springboot.auth.decision.LYJGrantedAuthority;
import com.ncme.springboot.auth.oauth2.JwtUserDetails;
import com.ncme.springboot.auth.util.JwtToken;
import com.ncme.springboot.footstone.exception.MyException;

import io.jsonwebtoken.Claims;

/**
 * ClassName:JwtAuthenticationTokenFilter
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年10月26日	下午3:16:15
 *
 * @see 	 
 *  
 */

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
	
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
 
    
    @Autowired
    
    private JwtProperties JwtProperties;


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String Bearer = request.getHeader(JwtProperties.getHeader());
        AntPathRequestMatcher matcher = new AntPathRequestMatcher(JwtProperties.getPath());

		if( matcher.matches(request)){
			
            filterChain.doFilter(request, response);
            
            return;

		}
		
		
        if (Bearer == null || !Bearer.startsWith("Bearer ")) {
        
        	log.info("couldn't find bearer string, will step next filter.");//没有使用 bearer token认证，本业务必须使用
        	response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid Authorization header.");
        	
        }else{
        	
        	String token = Bearer.substring(7);
        	
        	try{
        	
        		Claims	claims = JwtToken.parserTokenClaims(token);
        		
        		if(SecurityContextHolder.getContext().getAuthentication() == null){
        			
        			SecurityContextHolder.getContext().setAuthentication(getAuth(claims));
        		}
        		
            	
                filterChain.doFilter(request, response);
        	}catch(MyException e){
        		
            	log.info(e.getMessage());//没有使用 bearer token认证，本业务必须使用

                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());

        	}
        	
        }

       
        	
           
        
        

		
		
		

	}
	
	
    
    private Authentication getAuth (Claims claims){
        ArrayList<LYJGrantedAuthority> authorities = new ArrayList<>();
        @SuppressWarnings("unchecked")
		List<Map<String, String>> Auths = (List<Map<String, String>>) claims.get(JwtProperties.getAuthPrefix());
        for (Map<String,String> authority : Auths) {
            authorities.add(new LYJGrantedAuthority(authority.get("authority")));
        }
        JwtUserDetails  principal = JwtUserDetails.getJwtUserDetails(claims.getId(),claims.getSubject(), "", authorities);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(principal, "", authorities);
        return usernamePasswordAuthenticationToken;
    }

}
