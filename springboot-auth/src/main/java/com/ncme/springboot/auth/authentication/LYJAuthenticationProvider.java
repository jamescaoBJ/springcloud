/**
 * LYJAuthenticationProvider.java
 * com.ncme.springboot.configuration.security.authentication
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月1日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.ncme.springboot.auth.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.ncme.springboot.auth.encoder.LYJPsswordEncoder;
import com.ncme.springboot.auth.oauth2.JwtUserDetails;
import com.ncme.springboot.auth.oauth2.JwtUserDetailsService;
import com.ncme.springboot.footstone.constant.BusinessConst;
import com.ncme.springboot.footstone.exception.MyException;


/**
 * ClassName:LYJAuthenticationProvider
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月1日	下午3:27:00
 *
 * @see 	 
 *  
 */
@Component
public class LYJAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	@Qualifier("jwtUserDetailsService")
	JwtUserDetailsService jwtUserDetailsService;
	
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		JwtUserDetails jwtUserDetails = (JwtUserDetails) jwtUserDetailsService.loadUserByUsername(username);
		
		if(jwtUserDetails == null){
			
			throw new MyException(BusinessConst.ACCOUNT_INVALID,"account is not found .");
		}
		
		/*LYJPsswordEncoder encoder = new LYJPsswordEncoder();
		if(!encoder.matches(password, jwtUserDetails.getPassword())){
			
			throw new MyException(BusinessConst.PASSWORD_INVALID,"password mismatch .");
			
		}*/
		if (!password.equals(jwtUserDetails.getPassword())) {
			throw new MyException(BusinessConst.PASSWORD_INVALID,"password mismatch .");
		}
		
		
		UsernamePasswordAuthenticationToken ut = new UsernamePasswordAuthenticationToken(jwtUserDetails.getUsername(), jwtUserDetails.getPassword(), jwtUserDetails.getAuthorities());
		ut.setDetails(jwtUserDetails.getId());//details 定义为userid
		
		
		
		return ut;
		
	}


	
	@Override
	public boolean supports(Class<?> authentication) {
		
		return true;
		
	}

}
