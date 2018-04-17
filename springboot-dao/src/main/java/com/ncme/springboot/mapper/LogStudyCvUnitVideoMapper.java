package com.ncme.springboot.mapper;

import org.apache.ibatis.annotations.Param;

import com.ncme.springboot.model.LogStudyCvUnitVideo;

public interface LogStudyCvUnitVideoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogStudyCvUnitVideo record);

    int insertSelective(LogStudyCvUnitVideo record);

    LogStudyCvUnitVideo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogStudyCvUnitVideo record);

    int updateByPrimaryKey(LogStudyCvUnitVideo record);
    
    /**
     * getVideoLogByUserIdAndUnitId:
     * 根据用户id和单元id查询单元视频学习记录
     * @param  @param userId
     * @param  @param unitId
     * @param  @return    
     * @return LogStudyCvUnitVideo    
     * @throws 
     * @since  　version 1.0
    */
    LogStudyCvUnitVideo getVideoLogByUserIdAndUnitId(@Param("userId")Integer userId, @Param("unitId")Integer unitId);
}