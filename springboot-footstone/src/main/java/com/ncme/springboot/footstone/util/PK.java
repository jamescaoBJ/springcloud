/**
 * PK.java
 * com.ncme.springboot.footstone.util
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年9月21日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.ncme.springboot.footstone.util;

/**
 * ClassName:PK
 * Function: *数据库主键生成工具，软件管理，不采用数据库配置管理
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年9月21日	上午11:48:45
 *
 * @see 	 
 *  
 */

public class PK {

	/**
	 * @return pk value
	 */
	public static String value() {

		return java.util.UUID.randomUUID().toString().replace("-", "")
				.toUpperCase();

	}
	

}
