/**
 * Token.java
 * com.ncme.springboot.configuration.security.util
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月1日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.ncme.springboot.auth.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;



import io.jsonwebtoken.Claims;

/**
 * ClassName:Token
 * Function: TODO ADD get user info
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月1日	下午4:25:43
 *
 * @see 	 
 *  
 */

public final  class Token {
	
	
	private static final String header = "Authorization";
	
	/**
	 * USER:通用对象获取方法，与具体业务隔离，所以采用泛型
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param request
	 * @param  @param t
	 * @param  @return    
	 * @return T    
	 * @throws 
	 * @since  　version 1.0
	*/
	@SuppressWarnings("unchecked")
	public static final <T> T USER(HttpServletRequest request,Class<? extends T> t) {
		
		Object tt = null ;
		try {
			String token = request.getHeader(header).substring(7);
			Claims  claims = JwtToken.parserTokenClaims(token);
		
				Constructor<?> constructor;
				
			
				
					constructor = t.getConstructor(String.class,String.class);
					
					constructor.setAccessible(true);
					tt =   constructor.newInstance(claims.getId(),claims.getSubject());
				} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NullPointerException e) {
					
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
					
				}
		

		
				return (T)tt;
		
		
		
		
		
	}
	
	
	

}
