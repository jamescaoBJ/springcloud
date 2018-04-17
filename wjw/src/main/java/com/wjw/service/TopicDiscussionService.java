/**
 * TopicDiscussionService.java
 * com.wjw.service
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月21日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.wjw.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.model.CvSetUnitDiscuss;
import com.ncme.springboot.model.CvUnit;
import com.ncme.springboot.model.LogStudyCvUnit;

/**
 * ClassName:TopicDiscussionService
 * Function: TODO ADD 主题讨论服务
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月21日	上午10:17:07
 *
 * @see 	 
 *  
 */

public interface TopicDiscussionService {

	/**
	 * getTopicDiscuss: 获取主题讨论相关内容
	 * TODO(这里描述这个方法适用条件 – 可选)
	 * @param unitId 
	 *
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	Record getTopicDiscuss(String unitId);

	/**
	 * submitTopicDiscuss:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 * @param userId 
	 *
	 * @param  @param projectId
	 * @param  @param unitId
	 * @param  @param disscussContent
	 * @param  @return    
	 * @return int    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	void submitTopicDiscuss(CvSetUnitDiscuss discuss);

	/**
	 * getCvUnit:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param unitId
	 * @param  @return    
	 * @return CvUnit    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	CvUnit getCvUnit(@Param("unitId") String unitId);

	/**
	 * CountTalk:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param discussSum
	 * @param  @return    
	 * @return int    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	int CountTalk(CvSetUnitDiscuss discussSum);

	/**
	 * updateLogCvSetUnit:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param unit    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	int updateLogCvSetUnit(LogStudyCvUnit unit);



	/**
	 * getLastTopicDiscuss:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param id
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	Record getLastTopicDiscuss(int id);

	/**
	 * getTopicIdByUnitId:
	 * 根据单元id查询主题讨论id
	 * @param  @param unitId
	 * @param  @return    
	 * @return Integer    
	 * @throws 
	 * @since  　version 1.0
	*/
	Integer getTopicIdByUnitId(Integer unitId);
}
