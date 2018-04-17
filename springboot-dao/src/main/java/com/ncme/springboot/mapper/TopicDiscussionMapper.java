package com.ncme.springboot.mapper;


import org.apache.ibatis.annotations.Param;

import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.model.CvSetUnitDiscuss;
import com.ncme.springboot.model.CvUnit;
import com.ncme.springboot.model.LogStudyCvUnit;
import com.ncme.springboot.model.TopicDiscussion;

public interface TopicDiscussionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TopicDiscussion record);

    int insertSelective(TopicDiscussion record);

    TopicDiscussion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TopicDiscussion record);

    int updateByPrimaryKey(TopicDiscussion record);

	/**
	 * getTopicDiscuss: 获取主题讨论信息
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param unitId
	 * @param  @return    
	 * @return List<Record>    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	Record getTopicDiscuss(@Param("unitId") String unitId);

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
	 * @param  @return    
	 * @return int    
	 * @throws 
	 * @since  　version 1.0
	*/
	
	int updateLogCvSetUnit(LogStudyCvUnit unit);

	/**
	 * getLastTopicDiscuss:(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 *
	 * @param  @param id
	 * @param  @param projectId
	 * @param  @param unitId
	 * @param  @param disscussContent
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	*/
	

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
	
	Record getLastTopicDiscuss(@Param("id") int id);
	
	/**
	 * getTopicIdByUnitId:
	 * 得到主题讨论id
	 * @param  @param unitId
	 * @param  @return    
	 * @return Integer    
	 * @throws 
	 * @since  　version 1.0
	*/
	Integer getTopicIdByUnitId(@Param("unitId")Integer unitId);
}