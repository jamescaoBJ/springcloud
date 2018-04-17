package com.ncme.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ncme.springboot.model.LogStudyCvUnit;

public interface LogStudyCvUnitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogStudyCvUnit record);

    int insertSelective(LogStudyCvUnit record);

    LogStudyCvUnit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogStudyCvUnit record);

    int updateByPrimaryKey(LogStudyCvUnit record);
    
    /**
     * queryLogStudyCVUnitByCVId:
     * 根据项目id和用户id查询该课程的学习记录(以最新更新时间倒序排序)
     * @param  @param userId
     * @param  @param cvSetId
     * @param  @return    
     * @return List<LogStudyCvUnit>    
     * @throws 
     * @since  　version 1.0
    */
    List<LogStudyCvUnit> queryLogStudyCVUnitByCvSetId(@Param("userId")Integer userId, @Param("cvSetId")Integer cvSetId);
    
    /**
     * updateStatusByUserIdAndUnitId:
     * 根据用户id和单元id更新学习状态
     * @param  @param userId
     * @param  @param unitId
     * @param  @return    
     * @return int    
     * @throws 
     * @since  　version 1.0
    */
    int updateStatusByUserIdAndUnitId(LogStudyCvUnit record);
    
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
	LogStudyCvUnit getLogStudyByUnitIdAndUserId(@Param("userId")Integer userId, @Param("unitId")Integer unitId);
}