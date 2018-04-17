/**
 * JwtUserDetailsFactory.java
 * com.wjw.util.oauth2
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年10月24日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.ncme.springboot.auth.oauth2;


import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.ncme.springboot.model.SystemAccount;

/**
 * ClassName:JwtUserDetailsFactory
 * Function: TODO ADD JwtUserDetails工厂类
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年10月24日	下午3:53:40
 *
 * @see 	 
 *  
 */

public final class JwtUserDetailsFactory {
	
	private JwtUserDetailsFactory(){
		
	}
	
	
	public static JwtUserDetails JwtUserDetails(SystemAccount account,Collection<GrantedAuthority> authorities ){// 权限集合待结合业务实现，SystemAccount不包含权限集合，待定设为null。。。
		
		return JwtUserDetails.getJwtUserDetails(account.getAccountId().toString(), account.getAccountName(), account.getAccountPassword(), authorities);
		
		
		
	}
	
	
	
	
	
	

}
