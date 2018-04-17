package com.wjw.service;

import java.util.List;

import com.ncme.springboot.model.LogStudyCvSet;
import com.ncme.springboot.model.LogStudyCvUnitVideo;
import com.ncme.springboot.model.LogStudyCvUnitVideoCensus;

public interface LogStudyCvSetService {

	/**
	 * listLogStudyByCvSetId:
	 * 根据用户id和项目id查询
	 *
	 * @param  @param userId
	 * @param  @param cvSetId
	 * @param  @return    
	 * @return List<LogStudyCvSet>    
	 * @throws 
	 * @since  　version 1.0
	*/
	List<LogStudyCvSet> listLogStudyByCvSetId(Integer userId, Integer cvSetId);
	
	/**
	 * updateLogStudyCvSetById:
	 * 更新项目学习记录表
	 * @param  @param logStudyCvSet
	 * @param  @return    
	 * @return int    
	 * @throws 
	 * @since  　version 1.0
	*/
	int updateLogStudyCvSetById(LogStudyCvSet logStudyCvSet);
	
	/**
	 * updateCvForLogStudy:
	 * 课程学习记录表处理
	 * @param  @param userId
	 * @param  @param cvSetId
	 * @param  @param cvId    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	*/
	void updateCvForLogStudy(Integer userId, Integer cvSetId, Integer cvId);
	
	/**
	 * updateCVSetForLogStudy:
	 * 项目学习记录表处理
	 * @param  @param userId
	 * @param  @param cvSetId
	 * @param  @param cvId    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	*/
	void updateCVSetForLogStudy(Integer userId, Integer cvSetId, Integer cvId);
	
	/**
	 * updateCvUnitForLogStudy:
	 * 课程单元学习记录表处理
	 * @param  @param userId
	 * @param  @param cvSetId
	 * @param  @param cvId
	 * @param  @param cvUnitId    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	*/
	void updateCvUnitForLogStudy(Integer userId, Integer cvSetId, Integer cvId, Integer unitId);
	
	/**
	 * saveOrUpdateLogStudyCvUnitVideo:
	 * 课程单元视频学习记录处理
	 * @param  @param video    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	*/
	void saveOrUpdateLogStudyCvUnitVideo(LogStudyCvUnitVideo video);
	
	/**
	 * saveLogStudyCvUnitVideoCensus:
	 * 保存视频单元统计记录表
	 * @param  @param videoCensus    
	 * @return void    
	 * @throws 
	 * @since  　version 1.0
	*/
	void saveLogStudyCvUnitVideoCensus(LogStudyCvUnitVideoCensus videoCensus);
}
