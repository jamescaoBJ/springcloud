/**
 * JwtToken.java
 * com.ncme.springboot.footstone.oauth2.jjwt
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年10月25日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.ncme.springboot.auth.util;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ncme.springboot.auth.configuration.properties.JwtProperties;
import com.ncme.springboot.footstone.exception.MyException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

/**
 * ClassName:JwtToken
 * Function: TODO token 生成和解析
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年10月25日	下午2:36:05
 *
 * @see 	 
 *  
 */
@Component
public class JwtToken {
	
	
    private static JwtProperties jwtProperties;
	



	/**
	 * jwtProperties
	 *
	 * @param   jwtProperties    the jwtProperties to set
	 * @since    Ver 1.0
	 */
	@Autowired
	public void setJwtProperties(JwtProperties jwtProperties) {
		JwtToken.jwtProperties = jwtProperties;
	}


	/**
	 * refreshToken:刷新操作
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param token
	 * @param  @return    
	 * @return String    
	 * @throws 
	 * @since  　version 1.0
	*/
	public static String refreshToken(Claims claims){
		
		 claims.setExpiration(new Date(System.currentTimeMillis() +Long.valueOf(jwtProperties.getExpiration())));
		
		return creatToken(claims);
		
	}
	
	
	/**
	 * invalidToken:失效操作
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param token
	 * @param  @return    
	 * @return String    
	 * @throws 
	 * @since  　version 1.0
	*/
	public static void invalidToken(String token){
		
		
		try{
			parserTokenClaims(token).setExpiration(new Date(System.currentTimeMillis()));
		}catch (MyException e) {
			throw new MyException(e.getMessage());
		}
		
		
	}
	/**
	 * token: create token
	 * TODO 默认采用HS512签名
	 * jti prevent  replay attack
	 * @param  @param subject:主题名
	 * @param  @param claims：body
	 * @param  @return    
	 * @return String    
	 * @throws 
	 * @since  　version 1.0
	 */
	public static String creatToken(String jti ,String subject,Claims claims){
		
	
		
		return Jwts.builder()
					.setClaims(claims.setExpiration(new Date(System.currentTimeMillis() +Long.valueOf(jwtProperties.getExpiration()))).setSubject(subject).setId(jti)).signWith(SignatureAlgorithm.HS512, jwtProperties.getSecret().getBytes()).compact();
		
		
	}
	
	
	/**
	 * creatToken:创建tonken
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param claims
	 * @param  @return    
	 * @return String    
	 * @throws 
	 * @since  　version 1.0
	*/
	public static String creatToken(Claims claims){
		
		
		return creatToken(claims.getId(),claims.getSubject(),claims);
		
		
	}
	
	/**
	 * parserTokenClaims:解析payload信息
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param token
	 * @param  @return    
	 * @return Claims    
	 * @throws 
	 * @since  　version 1.0
	*/
	public static Claims parserTokenClaims(String token){
		
		Claims claims = null;
		
		try{
		
			claims= Jwts.parser().setSigningKey(jwtProperties.getSecret().getBytes()).parseClaimsJws(token).getBody();
		
		}catch(SignatureException e){
			
			throw new MyException("token has been tampered with ！");
		}catch(ExpiredJwtException e){
			throw new MyException("the token is expired ！");
		}
		
		return claims;
	}
	
	
	/**
	 * parserTokenHeader:解析头部信息
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param token
	 * @param  @return    
	 * @return JwsHeader<?>    
	 * @throws 
	 * @since  　version 1.0
	*/
	public static JwsHeader<?> parserTokenHeader(String token){
		JwsHeader<?> h = null;
		
	   try{
			
			h = Jwts.parser().setSigningKey(jwtProperties.getSecret().getBytes()).parseClaimsJws(token).getHeader();
			
		}catch(SignatureException e){
			
			throw new MyException("token has been tampered with ！");

		}catch(ExpiredJwtException e){
			throw new MyException("the token is expired ！");
		}
		
		return h;
	}


	/**
	 * getSubject:得到subject（账号）
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param token
	 * @param  @return    
	 * @return String    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	public static String getSubject(String token) {
		
		return parserTokenClaims(token).getSubject();
		
	}
	
	

	

}
