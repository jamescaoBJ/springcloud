package com.ncme.springboot.mapper;

import org.apache.ibatis.annotations.Param;

import com.ncme.springboot.model.LogStudyCv;

public interface LogStudyCvMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogStudyCv record);

    int insertSelective(LogStudyCv record);

    LogStudyCv selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogStudyCv record);

    int updateByPrimaryKey(LogStudyCv record);
    
    /**
     * getLogStudyCvByUserIdAndCvId:
     * 根据用户id和课程id查询课程学习记录表
     * @param  @param userId
     * @param  @param cvId
     * @param  @return    
     * @return LogStudyCv    
     * @throws 
     * @since  　version 1.0
    */
    LogStudyCv getLogStudyCvByUserIdAndCvId(@Param("userId")Integer userId, @Param("cvId")Integer cvId);
}