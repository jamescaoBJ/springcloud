package com.wjw.service;

import com.ncme.springboot.footstone.response.Record;
import com.ncme.springboot.model.LogStudyCvUnit;

/**
 * ClassName:LogStudyCvUnitService
 * Function: 单元学习记录Service
 * Reason:	 TODO ADD REASON
 *
 * @author   lxy
 * @version  
 * @since    version 1.0
 * @Date	 2017年11月20日	下午4:43:38
 *
 * @see 	 
 *  
 */
public interface LogStudyCvUnitService {

	/**
	 * getCVUnitLogStudyByUnitIdAndUserId:
	 * 根据单元Id和userId查询单元的学习记录信息、单元信息
	 * @param  @param userId
	 * @param  @param unitId
	 * @param  @return    
	 * @return Record    
	 * @throws 
	 * @since  　version 1.0
	*/
	Record getCVUnitLogStudyByUnitIdAndUserId(Integer userId, Integer unitId);
	
	/**
	 * updateCvUnitLogStudyByUserIdAndUnitId:
	 * 根据用户id和单元id更新单元学习状态
	 * @param  @param userId
	 * @param  @param unitId
	 * @param  @return    
	 * @return int    
	 * @throws 
	 * @since  　version 1.0
	*/
	int updateCvUnitLogStudyByUserIdAndUnitId(LogStudyCvUnit logStudyCvUnit);
	
	/**
	 * getLogStudyByUnitIdAndUserId:
	 * 根据单元id和用户id查询单元学习记录（单表数据）
	 * @param  @param userId
	 * @param  @param unitId
	 * @param  @return    
	 * @return LogStudyCvUnit    
	 * @throws 
	 * @since  　version 1.0
	*/
	LogStudyCvUnit getLogStudyByUnitIdAndUserId(Integer userId, Integer unitId);
}
