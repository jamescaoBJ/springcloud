/**
 * LayaMap.java
 * com.ncme.springboot.footstone.request
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月15日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.ncme.springboot.footstone.request;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ClassName:LayaMap
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月15日	下午3:10:02
 *
 * @see 	 
 *  
 */

public class LayaMap extends HashMap<String, String>{
	
	/**
	 * log:TODO log对象
	 *
	 * @since version 1.0
	 */
	public Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 *
	 * @since version 1.0
	 */
	
	private static final long serialVersionUID = -5669077067945662215L;
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder("my params map is ：");
		sb.append(super.toString());

		
		return sb.toString();
		
		
	}
	

}
