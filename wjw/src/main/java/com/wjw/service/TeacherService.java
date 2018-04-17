/**
 * TeacherService.java
 * com.wjw.service
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年10月9日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.wjw.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.model.ExpertInfo;

/**
 * ClassName:TeacherService
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年10月9日	上午10:51:55
 *
 * @see 	 
 *  
 */

public interface TeacherService {

	/**
	 * getTeachersByPage:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 * @param pageSize 
	 * @param pageCurrent 
	 *
	 * @param  @return    
	 * @return PageInfo<ExpertInfo>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	PageInfo<ExpertInfo> getTeachersByPage(ExpertInfo expertInfo, String pageCurrent, String pageSize);

	/**
	 * getTeachersByPageRecord:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param expertInfo
	 * @param  @param pageCurrent
	 * @param  @param pageSize    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	PageInfo<Record> getTeachersByPageRecord(ExpertInfo expertInfo, String pageCurrent, String pageSize);

	/**
	 * getExportById:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 * @param personage 
	 *
	 * @param      
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	ExpertInfo getExportById(String id, String personage);

	/**
	 * delTeacherById:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param id    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	boolean delTeacherById(Integer id);

	/**
	 * getTeachersByPageVo:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param expertInfo
	 * @param  @param pageNum
	 * @param  @param pageSize
	 * @param  @return    
	 * @return PageInfo<ExpertInfo>    
	 * @throws 
	 * @since  　version 1.0
	*/
	PageInfo<ExpertInfo> getTeachersByPageVo(ExpertInfo expertInfo, int pageNum, int pageSize);

    /**
     * 
     * getFamousTeacherList:
     * 获取名师列表
     *
     * @param  @param map
     * @param  @param pageCurrent
     * @param  @param pageSize
     * @param  @return    
     * @return PageInfo<ExpertInfo>    
     * @throws 
     * @since  　version 1.0
     */
	PageInfo<Record> getFamousTeacherList(Map<String,Object> map, String pageCurrent, String pageSize);
	
	/**
	 * 
	 * getCommitteeList:
	 * 获取专委会列表
	 *
	 * @param  @param map
	 * @param  @param pageCurrent
	 * @param  @param pageSize
	 * @param  @return    
	 * @return PageInfo<Record>    
	 * @throws 
	 * @since  　version 1.0
	 */
	PageInfo<Record> getCommitteeList(Map<String,Object> map, String pageCurrent, String pageSize);
	
	/**
	 * 
	 * getCommitteeDetail:
	 * 根据专委会ID,获取专委会详情
	 *
	 * @param  @param userId
	 * @param  @param specialId
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	 */
	Record getCommitteeDetail(Map<String,Object> map);
}
