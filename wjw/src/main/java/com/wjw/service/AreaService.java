/**
 * AreaService.java
 * com.wjw.service
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月3日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.wjw.service;

import java.util.List;

import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.model.ExamPropVal;

/**
 * ClassName:AreaService
 * Function: TODO ADD 地区服务
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月3日	下午4:44:01
 *
 * @see 	 
 *  
 */

public interface AreaService {

	/**
	 * getProvince:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 * @param proviceName 
	 * @param proviceId 
	 *
	 * @param  @return    
	 * @return List<ExamPropVal>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	List<Record> getProvince(String proviceId, String proviceName);

	/**
	 * getCityByProvinceId:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param provinceId
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	List<Record> getCityByProvinceId(String provinceId);

	/**
	 * getCountyByCityId:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param cityId
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	List<Record> getCountyByCityId(String cityId);



}
