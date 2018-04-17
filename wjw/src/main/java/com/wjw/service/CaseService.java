/**
 * CaseService.java
 * com.wjw.service
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月7日       juniorice
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.wjw.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.ncme.springboot.footstone.response.Record;

/**
 * ClassName:CaseService
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   xh
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月7日	下午4:21:02
 *
 * @see 	 
 *  
 */

public interface CaseService {

	/**
	 * 
	 * getCvList:(这里用一句话描述这个方法的作用)
	 * TODO(获取典型病例列表-同时根据type可获取VR/三维动画/名师课程)
	 *
	 * @param  @param map
	 * @param  @param pageCurrent
	 * @param  @param pageSize
	 * @param  @return    
	 * @return PageInfo<Record>    
	 * @throws 
	 * @since  　version 1.0
	 */
	PageInfo<Record> getCaseCvList(Map<String,Object> map, String pageCurrent, String pageSize);
	
	/**
	 * 
	 * getCvDetailById:(这里用一句话描述这个方法的作用)
	 * TODO(获取典型病例详情 –同时根据type可获取VR/三维动画/名师课程)
	 *
	 * @param  @param id
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	 */
	Record getCvDetailById(Map<String,Object> map);
	
	/**
	 * 
	 * getCvCatalogById:(这里用一句话描述这个方法的作用)
	 * TODO(获取典型病例目录 – 同时根据type可获取VR/三维动画/名师课程)
	 *
	 * @param  @param map
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	 */
	Record getCvCatalogById(Map<String,Object> map);
	
	//根据单元ID获取到 该单元 所在的课程ID,再根据 课程ID 获取 其课程 所在的 项目ID
	String getProjectIdByUnitId(String unitId);
	
}
