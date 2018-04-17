/**
 * TopicDiscussionServiceImpl.java
 * com.wjw.service.impl
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月21日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.wjw.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.mapper.LogStudyCvUnitMapper;
import com.ncme.springboot.mapper.TopicDiscussionMapper;
import com.ncme.springboot.model.CvSetUnitDiscuss;
import com.ncme.springboot.model.CvUnit;
import com.ncme.springboot.model.LogStudyCvUnit;
import com.wjw.service.TopicDiscussionService;

/**
 * ClassName:TopicDiscussionServiceImpl
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月21日	上午10:17:35
 *
 * @see 	 
 *  
 */
@Service
public class TopicDiscussionServiceImpl implements TopicDiscussionService {
	
	@Autowired
	TopicDiscussionMapper topicDiscussionMapper;
	@Autowired
	LogStudyCvUnitMapper logStudyCvUnitMapper;
	/**
	 * 获取主题讨论
	 */
	@Override
	public Record getTopicDiscuss(String unitId) {
		
		// TODO Auto-generated method stub
		return topicDiscussionMapper.getTopicDiscuss(unitId);
		
	}

	/**
	 * 提交主题讨论内容
	 */
	
	@Override
	public void submitTopicDiscuss(CvSetUnitDiscuss discuss) {
		
		// TODO Auto-generated method stub
		 topicDiscussionMapper.submitTopicDiscuss(discuss);
		
	}

	/**
	 * 获取cvunit
	 */
	@Override
	public CvUnit getCvUnit(String unitId) {
		
		// TODO Auto-generated method stub
		return topicDiscussionMapper.getCvUnit(unitId);
		
	}

	/**
	 * (non-Javadoc)
	 * @see com.wjw.service.TopicDiscussionService#CountTalk(com.ncme.springboot.model.CvSetUnitDiscuss)
	 */
	@Override
	public int CountTalk(CvSetUnitDiscuss discussSum) {
		
		// TODO Auto-generated method stub
		return topicDiscussionMapper.CountTalk(discussSum);
		
	}

	/**
	 * (non-Javadoc)
	 * @see com.wjw.service.TopicDiscussionService#updateLogCvSetUnit(com.ncme.springboot.model.LogStudyCvUnit)
	 */
	@Override
	public int updateLogCvSetUnit(LogStudyCvUnit unit) {
		
		//return topicDiscussionMapper.updateLogCvSetUnit(unit);
		//根据单元id和用户id查询单元学习记录
				LogStudyCvUnit logStudyCvUnit = logStudyCvUnitMapper.getLogStudyByUnitIdAndUserId(unit.getSystemUserId(), unit.getCvUnitId());
				//如果该单元学习记录存在则更新，否则进行插入操作
				if (logStudyCvUnit != null) {
					LogStudyCvUnit log = new LogStudyCvUnit();
					log.setId(logStudyCvUnit.getId());
					log.setStatus(unit.getStatus());
					log.setLastUpdateDate(new Date());
					return logStudyCvUnitMapper.updateByPrimaryKeySelective(log);
				} else {
					
					unit.setLastUpdateDate(new Date());
					return logStudyCvUnitMapper.insert(unit);
				}
		
	}



	/**
	 * (non-Javadoc)
	 * @see com.wjw.service.TopicDiscussionService#getLastTopicDiscuss(int)
	 */
	@Override
	public Record getLastTopicDiscuss(int id) {
		
		// TODO Auto-generated method stub
		return topicDiscussionMapper.getLastTopicDiscuss(id);
		
	}

	@Override
	public Integer getTopicIdByUnitId(Integer unitId) {
		
		return topicDiscussionMapper.getTopicIdByUnitId(unitId);
		
	}

}
