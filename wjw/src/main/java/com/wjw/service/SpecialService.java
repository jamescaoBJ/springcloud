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
 * 
 * ClassName:SpecialService
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   xh
 * @version  
 * @since    version 1.0
 * @Date	 2018年2月27日	下午1:40:44
 *
 * @see 	 
 *
 */

public interface SpecialService {

	/**
	 * 
	 * getSpecialTrainList:
	 * 专项能力列表
	 *
	 * @param  @param keyWord
	 * @param  @param pageNum
	 * @param  @param pageSize
	 * @param  @param request
	 * @param  @return    
	 * @return PageInfo<Record>    
	 * @throws 
	 * @since  　version 1.0
	 */
	PageInfo<Record> getSpecialTrainList(String keyword, String state, String pageNum, String pageSize,HttpServletRequest request);
	
	/**
	 * 
	 * getSpecialDetail:
	 * 专项能力详情
	 *
	 * @param  @param userId
	 * @param  @param zxSetId
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	 */
	Record getSpecialDetail(Integer userId,Integer zxSetId);
}
