/**
 * SearchService.java
 * com.wjw.service
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月3日                   xh
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.wjw.service;

import javax.servlet.http.HttpServletRequest;

import com.github.pagehelper.PageInfo;
import com.ncme.springboot.footstone.response.Record;

/**
 * ClassName:SearchService
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   xh
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月3日	上午9:24:23
 *
 * @see 	 
 *  
 */

public interface SearchService {

	/**
	 * 
	 * getSearchResultList:(这里用一句话描述这个方法的作用)
	 * TODO(首页全局搜索)
	 *
	 * @param  @param keyWord
	 * @param  @param pageCurrent
	 * @param  @param pageSize
	 * @param  @return    
	 * @return PageInfo<Record>    
	 * @throws 
	 * @since  　version 1.0
	 */
	PageInfo<Record> getSearchResultList(String keyWord, String pageCurrent, String pageSize, Integer provinceId, String domainName);
}
