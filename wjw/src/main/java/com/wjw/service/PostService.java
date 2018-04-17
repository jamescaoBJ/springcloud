/**
 * PostService.java
 * com.wjw.service
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月8日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.wjw.service;

import java.util.List;

import com.ncme.springboot.footstone.response.Record;

/**
 * ClassName:PostService
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月8日	下午4:28:22
 *
 * @see 	 
 *  
 */

public interface PostService {

	/**
	 * getPostType:职务类型
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param id 职位类型id
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	List<Record> getPostType(Integer id);

	/**
	 * getPost:职务获取
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param id
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	List<Record> getPost(String id);

}
