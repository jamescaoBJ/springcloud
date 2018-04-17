/**
 * LYJPsswordEncoder.java
 * com.ncme.springboot.auth.encoder
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月2日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.ncme.springboot.auth.encoder;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * ClassName:LYJPsswordEncoder
 * Function: TODO ADD 与原系统维护加密算法一致性
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月2日	上午11:17:59
 *
 * @see 	 
 *  
 */

public class LYJPsswordEncoder implements PasswordEncoder{


	@Override
	public String encode(CharSequence rawPassword) {
		
        Md5PasswordEncoder encoder = new Md5PasswordEncoder();
      
		
		return encoder.encodePassword(rawPassword.toString(), null);//不加盐，与原系统保持一致，风险点：容易被碰撞攻击
		
		
	}
	



	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		
		
		return encoder.isPasswordValid(encodedPassword, rawPassword.toString(),null);
		
	}

}
