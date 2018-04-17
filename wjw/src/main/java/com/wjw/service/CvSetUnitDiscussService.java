/**
 * CvSetUnitDiscussService.java
 * com.wjw.service
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月20日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.wjw.service;

import com.ncme.springboot.footstone.response.RtnBody;
import com.ncme.springboot.model.CvSetUnitDiscuss;
import com.ncme.springboot.model.CvSetUnitNote;

/**
 * ClassName:CvSetUnitDiscussService
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月20日	下午1:01:27
 *
 * @see 	 
 *  
 */

public interface CvSetUnitDiscussService {

	/**
	 * saveUnitDiscuss:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param cuc
	 * @param  @return    
	 * @return RtnBody    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	int saveUnitDiscuss(CvSetUnitDiscuss cuc);

	/**
	 * saveUnitNote:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param note
	 * @param  @return    
	 * @return int    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	int saveUnitNote(CvSetUnitNote note);

}
