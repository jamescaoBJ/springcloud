/**
 * CvLiveService.java
 * com.wjw.service
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月6日       juniorice
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.wjw.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.github.pagehelper.PageInfo;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.model.CvLive;

/**
 * ClassName:CvLiveService
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   xh
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月6日	下午6:02:18
 *
 * @see 	 
 *  
 */

public interface CvLiveService {

	/**
	 * 
	 * getCvList:
	 * TODO(获取直播课程)
	 *
	 * @param  @param xueke
	 * @param  @param type
	 * @param  @param pageCurrent
	 * @param  @param pageSize
	 * @param  @return    
	 * @return PageInfo<Record>    
	 * @throws 
	 * @since  　version 1.0
	 */
	PageInfo<Record> getCvList(Map<String,Object> map, String pageCurrent, String pageSize,HttpServletRequest request);
	
	/**
	 * 
	 * getDetail:
	 * TODO(获取直播课程详情)
	 *
	 * @param  @param map
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	 */
	Record getDetail(Map<String,Object> map,HttpServletRequest request);
	
	/**
	 * 
	 * checkBindCost:
	 * TODO(是否需要绑定卡校验)
	 *
	 * @param  @param userId
	 * @param  @param cvId
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	 */
	Record checkBindCost(String userId, String cvId);
	
	/**
	 * 
	 * signUpInfo:
	 * TODO(直播课程报名)
	 *
	 * @param  @param userId
	 * @param  @param cvId
	 * @param  @return    
	 * @return Boolean    
	 * @throws 
	 * @since  　version 1.0
	 */
	void signUpInfo(String userId, String cvId);
	
	/**
	 * 
	 * checkSignUp:
	 * TODO(验证用户是否已报名过)
	 *
	 * @param  @param userId
	 * @param  @param cvId
	 * @param  @return    
	 * @return int    
	 * @throws 
	 * @since  　version 1.0
	 */
	boolean checkSignUp(String userId, String cvId);
	
	/**
	 * 
	 * selectByPrimaryKey:
	 * TODO(根据课程ID获取直播课程)
	 *
	 * @param  @param id
	 * @param  @return    
	 * @return CvLive    
	 * @throws 
	 * @since  　version 1.0
	 */
	CvLive selectByPrimaryKey(Integer id);
	
	/**
	 * 
	 * maintainLogStudySave:
	 * TODO(直播记录保存或更新)
	 *
	 * @param  @param userId
	 * @param  @param cvId
	 * @param  @return    
	 * @return String    
	 * @throws 
	 * @since  　version 1.0
	 */
	String maintainLogStudySave(String userId, String cvId);
	
}
