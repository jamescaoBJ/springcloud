/**
 * HospitalService.java
 * com.wjw.service
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月13日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.wjw.service;

import java.util.List;

import com.ncme.springboot.footstone.response.Record;

/**
 * ClassName:HospitalService
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月13日	下午2:25:11
 *
 * @see 	 
 *  
 */

public interface HospitalService {

	/**
	 * getHospitalByArea:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 * @param keyWord 
	 *
	 * @param  @param countyId
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	List<Record> getHospitalByArea(String i, String keyWord);

}
