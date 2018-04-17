/**
 * Record.java
 * com.ncme.springboot.footstone.response
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年9月30日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.ncme.springboot.footstone.response;

import java.util.HashMap;


/**
 * ClassName:Record
 * Function: TODO 直接封装hashmap，构造统一返回vo map对象，后续根据业务扩充方法，暂时简单作为对象
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年9月30日	下午2:25:14
 *
 * @see 	 
 *  
 */

public class Record extends HashMap<String, Object>{

	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 *
	 * @since version 1.0
	 */
	
	private static final long serialVersionUID = 1L;

	/**
	 * (non-Javadoc)
	 * @see java.util.AbstractMap#toString()
	 */
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder("my vo is ：");
		sb.append(super.toString());

		
		return sb.toString();
		
		
	}
	

	
	

}
