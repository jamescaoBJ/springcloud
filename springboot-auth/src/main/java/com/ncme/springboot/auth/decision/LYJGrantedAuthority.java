/**
 * MyGrantedAuthority.java
 * com.ncme.springboot.footstone.security
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年10月30日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.ncme.springboot.auth.decision;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

/**
 * ClassName:MyGrantedAuthority
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年10月30日	下午2:23:14
 *
 * @see 	 
 *  
 */

public final class LYJGrantedAuthority implements GrantedAuthority{

	
	/**
	 * serialVersionUID: -3477057868147034462L
	 *
	 * @since version 1.0
	 */
	
	private static final long serialVersionUID = -3477057868147034462L;
	private final String url;
	
	public LYJGrantedAuthority(String url){
		
		Assert.hasText(url, "A granted authority(you must got it ,it's my url authority!) textual representation is required,");
		this.url = url;
			
		
		
	}

	/**
	 * get the url mode auth...
	 */
	@Override
	public String getAuthority() {
		
		return url;
		
	}
	
	
	/**
	 *  get the  hashcode.
	 */
	public int hashCode() {
		return this.url.hashCode();
	}
	
	/**
	 * @see java.lang.String#toString()
	 * 
	 *  toString method.
	 */
	public String toString() {
		return this.url;
	}
	
	
	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 * 
	 *  A.equals(B)
	 */
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
	
		if (obj instanceof LYJGrantedAuthority) {
			return url.equals(((LYJGrantedAuthority) obj).url);
		}
	
		return false;
	}
	
}
