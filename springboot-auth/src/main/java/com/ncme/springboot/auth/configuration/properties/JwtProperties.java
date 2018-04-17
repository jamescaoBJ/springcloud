/**
 * JwtProperties.java
 * com.ncme.springboot.configuration.properties
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年10月26日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.ncme.springboot.auth.configuration.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.ncme.springboot.footstone.util.StrKit;

/**
 * ClassName:JwtProperties
 * Function: TODO ADD yml or properties file must code jwt config。
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年10月26日	下午3:30:16
 *
 * @see 	 
 *  
 */
@Component
@ConfigurationProperties(prefix="jwt")  // jwt begin.
public class JwtProperties {
	
	
	private String header;
	private String secret;
	private String expiration;
	private String tokenPrefix;
	private String authPrefix;
	private String path;

	
	
	private static final String J_HEADER = "Authorization";
	private static final String J_SECRET  = "1989";
	private static final String J_EXPIRATION  = "600000";
	private static final String J_TOKENPREFIX  = "token";
	private static final String J_AUTHPREFIX  = "auth";
	private static final String J_PATH  = "/auth/**";
	/**
	 * header
	 *
	 * @return  the header
	 * @since    Ver 1.0
	*/
	
	public String getHeader() {
		return StrKit.isBlank(header)?JwtProperties.J_HEADER:header;
	}
	/**
	 * header
	 *
	 * @param   header    the header to set
	 * @since    Ver 1.0
	 */
	
	public void setHeader(String header) {
		this.header = header;
	}
	/**
	 * secret
	 *
	 * @return  the secret
	 * @since    Ver 1.0
	*/
	
	public String getSecret() {
		return StrKit.isBlank(secret)?JwtProperties.J_SECRET:secret;

	}
	/**
	 * secret
	 *
	 * @param   secret    the secret to set
	 * @since    Ver 1.0
	 */
	
	public void setSecret(String secret) {
		this.secret = secret;
	}
	/**
	 * expiration
	 *
	 * @return  the expiration
	 * @since    Ver 1.0
	*/
	
	public String getExpiration() {
		return StrKit.isBlank(expiration)?JwtProperties.J_EXPIRATION:expiration;
	}
	/**
	 * expiration
	 *
	 * @param   expiration    the expiration to set
	 * @since    Ver 1.0
	 */
	
	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}
	/**
	 * tokenPrefix
	 *
	 * @return  the tokenPrefix
	 * @since    Ver 1.0
	*/
	
	public String getTokenPrefix() {
		return StrKit.isBlank(tokenPrefix)?JwtProperties.J_TOKENPREFIX:tokenPrefix;

	}
	/**
	 * tokenPrefix
	 *
	 * @param   tokenPrefix    the tokenPrefix to set
	 * @since    Ver 1.0
	 */
	
	public void setTokenPrefix(String tokenPrefix) {
		this.tokenPrefix = tokenPrefix;
	}
	/**
	 * authPrefix
	 *
	 * @return  the authPrefix
	 * @since    Ver 1.0
	*/
	
	public String getAuthPrefix() {
		
		return StrKit.isBlank(authPrefix)?JwtProperties.J_AUTHPREFIX:authPrefix;

	}
	/**
	 * authPrefix
	 *
	 * @param   authPrefix    the authPrefix to set
	 * @since    Ver 1.0
	 */
	
	public void setAuthPrefix(String authPrefix) {
		this.authPrefix = authPrefix;
	}
	/**
	 * path
	 *
	 * @return  the path
	 * @since    Ver 1.0
	*/
	
	public String getPath() {
		
		return StrKit.isBlank(path)?JwtProperties.J_PATH:path;

	}
	/**
	 * path
	 *
	 * @param   path    the path to set
	 * @since    Ver 1.0
	 */
	
	public void setPath(String path) {
		this.path = path;
	}
	
	
	

}
